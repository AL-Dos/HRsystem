package com.hrs.backend.Mappers.ProfessionalInfo;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.CivilService.CivilServiceCreateDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceDTO;
import com.hrs.backend.DTOs.CivilService.CivilServiceUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Models.CivilService;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface CivilServMapper {
    CivilServiceDTO toDTO(CivilService entity);

    @Mapping(source = "personId", target = "person.id")
    CivilService toEntity(CivilServiceCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(CivilServiceUpdateDTO dto, @MappingTarget CivilService entity);
}
