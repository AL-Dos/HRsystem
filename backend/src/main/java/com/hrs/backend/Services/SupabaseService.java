package com.hrs.backend.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.UUID;

@Service
public class SupabaseService {

    private final WebClient webClient;
    private final String supabaseUrl;
    private final String defaultBucket;

    public SupabaseService(WebClient supabaseWebClient,
                           @Value("${supabase.url}") String supabaseUrl,
                           @Value("${supabase.default-bucket:public}") String defaultBucket) {
        this.webClient = supabaseWebClient;
        this.supabaseUrl = supabaseUrl;
        this.defaultBucket = defaultBucket;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        return uploadFile(file, defaultBucket);
    }

    public String uploadFile(MultipartFile file, String bucket) throws IOException {
        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        byte[] bytes = file.getBytes();

        webClient.put()
                .uri(uriBuilder -> uriBuilder.path("/object/{bucket}/{path}")
                        .queryParam("upsert", "true")
                        .build(bucket, filename))
                .header("Content-Type", file.getContentType() == null ? "application/octet-stream" : file.getContentType())
                .bodyValue(bytes)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return supabaseUrl + "/storage/v1/object/public/" + bucket + "/" + filename;
    }

    public void deleteFile(String path, String bucket) {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder.path("/object/{bucket}/{path}")
                        .build(bucket, path))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
