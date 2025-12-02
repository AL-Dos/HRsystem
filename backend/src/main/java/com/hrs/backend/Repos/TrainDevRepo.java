package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.TrainingDevelopment;

public interface TrainDevRepo extends JpaRepository<TrainingDevelopment, Integer> {

}
