package com.hrs.backend.DTOs.PersonalInfo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hrs.backend.DTOs.Lookups.CitizenStatusDTO;
import com.hrs.backend.DTOs.Lookups.CitizenshipTypeDTO;
import com.hrs.backend.DTOs.Lookups.CivilStatusDTO;
import com.hrs.backend.DTOs.Lookups.SexDTO;
import com.hrs.backend.DTOs.Person.PersonDTO;

import lombok.Data;

@Data
public class PersonalInfoDTO {
    private Integer id;
    private String firstName;
    private String surname;
    private String middleName;
    private String extensions;
    private LocalDate birthDate;
    private String bloodType;
    private String placeBirth;
    private SexDTO sex;
    private CivilStatusDTO civilStatus;
    private String civilOther;
    private BigDecimal heightM;
    private BigDecimal weightKg;
    private String gsisId;
    private String pagibigId;
    private String phealthId;
    private String sssNo;
    private String tinNo;
    private String employeeNo;
    private CitizenshipTypeDTO citizenshipType;
    private CitizenStatusDTO citizenStatus;
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
    private PersonDTO person;
}
