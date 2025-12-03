package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.Models.PersonalInfo.Sex;
import com.hrs.backend.Repos.SexRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lookups/sex")
@RequiredArgsConstructor
public class SexController {
    private final SexRepo repo;

    @GetMapping
    public List<Sex> getAll() {
        return repo.findAll();
    }
}
