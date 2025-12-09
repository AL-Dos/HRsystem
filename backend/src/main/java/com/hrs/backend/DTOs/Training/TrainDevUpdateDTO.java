package com.hrs.backend.DTOs.Training;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TrainDevUpdateDTO {
    private Integer personId;
    private String title;
    private LocalDate attendFrom;
    private LocalDate attendTo;
    private Integer hours;
    private String typeOf;
    private String sponsoredBy;
}
