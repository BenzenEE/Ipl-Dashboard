package com.benze.ipl.service;

import java.util.List;

import com.benze.ipl.model.Matches;
import com.benze.ipl.model.Teams;

public interface TeamsService {

	List<Teams> getAllTeams();

	Teams getTeam(String team);

	List<Matches> getMatchesForTeam(String team, int season);

}
