package com.hrs.backend.Mappers.ProfessionalInfo;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hrs.backend.DTOs.Training.TrainDevCreateDTO;
import com.hrs.backend.DTOs.Training.TrainDevDTO;
import com.hrs.backend.DTOs.Training.TrainDevUpdateDTO;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Models.TrainingDevelopment;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface TrainDevMapper {
    TrainDevDTO toDTO(TrainingDevelopment entity);
    List<TrainDevDTO> toDTOList(List<TrainingDevelopment> entities);

    @Mapping(source = "personId", target = "person.id")
    TrainingDevelopment toEntity(TrainDevCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "personId", target = "person.id")
    void updateEntityFromDTO(TrainDevUpdateDTO dto, @MappingTarget TrainingDevelopment entity);
}
