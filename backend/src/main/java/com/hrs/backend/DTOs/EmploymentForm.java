package com.hrs.backend.DTOs;

import java.util.List;

import lombok.Data;

@Data
public class EmploymentForm {
    private Long personId;                     // Person selected from UI
    private List<EmploymentRow> rows;          // Multiple rows of table entries
}
