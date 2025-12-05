package com.hrs.backend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/supabase")
@RequiredArgsConstructor
public class SupabaseController {

    private final WebClient supabaseWebClient;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        try {
            String response = supabaseWebClient
                    .get()
                    .uri("/buckets")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return ResponseEntity.ok("Connected to Supabase!\nBuckets:\n" + response);

        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("FAILED to connect to Supabase:\n" + e.getMessage());
        }
    }
}