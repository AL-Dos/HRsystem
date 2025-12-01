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
    @Column(name = "id")
    private Integer id;

    @Column(name = "child_name")
    private String childName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "family_background_id")
    private FamilyBackground familyBackground;
}
