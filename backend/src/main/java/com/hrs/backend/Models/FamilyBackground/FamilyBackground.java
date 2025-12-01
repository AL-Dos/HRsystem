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
    @Column(name = "id")
    private Integer id;

    @Column(name = "spouse_fname")
    private String spouseFname;
    @Column(name = "spouse_surname")
    private String spouseSurname;
    @Column(name = "spouse_mname")
    private String spouseMname;
    @Column(name = "spouse_extensions")
    private String spouseExtensions;
    @Column(name = "spouse_occupation")
    private String spouseOccupation;
    @Column(name = "spouse_employeer")
    private String spouseEmployeer;
    @Column(name = "spouse_job_address")
    private String spouseJobAddress;
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "father_fname")
    private String fatherFname;
    @Column(name = "father_surname")
    private String fatherSurname;
    @Column(name = "father_mname")
    private String fatherMname;
    @Column(name = "father_extensions")
    private String fatherExtensions;

    @Column(name = "mother_fname")
    private String motherFname;
    @Column(name = "mother_surname")
    private String motherSurname;
    @Column(name = "mother_mname")
    private String motherMname;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
