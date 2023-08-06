package com.benze.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benze.ipl.model.Matches;
import com.benze.ipl.model.Teams;
import com.benze.ipl.service.TeamsService;

@RestController
@CrossOrigin("*")
public class TeamsController {
	@Autowired
	private TeamsService teamsService;
	
	@GetMapping("/teams")
	public List<Teams> getAllTeams(){
		return teamsService.getAllTeams();
	}
	
	@GetMapping("/teams/{teamName}")
	public Teams getTeam(@PathVariable("teamName") String team) {
		return teamsService.getTeam(team);
	}
	
	@GetMapping("/teams/{teamName}/matches")
	public List<Matches> getMatchesForTeam(@PathVariable("teamName") String team, @RequestParam int season){
		return teamsService.getMatchesForTeam(team,season);
	}
}
