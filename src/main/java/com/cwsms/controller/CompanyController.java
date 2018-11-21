package com.cwsms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cwsms.constants.RESTConstants;
import com.cwsms.exception.CompanyNotFoundException;
import com.cwsms.model.user.customer.Company;
import com.cwsms.repository.CompanyRepository;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping(RESTConstants.COMPANY)
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.COMPANY_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Company> getCompanyById(@PathVariable Long id) throws CompanyNotFoundException {
		Optional<Company> company = companyRepository.findById(id);
		if(!company.isPresent()) throw new CompanyNotFoundException("Company ID: "+id);
		Resource<Company> resource = new Resource<Company>(company.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllCompanies());
		resource.add(linkTo.withRel(RESTConstants.COMPANY_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.COMPANY_ID)
	public void deleteCompanyById(@PathVariable Long id) {
		companyRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.COMPANY)
	public ResponseEntity<Object> addNewCompany(@RequestBody Company company) {
		Company newCompany = companyRepository.save(company);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newCompany.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.COMPANY_ID)
	public ResponseEntity<Object> updateCompany(@RequestBody Company company, @PathVariable Long id) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		if(!optionalCompany.isPresent())
			return ResponseEntity.notFound().build();
		else {
			company.setId(id);
			companyRepository.save(company);
			return ResponseEntity.noContent().build();
		}
	}
}
