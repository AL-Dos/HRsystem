package com.hrs.backend.Models.FamilyBackground;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "children")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String childName;
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "family_background_id")
    private FamilyBackground familyBackground;
}
