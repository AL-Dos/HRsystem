package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.Models.Person;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo repo;

    public List<Person> findAll() { return repo.findAll(); }

    public Person findById(Integer id) {
        if (id == null) throw new RuntimeException("Id cannot be null!");
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Citizenship not found!")); 
    }

    public Person create(Person data) { 
        if (data == null) throw new RuntimeException("Data cannot be null!");
        return repo.save(data); 
    }

    public Person update(Integer id, Person data) {
        Person existing = findById(id);
        data.setId(existing.getId());
        return repo.save(data);
    }
    
    @SuppressWarnings("null")
    public void delete(Integer id) { repo.delete(findById(id)); }    
}
