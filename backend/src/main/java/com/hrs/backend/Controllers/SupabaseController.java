package com.hrs.backend.Controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/supabase")
public class SupabaseController {

    private final WebClient storageClient;

    public SupabaseController(@Qualifier("supabaseStorageClient") WebClient storageClient) {
        this.storageClient = storageClient;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> listBuckets() {
        try {
            String response = storageClient
                    .get()
                    .uri("/bucket")   // most Supabase installations use this
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return ResponseEntity.ok(response);

        } catch (Exception e1) {
            try {
                // fallback for older Supabase versions
                String response2 = storageClient
                        .get()
                        .uri("/buckets")
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                return ResponseEntity.ok(response2);

            } catch (Exception e2) {
                return ResponseEntity.status(500)
                        .body("Failed to fetch buckets:\n" + e2.getMessage());
            }
        }
    }
}
