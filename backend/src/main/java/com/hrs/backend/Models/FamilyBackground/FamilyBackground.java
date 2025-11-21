package com.hrs.backend.Models.FamilyBackground;

import com.hrs.backend.Models.Person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "family_background")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyBackground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String spouseFname;
    private String spouseSurname;
    private String spouseMname;
    private String spouseExtensions;
    private String spouseOccupation;
    private String spouseEmployeer;
    private String spouseJobAddress;
    private String telephone;

    private String fatherFname;
    private String fatherSurname;
    private String fatherMname;
    private String fatherExtensions;

    private String motherFname;
    private String motherSurname;
    private String motherMname;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
