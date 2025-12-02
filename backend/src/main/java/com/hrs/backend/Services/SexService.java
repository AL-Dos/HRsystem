package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.PersonalInfo.Sex;
import com.hrs.backend.Repos.SexRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SexService {
    private final SexRepo repo;

    public List<Sex> findAll() { return repo.findAll(); }

    public Sex findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public Sex create(Sex data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public Sex update(Integer id, Sex data) {
        Sex existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }        
}
