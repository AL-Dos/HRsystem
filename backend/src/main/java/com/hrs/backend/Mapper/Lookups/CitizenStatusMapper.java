package com.hrs.backend.Mapper.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Lookups.CitizenStatusCreateDTO;
import com.hrs.backend.DTO.Lookups.CitizenStatusDTO;
import com.hrs.backend.DTO.Lookups.CitizenStatusUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.CitizenshipStatus;

@Mapper(componentModel = "spring")
public interface CitizenStatusMapper {

    CitizenStatusDTO toDTO(CitizenshipStatus entity);

    CitizenshipStatus toEntity(CitizenStatusCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(CitizenStatusUpdateDTO dto, @MappingTarget CitizenshipStatus entity);
}
