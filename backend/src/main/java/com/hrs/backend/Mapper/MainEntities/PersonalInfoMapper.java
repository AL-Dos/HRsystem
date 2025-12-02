package com.hrs.backend.Mapper.MainEntities;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.PersonalInfo.PersonalInfoCreateDTO;
import com.hrs.backend.DTO.PersonalInfo.PersonalInfoDTO;
import com.hrs.backend.DTO.PersonalInfo.PersonalInfoUpdateDTO;
import com.hrs.backend.Mapper.Lookups.CitizenStatusMapper;
import com.hrs.backend.Mapper.Lookups.CitizenshipTypeMapper;
import com.hrs.backend.Mapper.Lookups.CivilStatusMapper;
import com.hrs.backend.Mapper.Lookups.SexMapper;
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
    PersonalInfo toEntity(PersonalInfoCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "sexId", target = "sex.id")
    @Mapping(source = "civilStatusId", target = "civilStatus.id")
    @Mapping(source = "citizenshipTypeId", target = "citizenshipType.id")
    @Mapping(source = "citizenStatusId", target = "citizenStatus.id")
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(PersonalInfoUpdateDTO dto, @MappingTarget PersonalInfo entity);
}
