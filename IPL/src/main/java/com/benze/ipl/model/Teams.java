package com.benze.ipl.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String teamName;
	private Integer totalMatches;
	private Integer totalWins;
	
	@Transient
	private List<Matches> matches;
	
	public List<Matches> getMatches() {
		return matches;
	}
	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}
	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teams(String teamName, Integer totalMatches, Integer totalWins) {
		super();
		this.teamName = teamName;
		this.totalMatches = totalMatches;
		this.totalWins = totalWins;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(Integer totalMatches) {
		this.totalMatches = totalMatches;
	}
	public Integer getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(Integer totalWins) {
		this.totalWins = totalWins;
	}
	
	
}
