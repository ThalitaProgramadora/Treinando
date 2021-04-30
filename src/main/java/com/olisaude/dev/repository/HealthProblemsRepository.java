package com.olisaude.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olisaude.dev.model.healthProblems;

@Repository
public interface HealthProblemsRepository extends JpaRepository<healthProblems, Long>{
	public List<healthProblems> findAllByNameContainingIgnoreCase(String name);
}
