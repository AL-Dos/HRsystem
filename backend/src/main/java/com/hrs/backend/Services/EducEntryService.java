package com.hrs.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.EducBackground.EducationEntryCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryUpdateDTO;
import com.hrs.backend.Mappers.Education.EducEntryMapper;
import com.hrs.backend.Models.EducBackground.EducationEntry;
import com.hrs.backend.Repos.EBRepo;
import com.hrs.backend.Repos.EducEntryRepo;
import com.hrs.backend.Repos.EducLevelRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducEntryService {
    private final EducEntryRepo repo;
    private final EducEntryMapper mapper;
    private final EducLevelRepo educLevelRepo;
    private final EBRepo ebRepo;

    public List<EducationEntryDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public EducationEntryDTO get(Integer id) {
        EducationEntry entity = repo.findById(id).orElseThrow(() -> new RuntimeException("EducationEntry not found"));
        return mapper.toDTO(entity);
    }

    public EducationEntryDTO create(EducationEntryCreateDTO dto) {
        ebRepo.findById(dto.getEducBackgroundId()).orElseThrow(() -> new RuntimeException("Invalid EducBackground ID"));
        educLevelRepo.findById(dto.getLevelId()).orElseThrow(() -> new RuntimeException("Invalid EducationLevel ID"));
        EducationEntry entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    public EducationEntryDTO update(Integer id, EducationEntryUpdateDTO dto) {
        EducationEntry entity = repo.findById(id).orElseThrow(() -> new RuntimeException("EducationEntry not found"));
        if (dto.getEducBackgroundId() != null) ebRepo.findById(dto.getEducBackgroundId()).orElseThrow(() -> new RuntimeException("Invalid EducBackground ID"));
        if (dto.getLevelId() != null) educLevelRepo.findById(dto.getLevelId()).orElseThrow(() -> new RuntimeException("Invalid EducationLevel ID"));
        mapper.updateEntityFromDTO(dto, entity);
        return mapper.toDTO(repo.save(entity));
    }
    
    public void delete(Integer id) { repo.deleteById(id); }    
}
