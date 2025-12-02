package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.EducBackground.EducationEntry;
import com.hrs.backend.Repos.EducEntryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducEntryService {
    private final EducEntryRepo repo;

    public List<EducationEntry> findAll() { return repo.findAll(); }

    public EducationEntry findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public EducationEntry create(EducationEntry data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public EducationEntry update(Integer id, EducationEntry data) {
        EducationEntry existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
