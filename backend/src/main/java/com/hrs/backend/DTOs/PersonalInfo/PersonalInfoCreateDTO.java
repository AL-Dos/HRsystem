package com.hrs.backend.DTOs.PersonalInfo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonalInfoCreateDTO {
    private String firstName;
    private String surname;
    private String middleName;
    private String extensions;
    private LocalDate birthDate;
    private String bloodType;
    private String placeBirth;
    private Integer sexId;
    private Integer civilStatusId;
    private String civilOther;
    private BigDecimal heightM;
    private BigDecimal weightKg;
    private String gsisId;
    private String pagibigId;
    private String phealthId;
    private String sssNo;
    private String tinNo;
    private String employeeNo;
    private Integer citizenshipTypeId;
    private Integer citizenStatusId;
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
    private Integer personId;
}
