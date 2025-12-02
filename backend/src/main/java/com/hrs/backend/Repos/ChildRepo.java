package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.FamilyBackground.Child;

public interface ChildRepo extends JpaRepository<Child, Integer> {

}
