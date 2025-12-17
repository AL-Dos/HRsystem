package com.hrs.backend.Mappers.Lookups;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Lookups.StatusCreateDTO;
import com.hrs.backend.DTOs.Lookups.StatusDTO;
import com.hrs.backend.DTOs.Lookups.StatusUpdateDTO;
import com.hrs.backend.Models.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDTO toDTO(Status entity);

    @Mapping(target = "id", ignore = true)
    Status toEntity(StatusCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(StatusUpdateDTO dto, @MappingTarget Status entity);
}
