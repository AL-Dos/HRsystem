package com.hrs.backend.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SupabaseConfig {

	@Value("${supabase.url}")
	private String supabaseUrl;

	@Value("${supabase.key}")
	private String supabaseKey;

	@Bean
	public WebClient supabaseWebClient(WebClient.Builder builder) {
		return builder
				.baseUrl(supabaseUrl + "/storage/v1")
				.defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + supabaseKey)
				.defaultHeader("apikey", supabaseKey)
				.build();
	}
}