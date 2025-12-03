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

import com.hrs.backend.DTOs.CivilService.CivilServiceCreateDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceUpdateDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/civil-service")
@RequiredArgsConstructor
public class CivilServController {
    private final CivilServController service;

    @PostMapping
    public CivilServiceDTO create(@RequestBody CivilServiceCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CivilServiceDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<CivilServiceDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public CivilServiceDTO update(@PathVariable Integer id, @RequestBody CivilServiceUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
