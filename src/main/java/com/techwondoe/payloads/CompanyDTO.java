package com.techwondoe.payloads;

import java.util.Date;
import java.util.Set;

import com.techwondoe.entities.Teams;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CompanyDTO {
	
	private Integer companyID;
	
	private String companyName;
	
	private String companyCEO;
	
	private String companyAddress;
	
	private Date inceptionDate;
	
	private Set<Teams> teams;
	
}
