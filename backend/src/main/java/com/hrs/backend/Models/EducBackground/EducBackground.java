package com.hrs.backend.Models.EducBackground;

import com.hrs.backend.Models.Person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "educ_background")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducBackground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}