package com.hrs.backend.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "civil_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CivilService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cse")
    private String cse;
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "exam_date")
    private LocalDate examDate;
    @Column(name = "exam_place")
    private String examPlace;
    @Column(name = "license_number")
    private String licenseNumber;
    @Column(name = "validity_date")
    private LocalDate validityDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}