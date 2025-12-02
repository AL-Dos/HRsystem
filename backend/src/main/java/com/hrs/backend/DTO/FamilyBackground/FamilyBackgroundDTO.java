package com.hrs.backend.DTO.FamilyBackground;

import com.hrs.backend.DTO.Person.PersonDTO;

import lombok.Data;

@Data
public class FamilyBackgroundDTO {
    private Integer id;
    private String spouseFname;
    private String spouseSurname;
    private String spouseMname;
    private String spouseExtensions;
    private String spouseOccupation;
    private String spouseEmployeer;
    private String spouseJobAddress;
    private String telephone;
    private String fatherFname;
    private String fatherSurname;
    private String fatherMname;
    private String fatherExtensions;
    private String motherFname;
    private String motherSurname;
    private String motherMname;
    private PersonDTO person;
}
