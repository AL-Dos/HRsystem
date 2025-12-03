package com.hrs.backend.DTOs.FamilyBackground;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildDTO {
    private Integer id;
    private String childName;
    private LocalDate birthDate;
    private FamilyBackgroundDTO familyBackground;
}
