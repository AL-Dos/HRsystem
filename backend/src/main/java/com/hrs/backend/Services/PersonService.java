package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.Person.PersonCreateDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.Person.PersonUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Models.Person;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepo repo;
    private final PersonMapper mapper;
    private final RefNumService service;

    public List<PersonDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public PersonDTO get(Integer id) {
        Person entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Person not found!")); 
    return mapper.toDTO(entity); 
    }

    public PersonDTO create(PersonCreateDTO dto) { 
        Person entity = mapper.toEntity(dto);
        entity.setReferenceNumber(service.generateRefNum()); // Auto-gen ref num
        return mapper.toDTO(repo.save(entity)); 
    }

    public PersonDTO update(Integer id, PersonUpdateDTO data) {
        Person entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Person not found!"));
        mapper.updateEntityFromDTO(data, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }    
}
