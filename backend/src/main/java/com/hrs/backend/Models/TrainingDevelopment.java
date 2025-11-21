package com.hrs.backend.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "training_development")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingDevelopment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private LocalDate attendFrom;
    private LocalDate attenTo;
    private Integer hours;
    private String typeOf;
    private String sponsoredBy;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}