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

import com.hrs.backend.DTOs.WorkExp.WorkExpCreateDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpUpdateDTO;
import com.hrs.backend.Services.WorkExpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/work-experiences")
@RequiredArgsConstructor
public class WorkExpController {
    private final WorkExpService service;

    @PostMapping
    public WorkExpDTO create(@RequestBody WorkExpCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public WorkExpDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<WorkExpDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public WorkExpDTO update(@PathVariable Integer id, @RequestBody WorkExpUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }    
}
