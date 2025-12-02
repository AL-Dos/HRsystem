package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.TrainingDevelopment;
import com.hrs.backend.Repos.TrainDevRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainDevService {
    private final TrainDevRepo repo;

    public List<TrainingDevelopment> findAll() { return repo.findAll(); }

    public TrainingDevelopment findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public TrainingDevelopment create(TrainingDevelopment data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public TrainingDevelopment update(Integer id, TrainingDevelopment data) {
        TrainingDevelopment existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }       
}
