package com.hrs.backend.DTO.Training;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TrainDevCreateDTO {
    private Integer personId;
    private String title;
    private LocalDate attendFrom;
    private LocalDate attenTo;
    private Integer hours;
    private String typeOf;
    private String sponsoredBy;
}
