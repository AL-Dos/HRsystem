package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.WorkExperience;
import com.hrs.backend.Repos.WorkExpRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkExpService {
    private final WorkExpRepo repo;

    public List<WorkExperience> findAll() { return repo.findAll(); }

    public WorkExperience findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public WorkExperience create(WorkExperience data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public WorkExperience update(Integer id, WorkExperience data) {
        WorkExperience existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }      
}
