package com.hrs.backend.DTOs.Emergency;

import lombok.Data;

@Data
public class EmergencyUpdateDTO {
    private Integer personId;
    private String contactName;
    private String relationship;
    private String contactNo;
    private String address;
}
