package com.hrs.backend.DTOs.Emergency;

import com.hrs.backend.DTOs.Person.PersonDTO;

import lombok.Data;

@Data
public class EmergencyDTO {
    private Integer id;
    private String contactName;
    private String relationship;
    private String contactNo;
    private String address;
    private PersonDTO person;
}
