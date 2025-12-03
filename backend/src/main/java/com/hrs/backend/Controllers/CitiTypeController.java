package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.Models.PersonalInfo.CitizenshipType;
import com.hrs.backend.Repos.CitiTypeRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lookups/citizenship-type")
@RequiredArgsConstructor
public class CitiTypeController {
    private final CitiTypeRepo repo;

    @GetMapping
    public List<CitizenshipType> getAll() {
        return repo.findAll();
    }   
}
