package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.Emergency.EmergencyCreateDTO;
import com.hrs.backend.DTOs.Emergency.EmergencyDTO;
import com.hrs.backend.DTOs.Emergency.EmergencyUpdateDTO;
import com.hrs.backend.Mappers.ProfessionalInfo.EmergencyMapper;
import com.hrs.backend.Models.EmergencyInfo;
import com.hrs.backend.Repos.EmergencyRepo;
import com.hrs.backend.Repos.PersonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmergencyService {
    private final EmergencyRepo repo;
    private final PersonRepo personRepo;
    private final EmergencyMapper mapper;

    public List<EmergencyDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public EmergencyDTO get(Integer id) {
        EmergencyInfo entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Emergency contact not found"));
        return mapper.toDTO(entity);
    }

    public EmergencyDTO create(EmergencyCreateDTO dto) {
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        EmergencyInfo entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public EmergencyDTO update(Integer id, EmergencyUpdateDTO dto) {
        EmergencyInfo entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Emergency contact not found"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }     
}
