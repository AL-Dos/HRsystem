package com.hrs.backend.Mapper.Education;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.EducBackground.EducBackgroundCreateDTO;
import com.hrs.backend.DTO.EducBackground.EducBackgroundDTO;
import com.hrs.backend.DTO.EducBackground.EducBackgroundUpdateDTO;
import com.hrs.backend.Mapper.MainEntities.PersonMapper;
import com.hrs.backend.Models.EducBackground.EducBackground;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface EducBackgroundMapper {
    EducBackgroundDTO toDTO(EducBackground entity);

    @Mapping(source = "personId", target = "person.id")
    EducBackground toEntity(EducBackgroundCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(EducBackgroundUpdateDTO dto, @MappingTarget EducBackground entity);
}
