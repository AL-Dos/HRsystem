package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.PersonalInfo.CitizenshipStatus;

public interface CitiStatRepo extends JpaRepository<CitizenshipStatus, Integer> {

}
