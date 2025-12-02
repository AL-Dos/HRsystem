package com.hrs.backend.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrs.backend.Models.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
