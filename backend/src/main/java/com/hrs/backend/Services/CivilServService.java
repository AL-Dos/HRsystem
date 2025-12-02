package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.CivilService;
import com.hrs.backend.Repos.CivilServRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CivilServService {
    private final CivilServRepo repo;

    public List<CivilService> findAll() { return repo.findAll(); }

    public CivilService findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public CivilService create(CivilService data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public CivilService update(Integer id, CivilService data) {
        CivilService existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
