package com.hrs.backend.DTO.FamilyBackground;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildUpdateDTO {
    private Integer familyBackgroundId;
    private String childName;
    private LocalDate birthDate;
}
