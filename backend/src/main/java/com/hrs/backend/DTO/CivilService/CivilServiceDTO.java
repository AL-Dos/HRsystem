package com.hrs.backend.DTO.CivilService;

import java.time.LocalDate;

import com.hrs.backend.DTO.Person.PersonDTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CivilServiceDTO {
    private Integer id;
    private String cse;
    private BigDecimal rating;
    private LocalDate examDate;
    private String examPlace;
    private String licenseNumber;
    private LocalDate validityDate;
    private PersonDTO person;
}
