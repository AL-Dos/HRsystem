package com.hrs.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.DTOs.EducBackground.EducBackgroundCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundUpdateDTO;
import com.hrs.backend.Services.EBService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educational-background")
@RequiredArgsConstructor
public class EducBackController {
    private final EBService service;

    @PostMapping
    public EducBackgroundDTO create(@RequestBody EducBackgroundCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EducBackgroundDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<EducBackgroundDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EducBackgroundDTO update(@PathVariable Integer id, @RequestBody EducBackgroundUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }    
}
