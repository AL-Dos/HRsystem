package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.Models.EducBackground.EducationLevel;
import com.hrs.backend.Repos.EducLevelRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lookups/educ-level")
@RequiredArgsConstructor
public class EducLevelController {
    private final EducLevelRepo repo;

    @GetMapping
    public List<EducationLevel> getAll() {
        return repo.findAll();
    }
}
