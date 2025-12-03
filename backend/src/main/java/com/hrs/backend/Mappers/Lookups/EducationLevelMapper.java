package com.hrs.backend.Mappers.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Lookups.EducLevelCreateDTO;
import com.hrs.backend.DTOs.Lookups.EducLevelDTO;
import com.hrs.backend.DTOs.Lookups.EducLevelUpdateDTO;
import com.hrs.backend.Models.EducBackground.EducationLevel;

@Mapper(componentModel = "spring")
public interface EducationLevelMapper {

    EducLevelDTO toDTO(EducationLevel entity);

    EducationLevel toEntity(EducLevelCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(EducLevelUpdateDTO dto, @MappingTarget EducationLevel entity);
}