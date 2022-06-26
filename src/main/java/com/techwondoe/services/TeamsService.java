package com.techwondoe.services;

import java.util.List;

import com.techwondoe.entities.Teams;

public interface TeamsService {
	
	Teams createTeam(Teams team);
	
	List<Teams> getAllTeams();
	
	
}
