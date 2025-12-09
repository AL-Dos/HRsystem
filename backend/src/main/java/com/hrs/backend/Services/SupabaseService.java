package com.hrs.backend.Services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Service
@Slf4j
public class SupabaseService {
    private final WebClient storageClient;

    private final String supabaseUrl;
    private final String photosBucket;
    private final String signaturesBucket;

    public SupabaseService(
            @Qualifier("supabaseStorageClient") WebClient storageClient,
            @Value("${supabase.url}") String supabaseUrl,
            @Value("${supabase.bucket.person-photos}") String photosBucket,
            @Value("${supabase.bucket.person-signatures}") String signaturesBucket
    ) {
        this.storageClient = storageClient;
        this.supabaseUrl = supabaseUrl;  // now guaranteed non-null
        this.photosBucket = photosBucket;
        this.signaturesBucket = signaturesBucket;
    }

    public String uploadPhoto(MultipartFile file) throws IOException {
        return uploadFile(file, photosBucket);
    }

    public String uploadSignature(MultipartFile file) throws IOException {
        return uploadFile(file, signaturesBucket);
    }

    public String uploadFile(MultipartFile file, String bucket) throws IOException {
        String filename = UUID.randomUUID() + "_" + sanitize(file.getOriginalFilename());

        // Supabase REST requires this exact path
        String uri = "/object/" + bucket + "/" + filename + "?upsert=true";
        String contentType = file.getContentType() != null ? file.getContentType() : "application/octet-stream";

        @SuppressWarnings("null")
        ClientResponse resp = storageClient.post()
                .uri(uri)
                .contentType(MediaType.parseMediaType(contentType))
                .bodyValue(file.getBytes())
                .exchangeToMono(Mono::just)
                .block();

        String body = resp.bodyToMono(String.class).block();

        if (!resp.statusCode().is2xxSuccessful())
            throw new RuntimeException("Upload failed: " + body);

        return supabaseUrl + "/storage/v1/object/public/" + bucket + "/" + filename;
    }

    public void deleteFile(String bucket, String path) {
        String uri = "/object/" + bucket + "/" + path;

        try {
            storageClient.delete()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete file: " + e.getMessage());
        }
    }

    // WHY: Supabase URLs are predictable and safe to parse this way
    public void deleteFromPublicUrl(String publicUrl) {
        URI uri = URI.create(publicUrl);
        String[] parts = uri.getPath().split("/object/public/");
        if (parts.length != 2) return;

        String[] key = parts[1].split("/", 2);
        deleteFile(key[0], key[1]);
    }

    private String sanitize(String name) {
        if (name == null) return UUID.randomUUID().toString();
        return name.replaceAll("[^a-zA-Z0-9_.-]", "_");
    }
}