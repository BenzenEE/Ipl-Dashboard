package com.benze.ipl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.benze.ipl.controller.repository.MatchesRepository;
import com.benze.ipl.controller.repository.TeamsRepository;
import com.benze.ipl.model.Matches;
import com.benze.ipl.model.Teams;

@Service
public class TeamsServiceImpl implements TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepository;
	@Autowired
	private MatchesRepository matchesRepository;

	@Override
	public List<Teams> getAllTeams() {
		List<Teams> teams = new ArrayList<>();
		teams = teamsRepository.findAll();
		return teams;
	}

	@Override
	public Teams getTeam(String team) {
		Teams t = teamsRepository.findByTeamName(team);
		Pageable pageable = PageRequest.of(0,4);
		t.setMatches(matchesRepository.findByTeam1OrTeam2OrderByIdDesc(team, team, pageable));
		return t;
	}

	@Override
	public List<Matches> getMatchesForTeam(String team, int season) {
		return matchesRepository.getMatches(team, season);
	}

}
