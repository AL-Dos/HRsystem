package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.PersonalInfo.CitizenshipType;
import com.hrs.backend.Repos.CitiTypeRepo;

import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Service
@RequiredArgsConstructor
public class CitiTypeService {
    private final CitiTypeRepo repo;

    public List<CitizenshipType> findAll() { return repo.findAll(); }

    @NonNull
    public CitizenshipType findById(Integer id) { 
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public CitizenshipType create(CitizenshipType data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public CitizenshipType update(Integer id, CitizenshipType data) {
        CitizenshipType existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }

    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }
}
