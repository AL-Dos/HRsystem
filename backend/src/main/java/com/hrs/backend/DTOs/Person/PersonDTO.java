package com.hrs.backend.DTOs.Person;

import com.hrs.backend.DTOs.Lookups.StatusDTO;

import lombok.Data;

@Data
public class PersonDTO {
    private Integer id;
    private String photoUrl;
    private String referenceNumber;
    private String signature;
    private boolean type;
    private String position;
    private StatusDTO status;
    private String name;
}
