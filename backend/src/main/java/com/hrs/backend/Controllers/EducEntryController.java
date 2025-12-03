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

import com.hrs.backend.DTOs.EducBackground.EducationEntryCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryUpdateDTO;
import com.hrs.backend.Services.EducEntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/education-entry")
@RequiredArgsConstructor
public class EducEntryController {
    private final EducEntryService service;

    @PostMapping
    public EducationEntryDTO create(@RequestBody EducationEntryCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EducationEntryDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<EducationEntryDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EducationEntryDTO update(@PathVariable Integer id, @RequestBody EducationEntryUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
