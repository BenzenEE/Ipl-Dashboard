package com.benze.ipl.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benze.ipl.model.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {
	
	List<Teams> findAll();
	Teams findByTeamName(String teamName);
}
