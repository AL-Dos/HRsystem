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
    @Column(name = "id")
    private Integer id;

    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
