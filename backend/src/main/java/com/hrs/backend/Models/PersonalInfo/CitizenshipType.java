package com.hrs.backend.Models.PersonalInfo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "citizenship_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenshipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private String status;
}