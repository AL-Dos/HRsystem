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
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "educ_background_id")
    private EducBackground educBackground;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private EducationLevel educationLevel;

    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "course")
    private String course;
    @Column(name = "attendance_from")
    private LocalDate attendanceFrom;
    @Column(name = "attendance_to")
    private LocalDate attendanceTo;
    @Column(name = "level_earned")
    private String levelEarned;
    @Column(name = "graduate_date")
    private LocalDate graduateDate;
    @Column(name = "scholarship_honors")
    private String scholarshipHonors;
}