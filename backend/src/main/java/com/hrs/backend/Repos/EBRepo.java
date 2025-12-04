package com.hrs.backend.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.EducBackground.EducBackground;

public interface EBRepo extends JpaRepository<EducBackground, Integer> {
    Optional<EducBackground> findByPersonId(Integer personId);
}
