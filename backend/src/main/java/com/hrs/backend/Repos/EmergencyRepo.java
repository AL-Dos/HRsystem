package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.EmergencyInfo;

public interface EmergencyRepo extends JpaRepository<EmergencyInfo, Integer> {

}
