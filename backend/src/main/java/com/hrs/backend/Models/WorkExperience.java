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
    @Column(name = "id")
    private Integer id;

    @Column(name = "dates_from")
    private LocalDate datesFrom;
    @Column(name = "dates_to")
    private LocalDate datesTo;
    @Column(name = "position_title")
    private String positionTitle;
    @Column(name = "company")
    private String company;
    @Column(name = "salary")
    private String salary;
    @Column(name = "pay_grade")
    private String payGrade;
    @Column(name = "status")
    private String status;
    @Column(name = "gov_service")
    private Boolean govService;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}