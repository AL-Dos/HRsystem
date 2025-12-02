package com.hrs.backend.DTO.Emergency;

import com.hrs.backend.DTO.Person.PersonDTO;

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
