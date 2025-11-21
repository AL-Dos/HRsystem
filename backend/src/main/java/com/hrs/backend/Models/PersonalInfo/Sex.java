package com.hrs.backend.Models.PersonalInfo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sex")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
