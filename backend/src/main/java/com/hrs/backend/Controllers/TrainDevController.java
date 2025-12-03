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

import com.hrs.backend.DTOs.Training.TrainDevCreateDTO;
import com.hrs.backend.DTOs.Training.TrainDevDTO;
import com.hrs.backend.DTOs.Training.TrainDevUpdateDTO;
import com.hrs.backend.Services.TrainDevService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/train-devevlopment")
@RequiredArgsConstructor
public class TrainDevController {
    private final TrainDevService service;
    
    @PostMapping
    public TrainDevDTO create(@RequestBody TrainDevCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public TrainDevDTO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping
    public List<TrainDevDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public TrainDevDTO update(@PathVariable Integer id, @RequestBody TrainDevUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }    
}
