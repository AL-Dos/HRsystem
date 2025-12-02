package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.PersonalInfo.CivilStatus;

public interface CivilStatRepo extends JpaRepository<CivilStatus, Integer> {

}
