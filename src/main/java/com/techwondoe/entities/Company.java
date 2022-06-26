package com.techwondoe.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyID;
	
	@Column(name = "company_name", nullable=false)
	private String companyName;
	
	@Column(name = "company_ceo", nullable=false)
	private String companyCEO;
	
	@Column(name = "company_add", nullable=false)
	private String companyAddress;
	
	@Column(name = "inception_date", nullable=false)
	private Date inceptionDate;
	
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Teams> teams;
	
}
