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
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "attend_from")
    private LocalDate attendFrom;
    @Column(name = "attend_to")
    private LocalDate attendTo;
    @Column(name = "hours")
    private Integer hours;
    @Column(name = "type_of")
    private String typeOf;
    @Column(name = "sponsored_by")
    private String sponsoredBy;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}