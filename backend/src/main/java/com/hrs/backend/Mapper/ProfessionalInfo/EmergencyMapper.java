package com.hrs.backend.Mapper.ProfessionalInfo;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Emergency.EmergencyCreateDTO;
import com.hrs.backend.DTO.Emergency.EmergencyDTO;
import com.hrs.backend.DTO.Emergency.EmergencyUpdateDTO;
import com.hrs.backend.Mapper.MainEntities.PersonMapper;
import com.hrs.backend.Models.EmergencyInfo;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface EmergencyMapper {
    EmergencyDTO toDTO(EmergencyInfo entity);

    @Mapping(source = "personId", target = "person.id")
    EmergencyInfo toEntity(EmergencyCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(EmergencyUpdateDTO dto, @MappingTarget EmergencyInfo entity);
}
