package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.Models.PersonalInfo.CivilStatus;
import com.hrs.backend.Repos.CivilStatRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lookups/civil-status")
@RequiredArgsConstructor
public class CivilStatController {
    private final CivilStatRepo repo;

    @GetMapping
    public List<CivilStatus> getAll() {
        return repo.findAll();
    }
}
