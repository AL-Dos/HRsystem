package com.hrs.backend.Mapper.Education;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.EducBackground.EducationEntryCreateDTO;
import com.hrs.backend.DTO.EducBackground.EducationEntryDTO;
import com.hrs.backend.DTO.EducBackground.EducationEntryUpdateDTO;
import com.hrs.backend.Mapper.Lookups.EducationLevelMapper;
import com.hrs.backend.Models.EducBackground.EducationEntry;

@Mapper(componentModel = "spring", uses = { EducBackgroundMapper.class, EducationLevelMapper.class })
public interface EducEntryMapper {
    EducationEntryDTO toDTO(EducationEntry entity);

    @Mapping(source = "educBackgroundId", target = "educBackground.id")
    @Mapping(source = "levelId", target = "educationLevel.id")
    EducationEntry toEntity(EducationEntryCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "educBackgroundId", target = "educBackground.id")
    @Mapping(source = "levelId", target = "educationLevel.id")
    void updateEntityFromDTO(EducationEntryUpdateDTO dto, @MappingTarget EducationEntry entity);
}
