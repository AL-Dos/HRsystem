package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.CivilService.CivilServiceCreateDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceUpdateDTO;
import com.hrs.backend.Mappers.ProfessionalInfo.CivilServMapper;
import com.hrs.backend.Models.CivilService;
import com.hrs.backend.Repos.CivilServRepo;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CivilServService {
    private final CivilServRepo repo;
    private final CivilServMapper mapper;
    private final PersonRepo personRepo;

    public List<CivilServiceDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public CivilServiceDTO get(Integer id) {
        CivilService entity = repo.findById(id).orElseThrow(() -> new RuntimeException("CivilService not found"));
        return mapper.toDTO(entity);
    }  
    
    public CivilServiceDTO create(CivilServiceCreateDTO dto) {
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        CivilService entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public CivilServiceDTO update(Integer id, CivilServiceUpdateDTO dto) {
        CivilService entity = repo.findById(id).orElseThrow(() -> new RuntimeException("CivilService not found"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    public void delete(Integer id) { repo.deleteById(id); }    
}
