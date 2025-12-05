package com.hrs.backend.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.DTOs.Person.PersonCreateDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.Person.PersonUpdateDTO;
import com.hrs.backend.Services.PersonService;
import com.hrs.backend.Services.SupabaseService;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.net.URI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;
    private final SupabaseService supabaseService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PersonDTO create(
            @RequestPart("dto") PersonCreateDTO dto,
            @RequestPart(value = "person-photos", required = false) MultipartFile photo,
            @RequestPart(value = "person-signatures", required = false) MultipartFile signature
    ) throws IOException {
        if (photo != null && !photo.isEmpty()) {
            String photoUrl = supabaseService.uploadPhoto(photo);
            dto.setPhotoUrl(photoUrl);
        }
        if (signature != null && !signature.isEmpty()) {
            String sigUrl = supabaseService.uploadSignature(signature);
            dto.setSignature(sigUrl);
        }
        return service.create(dto);
    }

    // JSON-only fallback for clients that send raw JSON
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO createJson(@RequestBody PersonCreateDTO dto) {
        return service.create(dto);
    }
    
    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<PersonDTO> getAll() {
        return service.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PersonDTO update(
            @PathVariable Integer id,
            @RequestPart("dto") PersonUpdateDTO dto,
            @RequestPart(value = "person-photos", required = false) MultipartFile photo,
            @RequestPart(value = "person-signatures", required = false) MultipartFile signature
    ) throws IOException {
        // Get existing person to retrieve old file URLs for cleanup
        PersonDTO existing = service.get(id);
        
        if (photo != null && !photo.isEmpty()) {
            // Delete old photo if it exists
            if (existing.getPhotoUrl() != null && !existing.getPhotoUrl().isEmpty()) {
                deleteSupabaseFile(existing.getPhotoUrl());
            }
            String photoUrl = supabaseService.uploadPhoto(photo);
            dto.setPhotoUrl(photoUrl);
        }
        if (signature != null && !signature.isEmpty()) {
            // Delete old signature if it exists
            if (existing.getSignature() != null && !existing.getSignature().isEmpty()) {
                deleteSupabaseFile(existing.getSignature());
            }
            String sigUrl = supabaseService.uploadSignature(signature);
            dto.setSignature(sigUrl);
        }
        return service.update(id, dto);
    }

    // JSON-only fallback for update
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO updateJson(@PathVariable Integer id, @RequestBody PersonUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        // Get person and delete associated files before removing the record
        PersonDTO person = service.get(id);
        if (person.getPhotoUrl() != null && !person.getPhotoUrl().isEmpty()) {
            deleteSupabaseFile(person.getPhotoUrl());
        }
        if (person.getSignature() != null && !person.getSignature().isEmpty()) {
            deleteSupabaseFile(person.getSignature());
        }
        service.delete(id);
    }
  
    // Helper method to extract file path from Supabase URL and delete it.
    private void deleteSupabaseFile(String fileUrl) {
        try {
            String path = URI.create(fileUrl).getPath();
            // Extract bucket and file path from /storage/v1/object/public/<bucket>/<file>
            String[] parts = path.split("/storage/v1/object/public/");
            if (parts.length == 2) {
                String[] bucketAndFile = parts[1].split("/", 2);
                if (bucketAndFile.length == 2) {
                    String bucket = bucketAndFile[0];
                    String filePath = bucketAndFile[1];
                    supabaseService.deleteFile(filePath, bucket);
                }
            }
        } catch (Exception e) {
            // Log error but don't fail the operation
            System.err.println("Failed to delete file from Supabase: " + fileUrl + ", error: " + e.getMessage());
        }
    }

    @PostMapping(value = "/upload-test", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String testUpload(@RequestPart("file") MultipartFile file) throws IOException {
        return supabaseService.uploadPhoto(file);
    }
}