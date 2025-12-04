package com.hrs.backend.Mappers.MainEntities;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoCreateDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoUpdateDTO;
import com.hrs.backend.Mappers.Lookups.CitizenStatusMapper;
import com.hrs.backend.Mappers.Lookups.CitizenshipTypeMapper;
import com.hrs.backend.Mappers.Lookups.CivilStatusMapper;
import com.hrs.backend.Mappers.Lookups.SexMapper;
import com.hrs.backend.Models.PersonalInfo.PersonalInfo;

@Mapper(componentModel = "spring", uses = {
    SexMapper.class,
    CivilStatusMapper.class,
    CitizenshipTypeMapper.class,
    CitizenStatusMapper.class,
    PersonMapper.class
})
public interface PersonalInfoMapper {
    PersonalInfoDTO toDTO(PersonalInfo entity);

    @Mapping(source = "sexId", target = "sex.id")
    @Mapping(source = "civilStatusId", target = "civilStatus.id")
    @Mapping(source = "citizenshipTypeId", target = "citizenshipType.id")
    @Mapping(source = "citizenStatusId", target = "citizenStatus.id")
    @Mapping(source = "personId", target = "person.id")
    @Mapping(target = "id", ignore = true)
    PersonalInfo toEntity(PersonalInfoCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "sexId", target = "sex.id")
    @Mapping(source = "civilStatusId", target = "civilStatus.id")
    @Mapping(source = "citizenshipTypeId", target = "citizenshipType.id")
    @Mapping(source = "citizenStatusId", target = "citizenStatus.id")
    @Mapping(source = "personId", target = "person.id")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(PersonalInfoUpdateDTO dto, @MappingTarget PersonalInfo entity);
}
