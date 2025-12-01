package com.hrs.backend.Models.EducBackground;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "education_level")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private String status;
}
