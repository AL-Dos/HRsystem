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

import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundUpdateDTO;
import com.hrs.backend.Services.FBService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/family-background")
@RequiredArgsConstructor
public class FBController {
    private final FBService service;
    
    @PostMapping
    public FamilyBackgroundDTO create(@RequestBody FamilyBackgroundCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public FamilyBackgroundDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<FamilyBackgroundDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public FamilyBackgroundDTO update(@PathVariable Integer id, @RequestBody FamilyBackgroundUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
