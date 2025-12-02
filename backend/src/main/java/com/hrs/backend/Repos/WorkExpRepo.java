package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.WorkExperience;

public interface WorkExpRepo extends JpaRepository<WorkExperience, Integer> {

}
