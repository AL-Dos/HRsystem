package com.hrs.backend.Mappers.MainEntities;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Person.PersonCreateDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.Person.PersonUpdateDTO;
import com.hrs.backend.Models.Person;
import com.hrs.backend.Models.Status;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "referenceNumber", ignore = true)
    @Mapping(target = "status", source = "statusId")
    Person toEntity(PersonCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "referenceNumber", ignore = true)
    @Mapping(target = "status", source = "statusId")
    void updateEntityFromDTO(PersonUpdateDTO dto, @MappingTarget Person entity);
    
    default Status map(Integer statusId) {
        if (statusId == null) {
            return null;
        }
        Status status = new Status();
        status.setId(statusId);
        return status;
    }
}
