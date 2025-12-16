package com.hrs.backend.DTOs;

import java.util.List;

import lombok.Data;

@Data
public class ServiceForm {
    private Long personId;                  
    private List<ServiceRow> rows;
}
