package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.FamilyBackground.Child;
import com.hrs.backend.Repos.ChildRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepo repo;

    public List<Child> findAll() { return repo.findAll(); }

    public Child findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public Child create(Child data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public Child update(Integer id, Child data) {
        Child existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }  
}
