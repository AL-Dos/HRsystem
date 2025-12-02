package com.hrs.backend.DTO.WorkExp;

import java.time.LocalDate;

import com.hrs.backend.DTO.Person.PersonDTO;

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
