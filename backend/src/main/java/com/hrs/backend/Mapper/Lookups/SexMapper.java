package com.hrs.backend.Mapper.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Lookups.SexCreateDTO;
import com.hrs.backend.DTO.Lookups.SexDTO;
import com.hrs.backend.DTO.Lookups.SexUpdateDTO;
import com.hrs.backend.Models.PersonalInfo.Sex;

@Mapper(componentModel = "spring")
public interface SexMapper {

    SexDTO toDTO(Sex entity);

    Sex toEntity(SexCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(SexUpdateDTO dto, @MappingTarget Sex entity);
}