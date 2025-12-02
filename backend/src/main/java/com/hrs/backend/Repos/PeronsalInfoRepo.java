package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;

public interface PeronsalInfoRepo extends JpaRepository<PersonalInfo, Integer> {

}
