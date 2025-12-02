package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.CivilService;

public interface CivilServRepo extends JpaRepository<CivilService, Integer> {

}
