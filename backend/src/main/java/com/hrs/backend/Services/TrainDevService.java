package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.Training.TrainDevCreateDTO;
import com.hrs.backend.DTOs.Training.TrainDevDTO;
import com.hrs.backend.DTOs.Training.TrainDevUpdateDTO;
import com.hrs.backend.Mappers.ProfessionalInfo.TrainDevMapper;
import com.hrs.backend.Models.TrainingDevelopment;
import com.hrs.backend.Repos.PersonRepo;
import com.hrs.backend.Repos.TrainDevRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainDevService {
    private final TrainDevRepo repo;
    private final PersonRepo personRepo;
    private final TrainDevMapper mapper;

    public List<TrainDevDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public TrainDevDTO get(Integer id) {
        TrainingDevelopment entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
        return mapper.toDTO(entity);
    }

    public TrainDevDTO create(TrainDevCreateDTO dto) {
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        TrainingDevelopment entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public TrainDevDTO update(Integer id, TrainDevUpdateDTO dto) {
        TrainingDevelopment entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
        if (dto.getPersonId() != null) personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Invalid Person ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }       
}
