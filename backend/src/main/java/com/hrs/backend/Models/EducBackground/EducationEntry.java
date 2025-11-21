package com.hrs.backend.Models.EducBackground;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "education_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "educ_background_id")
    private EducBackground educBackground;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private EducationLevel educationLevel;

    private String schoolName;
    private String course;
    private LocalDate attendanceFrom;
    private LocalDate attendanceTo;
    private String levelEarned;
    private LocalDate graduateDate;
    private String scholarshipHonors;
}