package com.hrs.backend.Mapper.ProfessionalInfo;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTO.Training.TrainDevCreateDTO;
import com.hrs.backend.DTO.Training.TrainDevDTO;
import com.hrs.backend.DTO.Training.TrainDevUpdateDTO;
import com.hrs.backend.Mapper.MainEntities.PersonMapper;
import com.hrs.backend.Models.TrainingDevelopment;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface TrainDevMapper {
    TrainDevDTO toDTO(TrainingDevelopment entity);

    @Mapping(source = "personId", target = "person.id")
    TrainingDevelopment toEntity(TrainDevCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(TrainDevUpdateDTO dto, @MappingTarget TrainingDevelopment entity);
}
