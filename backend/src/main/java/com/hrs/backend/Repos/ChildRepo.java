package com.hrs.backend.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.FamilyBackground.Child;

public interface ChildRepo extends JpaRepository<Child, Integer> {
    List<Child> findByFamilyBackgroundId(Integer familyBackgroundId);
}
