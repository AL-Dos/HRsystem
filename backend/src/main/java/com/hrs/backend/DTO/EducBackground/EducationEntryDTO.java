package com.hrs.backend.DTO.EducBackground;

import java.time.LocalDate;

import com.hrs.backend.DTO.Lookups.EducLevelDTO;

import lombok.Data;

@Data
public class EducationEntryDTO {
    private Integer id;
    private EducBackgroundDTO educBackground;
    private EducLevelDTO educationLevel;
    private String schoolName;
    private String course;
    private LocalDate attendanceFrom;
    private LocalDate attendanceTo;
    private String levelEarned;
    private LocalDate graduateDate;
    private String scholarshipHonors;
}
