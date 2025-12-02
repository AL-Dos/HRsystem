package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.PersonalInfo.CitizenshipStatus;
import com.hrs.backend.Repos.CitiStatRepo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitizenStatService {

    private final CitiStatRepo repo;

        public List<CitizenshipStatus> findAll() { return repo.findAll(); }

    @NonNull
    public CitizenshipStatus findById(Integer id) { 
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public CitizenshipStatus create(CitizenshipStatus data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public CitizenshipStatus update(Integer id, CitizenshipStatus data) {
        CitizenshipStatus existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }

    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }
}

