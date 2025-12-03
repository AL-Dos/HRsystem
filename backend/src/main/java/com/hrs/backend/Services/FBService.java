package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.FamBackgroundMapper;
import com.hrs.backend.Models.FamilyBackground.FamilyBackground;
import com.hrs.backend.Repos.FBRepo;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FBService {
    private final FBRepo repo;
    private final PersonRepo personRepo;
    private final FamBackgroundMapper mapper;

    public List<FamilyBackgroundDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }
    
    public FamilyBackgroundDTO get(Integer id) {
        FamilyBackground entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Family Background not found!")); 
        return mapper.toDTO(entity); 
    }
    
    public FamilyBackgroundDTO create(FamilyBackgroundCreateDTO dto) { 
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        FamilyBackground entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public FamilyBackgroundDTO update(Integer id, FamilyBackgroundUpdateDTO dto) {
        FamilyBackground entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Family Background not found!"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }    
}
