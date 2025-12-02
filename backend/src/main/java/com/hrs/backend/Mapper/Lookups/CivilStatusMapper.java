package com.hrs.backend.Mapper.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Lookups.CivilStatusCreateDTO;
import com.hrs.backend.DTO.Lookups.CivilStatusDTO;
import com.hrs.backend.DTO.Lookups.CivilStatusUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.CivilStatus;

@Mapper(componentModel = "spring")
public interface CivilStatusMapper {

    CivilStatusDTO toDTO(CivilStatus entity);

    CivilStatus toEntity(CivilStatusCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(CivilStatusUpdateDTO dto, @MappingTarget CivilStatus entity);
}
