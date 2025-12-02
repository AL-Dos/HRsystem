package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.EducBackground.EducBackground;
import com.hrs.backend.Repos.EBRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EBService {
    private final EBRepo repo;

    public List<EducBackground> findAll() { return repo.findAll(); }

    public EducBackground findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public EducBackground create(EducBackground data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public EducBackground update(Integer id, EducBackground data) {
        EducBackground existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
