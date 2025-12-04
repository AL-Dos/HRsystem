package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.RefSequence;

public interface RefSeqRepo extends JpaRepository<RefSequence, Integer> {
    
} 