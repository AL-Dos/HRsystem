package com.hrs.backend.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "work_exp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate datesFrom;
    private LocalDate datesTo;
    private String positionTitle;
    private String company;
    private String salary;
    private String payGrade;
    private String status;
    private Boolean govService;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}