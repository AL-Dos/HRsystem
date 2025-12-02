package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.FamilyBackground.FamilyBackground;
import com.hrs.backend.Repos.FBRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FBService {
    private final FBRepo repo;

    public List<FamilyBackground> findAll() { return repo.findAll(); }

    public FamilyBackground findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public FamilyBackground create(FamilyBackground data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public FamilyBackground update(Integer id, FamilyBackground data) {
        FamilyBackground existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
