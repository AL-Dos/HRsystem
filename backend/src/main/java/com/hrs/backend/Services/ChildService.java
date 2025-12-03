package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.FamilyBackground.ChildCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.ChildMapper;
import com.hrs.backend.Models.FamilyBackground.Child;
import com.hrs.backend.Repos.ChildRepo;
import com.hrs.backend.Repos.FBRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepo repo;
    private final FBRepo fbRepo;
    private final ChildMapper mapper;

    public List<ChildDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public ChildDTO get(Integer id) {
        Child entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Child not found!")); 
        return mapper.toDTO(entity); 
    }

    public ChildDTO create(ChildCreateDTO dto) { 
        fbRepo.findById(dto.getFamilyBackgroundId()).orElseThrow(() -> new RuntimeException("Invalid Family Background ID"));
        Child entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public ChildDTO update(Integer id, ChildUpdateDTO dto) {
        Child entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Child not found!"));
        if (dto.getFamilyBackgroundId() != null) fbRepo.findById(dto.getFamilyBackgroundId()).orElseThrow(() -> new RuntimeException("Invalid Family Background ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }  
}
