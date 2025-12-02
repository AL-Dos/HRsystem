package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.EducBackground.EducationLevel;

public interface EducLevelRepo extends JpaRepository<EducationLevel, Integer> {

}
