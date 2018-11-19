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
import com.cwsms.exception.IssueTypeNotFoundException;
import com.cwsms.model.issue.type.IssueType;
import com.cwsms.repository.IssueTypeRepository;

@RestController
public class IssueTypeController {
	@Autowired
	private IssueTypeRepository issueTypeRepository;
	
	@GetMapping(RESTConstants.ISSUE_TYPES)
	public List<IssueType> getAllIssueTypes() {
		return issueTypeRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.ISSUE_TYPE_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<IssueType> getIssueTypeById(@PathVariable Long id) throws IssueTypeNotFoundException {
		Optional<IssueType> issueType = issueTypeRepository.findById(id);
		if(!issueType.isPresent()) throw new IssueTypeNotFoundException("Issue ID: "+id);
		Resource<IssueType> resource = new Resource<IssueType>(issueType.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllIssueTypes());
		resource.add(linkTo.withRel(RESTConstants.ISSUE_TYPES_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.ISSUE_TYPE_ID)
	public void deleteIssueType(@PathVariable Long id) {
		issueTypeRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.ISSUE_TYPES)
	public ResponseEntity<Object> addNewIssueType(@RequestBody IssueType issueType) {
		IssueType newIssueType = issueTypeRepository.save(issueType);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newIssueType.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.ISSUE_TYPE_ID)
	public ResponseEntity<Object> updateIssueType(@RequestBody IssueType issueType, @PathVariable Long id) {
		Optional<IssueType> optionalIssueType = issueTypeRepository.findById(id);
		
		if(!optionalIssueType.isPresent())
			return ResponseEntity.notFound().build();
		else {
			issueType.setId(id);
			issueTypeRepository.save(issueType);
			return ResponseEntity.noContent().build();
		}
	}
	
}
