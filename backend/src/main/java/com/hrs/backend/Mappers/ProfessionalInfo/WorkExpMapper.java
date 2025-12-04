package com.hrs.backend.Mappers.ProfessionalInfo;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.WorkExp.WorkExpCreateDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Models.WorkExperience;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface WorkExpMapper {
    WorkExpDTO toDTO(WorkExperience entity);
    List<WorkExpDTO> toDTOList(List<WorkExperience> entities);

    @Mapping(source = "personId", target = "person.id")
    WorkExperience toEntity(WorkExpCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(WorkExpUpdateDTO dto, @MappingTarget WorkExperience entity);
}
