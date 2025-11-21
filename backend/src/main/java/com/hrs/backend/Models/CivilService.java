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
    private Integer id;

    private String cse;
    private BigDecimal rating;
    private LocalDate examDate;
    private String examPlace;
    private String licenseNumber;
    private LocalDate validityDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}