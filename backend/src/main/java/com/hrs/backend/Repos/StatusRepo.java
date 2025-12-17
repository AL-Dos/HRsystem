package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {

}
