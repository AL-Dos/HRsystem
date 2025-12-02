package com.hrs.backend.Mapper.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Lookups.CitizenshipTypeCreateDTO;
import com.hrs.backend.DTO.Lookups.CitizenshipTypeDTO;
import com.hrs.backend.DTO.Lookups.CitizenshipTypeUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.CitizenshipType;

@Mapper(componentModel = "spring")
public interface CitizenshipTypeMapper {
    CitizenshipTypeDTO toDTO(CitizenshipType entity);

    CitizenshipType toEntity(CitizenshipTypeCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(CitizenshipTypeUpdateDTO dto, @MappingTarget CitizenshipType entity);
}
