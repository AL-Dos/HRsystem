package com.hrs.backend.DTOs.Person;

import lombok.Data;

@Data
public class PersonDTO {
    private Integer id;
    private String photoUrl;
    private String referenceNumber;
    private String signature;
}
