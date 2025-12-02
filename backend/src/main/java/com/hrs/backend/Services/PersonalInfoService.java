package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;
import com.hrs.backend.Repos.PeronsalInfoRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {
    private final PeronsalInfoRepo repo;

    public List<PersonalInfo> findAll() { return repo.findAll(); }

    public PersonalInfo findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public PersonalInfo create(PersonalInfo data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public PersonalInfo update(Integer id, PersonalInfo data) {
        PersonalInfo existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
