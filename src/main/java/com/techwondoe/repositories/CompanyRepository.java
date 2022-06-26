package com.techwondoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwondoe.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	Company findByCompanyName(String companyName);
	
}
