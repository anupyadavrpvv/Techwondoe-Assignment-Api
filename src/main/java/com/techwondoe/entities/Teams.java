package com.techwondoe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter @Setter @NoArgsConstructor
public class Teams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Integer teamID;
	
	@Column(name = "team_lead_name", nullable=false)
	private String teamLeadName;
	
	@ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;
	
}
