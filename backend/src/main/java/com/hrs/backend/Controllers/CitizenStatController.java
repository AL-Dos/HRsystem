package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.Models.PersonalInfo.CitizenshipStatus;
import com.hrs.backend.Repos.CitiStatRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lookups/citizen-status")
@RequiredArgsConstructor
public class CitizenStatController {
    private final CitiStatRepo repo;

    @GetMapping
    public List<CitizenshipStatus> getAll() {
        return repo.findAll();
    }
}
