package com.hrs.backend.DTOs.Person;

import lombok.Data;

@Data
public class PersonUpdateDTO {
    private String photoUrl;
    private String signature;
    private String type;
    private String position;
    private Integer statusId;
    private String name;
}
