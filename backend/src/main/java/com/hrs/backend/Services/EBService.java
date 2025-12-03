package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.EducBackground.EducBackgroundCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundUpdateDTO;
import com.hrs.backend.Mappers.Education.EducBackgroundMapper;
import com.hrs.backend.Models.EducBackground.EducBackground;
import com.hrs.backend.Repos.EBRepo;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EBService {
    private final EBRepo repo;
    private final EducBackgroundMapper mapper;
    private final PersonRepo personRepo;

    public List<EducBackgroundDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public EducBackgroundDTO get(Integer id) {
        EducBackground entity = repo.findById(id).orElseThrow(() -> new RuntimeException("EducBackground not found"));
        return mapper.toDTO(entity);
    }

    public EducBackgroundDTO create(EducBackgroundCreateDTO dto) {
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        EducBackground entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public EducBackgroundDTO update(Integer id, EducBackgroundUpdateDTO dto) {
        EducBackground entity = repo.findById(id).orElseThrow(() -> new RuntimeException("EducBackground not found"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }    
}
