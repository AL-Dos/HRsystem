package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoCreateDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonalInfoMapper;
import com.hrs.backend.Models.PersonalInfo.PersonalInfo;
import com.hrs.backend.Repos.CitiStatRepo;
import com.hrs.backend.Repos.CitiTypeRepo;
import com.hrs.backend.Repos.CivilStatRepo;
import com.hrs.backend.Repos.PeronsalInfoRepo;
import com.hrs.backend.Repos.PersonRepo;
import com.hrs.backend.Repos.SexRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {
    private final PeronsalInfoRepo repo;
    private final PersonalInfoMapper mapper;
    private final SexRepo sexRepo;
    private final CivilStatRepo civilStatRepo;
    private final CitiTypeRepo citiTypeRepo;
    private final CitiStatRepo citiStatRepo;
    private final PersonRepo personRepo;

    public List<PersonalInfoDTO> getAll() { return repo.findAll().stream().map(mapper::toDTO).toList(); }

    public PersonalInfoDTO get(Integer id) {
        PersonalInfo entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Personal Info not found!")); 
        return mapper.toDTO(entity); 
    }

    public PersonalInfoDTO create(PersonalInfoCreateDTO dto) {
        sexRepo.findById(dto.getSexId()).orElseThrow(() -> new RuntimeException("Sex not found!"));
        civilStatRepo.findById(dto.getCivilStatusId()).orElseThrow(() -> new RuntimeException("Civil Status not found!"));
        citiTypeRepo.findById(dto.getCitizenshipTypeId()).orElseThrow(() -> new RuntimeException("Citizenship Type not found!"));
        citiStatRepo.findById(dto.getCitizenStatusId()).orElseThrow(() -> new RuntimeException("Citizenship Status not found!"));
        personRepo.findById(dto.getPersonId()).orElseThrow(() -> new RuntimeException("Person not found!")); 
        PersonalInfo entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity)); 
    }

    public PersonalInfoDTO update(Integer id, PersonalInfoUpdateDTO dto) {
        PersonalInfo entity = repo.findById(id).orElseThrow(() -> new RuntimeException("Personal Info not found!"));
        if (dto.getSexId() != null) sexRepo.findById(dto.getSexId()).orElseThrow(() -> new RuntimeException("Invalid Sex ID"));
        if (dto.getCivilStatusId() != null) civilStatRepo.findById(dto.getCivilStatusId()).orElseThrow(() -> new RuntimeException("Invalid Civil Status ID"));
        if (dto.getCitizenshipTypeId() != null) citiTypeRepo.findById(dto.getCitizenshipTypeId()).orElseThrow(() -> new RuntimeException("Invalid Citizenship Type ID"));
        if (dto.getCitizenStatusId() != null) citiStatRepo.findById(dto.getCitizenStatusId()).orElseThrow(() -> new RuntimeException("Invalid Citizenship Status ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }

    public void delete(Integer id) { repo.deleteById(id); }    
}
