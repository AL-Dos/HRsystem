package com.hrs.backend.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emergency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contactName;
    private String relationship;
    private String contactNo;
    private String address;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
