package com.hrs.backend.Mappers.Education;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.EducBackground.EducationEntryCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryUpdateDTO;
import com.hrs.backend.Mappers.Lookups.EducationLevelMapper;
import com.hrs.backend.Models.EducBackground.EducationEntry;

@Mapper(componentModel = "spring", uses = { EducBackgroundMapper.class, EducationLevelMapper.class })
public interface EducEntryMapper {
    EducationEntryDTO toDTO(EducationEntry entity);
    List<EducationEntryDTO> toDTOList(List<EducationEntry> entities);

    @Mapping(source = "educBackgroundId", target = "educBackground.id")
    @Mapping(source = "levelId", target = "educationLevel.id")
    @Mapping(target = "id", ignore = true)
    EducationEntry toEntity(EducationEntryCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "educBackgroundId", target = "educBackground.id")
    @Mapping(source = "levelId", target = "educationLevel.id")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(EducationEntryUpdateDTO dto, @MappingTarget EducationEntry entity);
}
