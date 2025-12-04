package com.hrs.backend.Services;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import com.hrs.backend.DTOs.PDSFullDTO;
import com.hrs.backend.Mappers.Education.EducBackgroundMapper;
import com.hrs.backend.Mappers.Education.EducEntryMapper;
import com.hrs.backend.Mappers.MainEntities.ChildMapper;
import com.hrs.backend.Mappers.MainEntities.FamBackgroundMapper;
import com.hrs.backend.Mappers.MainEntities.PersonMapper;
import com.hrs.backend.Mappers.MainEntities.PersonalInfoMapper;
import com.hrs.backend.Mappers.ProfessionalInfo.CivilServMapper;
import com.hrs.backend.Mappers.ProfessionalInfo.EmergencyMapper;
import com.hrs.backend.Mappers.ProfessionalInfo.TrainDevMapper;
import com.hrs.backend.Mappers.ProfessionalInfo.WorkExpMapper;
import com.hrs.backend.Models.Person;
import com.hrs.backend.Models.EducBackground.EducBackground;
import com.hrs.backend.Models.FamilyBackground.FamilyBackground;
import com.hrs.backend.Repos.ChildRepo;
import com.hrs.backend.Repos.CivilServRepo;
import com.hrs.backend.Repos.EBRepo;
import com.hrs.backend.Repos.EducEntryRepo;
import com.hrs.backend.Repos.EmergencyRepo;
import com.hrs.backend.Repos.FBRepo;
import com.hrs.backend.Repos.PeronsalInfoRepo;
import com.hrs.backend.Repos.PersonRepo;
import com.hrs.backend.Repos.TrainDevRepo;
import com.hrs.backend.Repos.WorkExpRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PDSProfileService {
    private final PersonRepo personRepository;
    private final PeronsalInfoRepo personalInfoRepository;
    private final FBRepo familyBackgroundRepository;
    private final ChildRepo childrenRepository;
    private final CivilServRepo civilServiceRepository;
    private final EBRepo educBackgroundRepository;
    private final EducEntryRepo educationEntryRepository;
    private final WorkExpRepo workExpRepository;
    private final TrainDevRepo trainingRepository;
    private final EmergencyRepo emergencyRepository;

    private final PersonMapper personMapper;
    private final PersonalInfoMapper personalInfoMapper;
    private final FamBackgroundMapper familyBackgroundMapper;
    private final ChildMapper childrenMapper;
    private final CivilServMapper civilServiceMapper;
    private final EducBackgroundMapper educBackgroundMapper;
    private final EducEntryMapper educationEntryMapper;
    private final WorkExpMapper workExpMapper;
    private final TrainDevMapper trainingMapper;
    private final EmergencyMapper emergencyMapper;


    public PDSFullDTO getFullProfile(Integer personId) throws NameNotFoundException {
        // Base
        Person person = personRepository.findById(personId).orElseThrow(() -> new NameNotFoundException("Person not found: " + personId));
        PDSFullDTO dto = new PDSFullDTO();

        // Person
        dto.setPerson(personMapper.toDTO(person));

        // Personal Info
        dto.setPersonalInfo(personalInfoRepository.findByPersonId(personId).map(personalInfoMapper::toDTO).orElse(null));

        // Family
        FamilyBackground fb = familyBackgroundRepository.findByPersonId(personId).orElse(null);
        dto.setFamilyBackground(fb != null ? familyBackgroundMapper.toDTO(fb) : null);
        dto.setChildren(fb != null ? childrenMapper.toDTOList(childrenRepository.findByFamilyBackgroundId(fb.getId())) : List.of());
        
        // Education
        EducBackground eb = educBackgroundRepository.findByPersonId(personId).orElse(null);
        dto.setEducBackground(eb != null ? educBackgroundMapper.toDTO(eb) : null);
        dto.setEducEntries(eb != null ? educationEntryMapper.toDTOList(educationEntryRepository.findByEducBackgroundId(eb.getId())) : List.of());

        // Civil Service
        dto.setCivilServices(civilServiceMapper.toDTOList(civilServiceRepository.findByPersonId(personId)));

        // Work Experience
        dto.setWorkExperiences(workExpMapper.toDTOList(workExpRepository.findByPersonId(personId)));
        
        // Training
        dto.setTrainDevs(trainingMapper.toDTOList(trainingRepository.findByPersonId(personId)));

        // Emergency Contacts
        dto.setEmergencies(emergencyMapper.toDTOList(emergencyRepository.findByPersonId(personId)));

        return dto;
    }
}
