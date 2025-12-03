package com.hrs.backend.DTOs.WorkExp;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkExpUpdateDTO {
    private Integer personId;
    private LocalDate datesFrom;
    private LocalDate datesTo;
    private String positionTitle;
    private String company;
    private String salary;
    private String payGrade;
    private String status;
    private Boolean govService;
}
