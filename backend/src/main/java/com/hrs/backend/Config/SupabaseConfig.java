package com.hrs.backend.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SupabaseConfig {

    @Bean(name = "supabaseProjectClient")
    public WebClient supabaseProjectClient(@Value("${supabase.url}") String url, @Value("${supabase.key}") String key) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + key)
                .defaultHeader("apikey", key)
                .build();
    }

    @Bean(name = "supabaseStorageClient")
    public WebClient supabaseStorageClient(@Value("${supabase.url}") String url, @Value("${supabase.key}") String key) {
        return WebClient.builder()
                .baseUrl(url + "/storage/v1")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + key)
                .defaultHeader("apikey", key)
                .build();
    }
}