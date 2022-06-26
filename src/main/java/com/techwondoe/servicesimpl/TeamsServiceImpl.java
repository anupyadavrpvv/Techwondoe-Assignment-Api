package com.techwondoe.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwondoe.entities.Company;
import com.techwondoe.entities.Teams;
import com.techwondoe.repositories.CompanyRepository;
import com.techwondoe.repositories.TeamsRepository;
import com.techwondoe.services.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService{
	
	@Autowired
	private TeamsRepository teamsRepository;
	
	@Autowired
	private CompanyRepository  companyRepository;

	@Override
	public Teams createTeam(Teams team, Integer cId) {
		Teams newTeam=new Teams();
		try {
			Company company= companyRepository.findById(cId).get();
			
			Teams teams= new Teams();
			teams.setTeamLeadName(team.getTeamLeadName());
			teams.setCompany(company);
			newTeam= teamsRepository.save(teams);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newTeam;
	}

	@Override
	public List<Object[]> getAllTeams() {
		
		List<Object[]> teams=new ArrayList<Object[]>();
		
		try {
			
			teams = teamsRepository.findAllTeamsGroupedByCompany();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return teams;
		
	}

}
