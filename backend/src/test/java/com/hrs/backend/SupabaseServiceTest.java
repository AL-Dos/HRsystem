package com.hrs.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.hrs.backend.Services.SupabaseService;

import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class SupabaseServiceTest {
    @Mock
    private WebClient projectClient;
    @Mock
    private WebClient storageClient;
    private SupabaseService service;

    @BeforeEach
    void setup() {
        projectClient = mock(WebClient.class, RETURNS_DEEP_STUBS);
        storageClient = mock(WebClient.class, RETURNS_DEEP_STUBS);

        service = new SupabaseService(
                projectClient,
                "https://xyzcompany.supabase.co",
                "person-photos",
                "person-signatures"
        );
    }

    @Test
    void testUploadFile_success() throws Exception {
        // mock file
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("test.png");
        when(file.getBytes()).thenReturn("dummy".getBytes());
        when(file.getContentType()).thenReturn("image/png");

        // mock chain
        WebClient.RequestBodyUriSpec postSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec bodySpec = mock(WebClient.RequestBodySpec.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));

        ClientResponse clientResponse = mock(ClientResponse.class);

        // chain:
        when(storageClient.post()).thenReturn(postSpec);
        when(postSpec.uri(anyString())).thenReturn(postSpec);
        when(postSpec.contentType(any())).thenReturn(postSpec);

        when(bodySpec.exchangeToMono(any())).thenReturn(Mono.just(clientResponse));

        when(clientResponse.statusCode()).thenReturn(HttpStatus.OK);
        when(clientResponse.bodyToMono(String.class)).thenReturn(Mono.just("{}"));

        // call
        String result = service.uploadFile(file, "person-photos");

        // verify
        assertTrue(result.contains("person-photos"));
        assertTrue(result.contains(".png"));
    }

    @Test
    void testUploadFile_failure() throws Exception {
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("test.png");
        when(file.getBytes()).thenReturn("dummy-data".getBytes());
        when(file.getContentType()).thenReturn("image/png");

        WebClient.RequestBodyUriSpec postSpec = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.RequestBodySpec bodySpec = mock(WebClient.RequestBodySpec.class);
        ClientResponse response = mock(ClientResponse.class);

        when(storageClient.post()).thenReturn(postSpec);
        when(postSpec.uri(anyString())).thenReturn(postSpec);
        when(postSpec.contentType(any())).thenReturn(postSpec);

        when(bodySpec.exchangeToMono(any())).thenReturn(Mono.just(response));

        when(response.statusCode()).thenReturn(HttpStatus.BAD_REQUEST);
        when(response.bodyToMono(String.class)).thenReturn(Mono.just("{\"error\":\"bad\"}"));

        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                service.uploadFile(file, "person-photos")
        );

        assertTrue(ex.getMessage().contains("Upload failed"));
        assertTrue(ex.getMessage().contains("bad"));     // Stronger validation
    }

    @Test
    void testDeleteFromPublicUrl() {
        SupabaseService spyService = spy(service);

        String url = "https://xyzcompany.supabase.co/storage/v1/object/public/person-photos/123.png";

        doNothing().when(spyService).deleteFile("person-photos", "123.png");

        spyService.deleteFromPublicUrl(url);

        verify(spyService, times(1)).deleteFile("person-photos", "123.png");
    }
}
