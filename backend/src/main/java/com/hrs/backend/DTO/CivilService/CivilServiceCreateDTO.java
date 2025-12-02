package com.hrs.backend.DTO.CivilService;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CivilServiceCreateDTO {
    private String cse;
    private BigDecimal rating;
    private LocalDate examDate;
    private String examPlace;
    private String licenseNumber;
    private LocalDate validityDate;
    private Integer personId;
}
