package com.hrs.backend.DTOs.WorkExp;

import java.time.LocalDate;

import com.hrs.backend.DTOs.Person.PersonDTO;

import lombok.Data;

@Data
public class WorkExpDTO {
    private Integer id;
    private LocalDate datesFrom;
    private LocalDate datesTo;
    private String positionTitle;
    private String company;
    private String salary;
    private String payGrade;
    private String status;
    private Boolean govService;
    private PersonDTO person;
}
