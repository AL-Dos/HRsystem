package com.hrs.backend.Mappers.MainEntities;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Person.PersonCreateDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.Person.PersonUpdateDTO;
import com.hrs.backend.Models.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person entity);
    Person toEntity(PersonCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(PersonUpdateDTO dto, @MappingTarget Person entity);
}
