package com.techwondoe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techwondoe.entities.Teams;

public interface TeamsRepository extends JpaRepository<Teams, Integer>{
	
	@Query("SELECT t FROM Teams t GROUP BY t.company")
	public List<Object[]> findAllTeamsGroupedByCompany();
}
