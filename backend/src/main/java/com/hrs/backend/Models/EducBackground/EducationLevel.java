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
    private Integer id;

    private String name;
}
