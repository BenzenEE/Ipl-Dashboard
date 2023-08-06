package com.benze.ipl.controller.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.benze.ipl.model.Matches;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer> {
	List<Matches> findByTeam1OrTeam2OrderByIdDesc(String team1, String team2, Pageable pageable);
	
	@Query(value="select * from matches where (team1=?1 or team2=?1) and season=?2 order by id desc", nativeQuery=true)
	List<Matches> getMatches(String team, int season);
}
