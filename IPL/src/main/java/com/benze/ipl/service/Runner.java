package com.benze.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.benze.ipl.controller.repository.MatchesRepository;
import com.benze.ipl.controller.repository.TeamsRepository;
import com.benze.ipl.model.Teams;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private MatchesRepository matchesRepository;
	@Autowired
	private TeamsRepository teamsRepository;
	@Autowired
	private EntityManager em;

	@Override
	public void run(String... args) throws Exception {
		
		if(em.createNativeQuery("select * from teams").getResultList().isEmpty()) {
			List<String> l = em.createNativeQuery("select distinct team1 from matches").getResultList();
			System.out.println(l);
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
				
				Query query1 = em.createNativeQuery("select count(team1) from matches where team1= :name");
				query1.setParameter("name", l.get(i));
				Query query2 = em.createNativeQuery("select count(team2) from matches where team2= :name");
				query2.setParameter("name", l.get(i));
				Query q3 = em.createNativeQuery("select count(winning_team) from matches where winning_team= :name");
				q3.setParameter("name", l.get(i));
				Object o1 = query1.getSingleResult();
				Object o2 = query2.getSingleResult();
				String s1 = o1.toString();
				String s2 = o2.toString();
				System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));
				Object o3 = q3.getSingleResult();
				String s3 = o3.toString();
				
				System.out.println(Integer.parseInt(s3));
				String teamName = (String)l.get(i).toString();
				int totalMatches = Integer.parseInt(s1)+Integer.parseInt(s2);
				int totalWins = Integer.parseInt(s3);
				Teams t = new Teams();
				t.setTeamName(teamName);
				t.setTotalMatches(totalMatches);
				t.setTotalWins(totalWins);
				teamsRepository.save(t);
			}
		}
		
		
	}

}
