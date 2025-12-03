package com.hrs.backend.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "signature")
    private String signature;
}
