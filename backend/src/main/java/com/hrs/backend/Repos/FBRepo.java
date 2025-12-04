package com.hrs.backend.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.FamilyBackground.FamilyBackground;

public interface FBRepo extends JpaRepository<FamilyBackground, Integer> {
    Optional<FamilyBackground> findByPersonId(Integer personId);
}
