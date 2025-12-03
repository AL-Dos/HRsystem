package com.hrs.backend.DTOs.Training;

import java.time.LocalDate;

import com.hrs.backend.DTOs.Person.PersonDTO;

import lombok.Data;

@Data
public class TrainDevDTO {
    private Integer id;
    private String title;
    private LocalDate attendFrom;
    private LocalDate attenTo;
    private Integer hours;
    private String typeOf;
    private String sponsoredBy;
    private PersonDTO person;
}
