package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.PersonalInfo.CitizenshipType;

public interface CitiTypeRepo extends JpaRepository<CitizenshipType, Integer> {

}
