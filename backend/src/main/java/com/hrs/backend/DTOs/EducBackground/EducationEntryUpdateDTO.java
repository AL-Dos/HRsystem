package com.hrs.backend.DTOs.EducBackground;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EducationEntryUpdateDTO {
    private Integer educBackgroundId;
    private Integer levelId;
    private String schoolName;
    private String course;
    private LocalDate attendanceFrom;
    private LocalDate attendanceTo;
    private String levelEarned;
    private LocalDate graduateDate;
    private String scholarshipHonors;
}
