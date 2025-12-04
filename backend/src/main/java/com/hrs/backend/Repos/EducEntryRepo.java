package com.hrs.backend.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.EducBackground.EducationEntry;

public interface EducEntryRepo extends JpaRepository<EducationEntry, Integer> {
    List<EducationEntry> findByEducBackgroundId(Integer educBackgroundId);
}
