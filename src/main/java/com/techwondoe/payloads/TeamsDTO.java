package com.techwondoe.payloads;

import com.techwondoe.entities.Company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor
public class TeamsDTO {
	
	private Integer teamID;
	
	private String teamLeadName;
	
	private Company company;
	
}
