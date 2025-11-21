package com.hrs.backend.Models.PersonalInfo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hrs.backend.Models.Person;

@Entity
@Table(name = "personal_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String surname;
    private String middleName;
    private String extensions;
    private LocalDate birthDate;
    private String bloodType;
    private String placeBirth;

    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "civil_status_id")
    private CivilStatus civilStatus;

    private String civilOther;
    private BigDecimal heightM;
    private BigDecimal weightKg;

    private String gsisId;
    private String pagibigId;
    private String phealthId;
    private String sssNo;
    private String tinNo;
    private String employeeNo;

    @ManyToOne
    @JoinColumn(name = "citizenship_type_id")
    private CitizenshipType citizenshipType;

    @ManyToOne
    @JoinColumn(name = "citizen_status_id")
    private CitizenshipStatus citizenStatus;

    private String dualCitizenCountry;
    private String addressNo;
    private String addressSt;
    private String addressSub;
    private String addressBarangay;
    private String addressCity;
    private String addressProvince;
    private String addressCode;
    private String telephone;
    private String mobile;
    private String email;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
