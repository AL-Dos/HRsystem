package com.hrs.backend.Models.PersonalInfo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "citizen_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenshipStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}