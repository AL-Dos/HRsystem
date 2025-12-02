package com.hrs.backend.Mapper.ProfessionalInfo;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.WorkExp.WorkExpCreateDTO;
import com.hrs.backend.DTO.WorkExp.WorkExpDTO;
import com.hrs.backend.DTO.WorkExp.WorkExpUpdateDTO;
import com.hrs.backend.Mapper.MainEntities.PersonMapper;
import com.hrs.backend.Models.WorkExperience;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface WorkExpMapper {
    WorkExpDTO toDTO(WorkExperience entity);

    @Mapping(source = "personId", target = "person.id")
    WorkExperience toEntity(WorkExpCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(WorkExpUpdateDTO dto, @MappingTarget WorkExperience entity);
}
