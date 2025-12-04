package com.hrs.backend.DTOs;

import java.util.List;

import com.hrs.backend.DTOs.CivilService.CivilServiceDTO;
import com.hrs.backend.DTOs.EducBackground.EducBackgroundDTO;
import com.hrs.backend.DTOs.EducBackground.EducationEntryDTO;
import com.hrs.backend.DTOs.Emergency.EmergencyDTO;
import com.hrs.backend.DTOs.FamilyBackground.ChildDTO;
import com.hrs.backend.DTOs.FamilyBackground.FamilyBackgroundDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;
import com.hrs.backend.DTOs.PersonalInfo.PersonalInfoDTO;
import com.hrs.backend.DTOs.Training.TrainDevDTO;
import com.hrs.backend.DTOs.WorkExp.WorkExpDTO;

import lombok.Data;

@Data
public class PDSFullDTO {
    private PersonDTO person;
    private PersonalInfoDTO personalInfo;

    private FamilyBackgroundDTO familyBackground;
    private List<ChildDTO> children;

    private EducBackgroundDTO educBackground;
    private List<EducationEntryDTO> educEntries;

    private List<CivilServiceDTO> civilServices;

    private List<WorkExpDTO> workExperiences;
    
    private List<TrainDevDTO> trainDevs;

    private List<EmergencyDTO> emergencies;
}
