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

import com.hrs.backend.DTOs.FamilyBackground.ChildCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildUpdateDTO;
import com.hrs.backend.Services.ChildService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/children")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService service;

    @PostMapping
    public ChildDTO create(@RequestBody ChildCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ChildDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<ChildDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ChildDTO update(@PathVariable Integer id, @RequestBody ChildUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
