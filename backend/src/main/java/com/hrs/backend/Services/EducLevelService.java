package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.EducBackground.EducationLevel;
import com.hrs.backend.Repos.EducLevelRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducLevelService {
    private final EducLevelRepo repo;

    public List<EducationLevel> findAll() { return repo.findAll(); }

    public EducationLevel findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public EducationLevel create(EducationLevel data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public EducationLevel update(Integer id, EducationLevel data) {
        EducationLevel existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
