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

import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoCreateDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoUpdateDTO;
import com.hrs.backend.Services.PersonalInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/personal-info")
@RequiredArgsConstructor
public class PersonalInfoController {
    private final PersonalInfoService service;

    @PostMapping
    public PersonalInfoDTO create(@RequestBody PersonalInfoCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public PersonalInfoDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<PersonalInfoDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PersonalInfoDTO update(@PathVariable Integer id, @RequestBody PersonalInfoUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
