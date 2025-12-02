package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.PersonalInfo.CivilStatus;
import com.hrs.backend.Repos.CivilStatRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CivilStatService {
    private final CivilStatRepo repo;

    public List<CivilStatus> findAll() { return repo.findAll(); }

    public CivilStatus findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public CivilStatus create(CivilStatus data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public CivilStatus update(Integer id, CivilStatus data) {
        CivilStatus existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
