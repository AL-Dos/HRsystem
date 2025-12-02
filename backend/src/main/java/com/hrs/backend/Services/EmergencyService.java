package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.EmergencyInfo;
import com.hrs.backend.Repos.EmergencyRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmergencyService {
    private final EmergencyRepo repo;

    public List<EmergencyInfo> findAll() { return repo.findAll(); }

    public EmergencyInfo findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public EmergencyInfo create(EmergencyInfo data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public EmergencyInfo update(Integer id, EmergencyInfo data) {
        EmergencyInfo existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }     

}
