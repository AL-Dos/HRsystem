package com.hrs.backend.Mappers.MainEntities;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundUpdateDTO;
import com.hrs.backend.Models.FamilyBackground.FamilyBackground;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface FamBackgroundMapper {
    FamilyBackgroundDTO toDTO(FamilyBackground entity);

    @Mapping(source = "personId", target = "person.id")
    FamilyBackground toEntity(FamilyBackgroundCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(FamilyBackgroundUpdateDTO dto, @MappingTarget FamilyBackground entity);
}
