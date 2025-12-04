package com.hrs.backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ref_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefSequence {
    @Id
    @Column(name = "year")
    private Integer year;

    @Column(name = "last_seq")
    private Integer lastSeq;
}
