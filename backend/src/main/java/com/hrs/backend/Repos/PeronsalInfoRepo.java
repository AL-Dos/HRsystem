package com.hrs.backend.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;

public interface PeronsalInfoRepo extends JpaRepository<PersonalInfo, Integer> {
    Optional<PersonalInfo> findByPersonId(Integer personId);
}
