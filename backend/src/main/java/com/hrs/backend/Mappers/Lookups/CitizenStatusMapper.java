package com.hrs.backend.Mappers.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Lookups.CitizenStatusCreateDTO;
import com.hrs.backend.DTOs.Lookups.CitizenStatusDTO;
import com.hrs.backend.DTOs.Lookups.CitizenStatusUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.CitizenshipStatus;

@Mapper(componentModel = "spring")
public interface CitizenStatusMapper {

    CitizenStatusDTO toDTO(CitizenshipStatus entity);

    CitizenshipStatus toEntity(CitizenStatusCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(CitizenStatusUpdateDTO dto, @MappingTarget CitizenshipStatus entity);
}
