package com.hrs.backend.DTOs.FamilyBackground;

import lombok.Data;

@Data
public class FamilyBackgroundUpdateDTO {
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
    private Integer personId;
}
