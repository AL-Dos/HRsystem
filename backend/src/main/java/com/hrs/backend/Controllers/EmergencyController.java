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

import com.hrs.backend.DTOs.Emergency.EmergencyCreateDTO;
import com.hrs.backend.DTOs.Emergency.EmergencyDTO;
import com.hrs.backend.DTOs.Emergency.EmergencyUpdateDTO;
import com.hrs.backend.Services.EmergencyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/emergency-info")
@RequiredArgsConstructor
public class EmergencyController {
    private final EmergencyService service;
    
    @PostMapping
    public EmergencyDTO create(@RequestBody EmergencyCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EmergencyDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<EmergencyDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EmergencyDTO update(@PathVariable Integer id, @RequestBody EmergencyUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
