package com.techwondoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techwondoe.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query("SELECT c FROM Company c WHERE c.companyName LIKE %?1%")
	public Company searchCompany(String cName);
	
}
