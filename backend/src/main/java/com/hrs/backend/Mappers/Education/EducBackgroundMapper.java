package com.hrs.backend.Mappers.Education;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.EducBackground.EducBackgroundCreateDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Models.EducBackground.EducBackground;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface EducBackgroundMapper {
    EducBackgroundDTO toDTO(EducBackground entity);

    @Mapping(source = "personId", target = "person.id")
    @Mapping(target = "id", ignore = true)
    EducBackground toEntity(EducBackgroundCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(EducBackgroundUpdateDTO dto, @MappingTarget EducBackground entity);
}
