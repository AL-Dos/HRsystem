package com.hrs.backend.Mappers.MainEntities;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.FamilyBackground.ChildCreateDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildUpdateDTO;
import com.hrs.backend.Models.FamilyBackground.Child;

@Mapper(componentModel = "spring", uses = { FamBackgroundMapper.class })
public interface ChildMapper {
    ChildDTO toDTO(Child entity);
    List<ChildDTO> toDTOList(List<Child> entities);

    @Mapping(source = "familyBackgroundId", target = "familyBackground.id")
    Child toEntity(ChildCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "familyBackgroundId", target = "familyBackground.id")
    void updateEntityFromDTO(ChildUpdateDTO dto, @MappingTarget Child entity);
}
