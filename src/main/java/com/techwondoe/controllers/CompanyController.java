package com.techwondoe.controllers;

import java.util.Date;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techwondoe.entities.Company;
import com.techwondoe.services.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@PostMapping("/company/new")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<Company> createCompany(@RequestBody Company company){
		
		Company newCompany= service.createCompany(company);
		newCompany.setInceptionDate(new Date());
		return new ResponseEntity<Company>(newCompany, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/company/{comId}")
	public ResponseEntity<Company> getCompanyUsingID(@PathVariable Integer comId){
		
		Company company= service.getCompanyById(comId);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
		
	}
	
	@GetMapping("/company")
	public ResponseEntity<Company> getCompanyWithName(@RequestParam(value = "cName") String cname){
		
		Company company= service.getCompanyByName(cname);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
		
	}
}
