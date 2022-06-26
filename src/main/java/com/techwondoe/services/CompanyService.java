package com.techwondoe.services;

import com.techwondoe.entities.Company;

public interface CompanyService {
	
	Company createCompany(Company company);
	
	Company getCompanyById(Integer componyId);
	
	Company getCompanyByName(String companyName);
	
	
}
