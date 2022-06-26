package com.techwondoe.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwondoe.entities.Company;
import com.techwondoe.repositories.CompanyRepository;
import com.techwondoe.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository repository;

	@Override
	public Company createCompany(Company company) {
		
		return repository.save(company);
	
	}

	@Override
	public Company getCompanyById(Integer companyId) {
		
		return repository.findById(companyId).get();
	}

	@Override
	public Company getCompanyByName(String companyName) {
		
		return repository.searchCompany(companyName);
	}
	
	
	
}
