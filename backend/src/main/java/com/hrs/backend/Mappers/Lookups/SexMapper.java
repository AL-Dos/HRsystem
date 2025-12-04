package com.hrs.backend.Mappers.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Lookups.SexCreateDTO;
import com.hrs.backend.DTOs.Lookups.SexDTO;
import com.hrs.backend.DTOs.Lookups.SexUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.Sex;

@Mapper(componentModel = "spring")
public interface SexMapper {

    SexDTO toDTO(Sex entity);

    @Mapping(target = "id", ignore = true)
    Sex toEntity(SexCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(SexUpdateDTO dto, @MappingTarget Sex entity);
}