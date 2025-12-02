package com.hrs.backend.DTO.Emergency;

import lombok.Data;

@Data
public class EmergencyCreateDTO {
    private Integer personId;
    private String contactName;
    private String relationship;
    private String contactNo;
    private String address;
}
