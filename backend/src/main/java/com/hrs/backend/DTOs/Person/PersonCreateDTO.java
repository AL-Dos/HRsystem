package com.hrs.backend.DTOs.Person;

import lombok.Data;

@Data
public class PersonCreateDTO {
    private String photoUrl;
    private String signature;
    private boolean type;
    private String position;
    private Integer statusId;
    private String name;
}
