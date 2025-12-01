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
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "extensions")
    private String extensions;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "place_birth")
    private String placeBirth;

    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "civil_status_id")
    private CivilStatus civilStatus;

    @Column(name = "civil_other")
    private String civilOther;
    @Column(name = "height_m")
    private BigDecimal heightM;
    @Column(name = "weight_kg")
    private BigDecimal weightKg;

    @Column(name = "gsis_id")
    private String gsisId;
    @Column(name = "pagibig_id")
    private String pagibigId;
    @Column(name = "phealth_id")
    private String phealthId;
    @Column(name = "sss_no")
    private String sssNo;
    @Column(name = "tin_no")
    private String tinNo;
    @Column(name = "employee_no")
    private String employeeNo;

    @ManyToOne
    @JoinColumn(name = "citizenship_type_id")
    private CitizenshipType citizenshipType;
    @ManyToOne
    @JoinColumn(name = "citizen_status_id")
    private CitizenshipStatus citizenStatus;
    @Column(name = "dual_citizen_country")
    private String dualCitizenCountry;

    @Column(name = "address_no")
    private String addressNo;
    @Column(name = "address_st")
    private String addressSt;
    @Column(name = "address_sub")
    private String addressSub;
    @Column(name = "address_barangay")
    private String addressBarangay;
    @Column(name = "address_city")
    private String addressCity;
    @Column(name = "address_province")
    private String addressProvince;
    @Column(name = "address_code")
    private String addressCode;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
