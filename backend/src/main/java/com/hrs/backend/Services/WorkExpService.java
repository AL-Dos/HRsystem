package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.WorkExp.WorkExpCreateDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpUpdateDTO;
import com.hrs.backend.Mappers.ProfessionalInfo.WorkExpMapper;
import com.hrs.backend.Models.WorkExperience;
import com.hrs.backend.Repos.PersonRepo;
import com.hrs.backend.Repos.WorkExpRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkExpService {
    private final WorkExpRepo repo;
    private final PersonRepo personRepo;
    private final WorkExpMapper mapper;

    public List<WorkExpDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public WorkExpDTO get(Integer id) {
        WorkExperience entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Work Experience not found"));
        return mapper.toDTO(entity);
    }

    public WorkExpDTO create(WorkExpCreateDTO dto) {
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        WorkExperience entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public WorkExpDTO update(Integer id, WorkExpUpdateDTO dto) {
        WorkExperience entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Work Experience not found"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Integer id) { repo.deleteById(id); }      
}
