package com.techwondoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwondoe.entities.Teams;
import com.techwondoe.services.TeamsService;

@RestController
public class TeamsController {
	
	@Autowired
	private TeamsService service;
	
	@PostMapping("/company/{cId}/teams/new")
	public ResponseEntity<Teams> createTeam(
			@RequestBody Teams teams,
			@PathVariable Integer cId
			){
		
		Teams newTeam= service.createTeam(teams, cId);
		return new ResponseEntity<Teams>(newTeam, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/teams")
	public ResponseEntity<List<Object[]>> getCompanyUsingID(){
		
		List<Object[]> teams= service.getAllTeams();
		return new ResponseEntity<List<Object[]>>(teams, HttpStatus.OK);
		
	}
}
