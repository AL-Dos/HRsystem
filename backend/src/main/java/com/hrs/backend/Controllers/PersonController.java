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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;
    private final SupabaseService supabase;

    @GetMapping
    public List<PersonDTO> getAll() {
        return service.getAll();
    }

@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public PersonDTO create(
            @RequestPart("dto") PersonCreateDTO dto,
            @RequestPart(value = "person-photos", required = false) MultipartFile photo,
            @RequestPart(value = "person-signatures", required = false) MultipartFile sig
    ) throws IOException {

        if (photo != null && !photo.isEmpty())
            dto.setPhotoUrl(supabase.uploadPhoto(photo));

        if (sig != null && !sig.isEmpty())
            dto.setSignature(supabase.uploadSignature(sig));

        return service.create(dto);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public PersonDTO update(
            @PathVariable Integer id,
            @RequestPart("dto") PersonUpdateDTO dto,
            @RequestPart(value = "person-photos", required = false) MultipartFile photo,
            @RequestPart(value = "person-signatures", required = false) MultipartFile sig
    ) throws IOException {

        PersonDTO existing = service.get(id);

        if (photo != null && !photo.isEmpty()) {
            supabase.deleteFromPublicUrl(existing.getPhotoUrl());
            dto.setPhotoUrl(supabase.uploadPhoto(photo));
        }

        if (sig != null && !sig.isEmpty()) {
            supabase.deleteFromPublicUrl(existing.getSignature());
            dto.setSignature(supabase.uploadSignature(sig));
        }

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        PersonDTO p = service.get(id);

        supabase.deleteFromPublicUrl(p.getPhotoUrl());
        supabase.deleteFromPublicUrl(p.getSignature());

        service.delete(id);
    }
}
