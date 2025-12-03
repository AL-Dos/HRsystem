package com.hrs.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backend.DTOs.Person.PersonCreateDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.Person.PersonUpdateDTO;
import com.hrs.backend.Services.PersonService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @PostMapping
    public PersonDTO create(@RequestBody PersonCreateDTO dto) {
        return service.create(dto);
    }
    
    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<PersonDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Integer id, @RequestBody PersonUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
