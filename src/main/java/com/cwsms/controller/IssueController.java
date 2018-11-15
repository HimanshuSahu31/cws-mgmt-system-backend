package com.cwsms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cwsms.exception.IssueDoesNotExistException;
import com.cwsms.model.issue.Issue;
import com.cwsms.repository.IssueRepository;

@RestController
public class IssueController {
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping(RESTConstants.ISSUES)
	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
	}
	
	@GetMapping(RESTConstants.ISSUES_ID)
	public Issue getIssueById(@PathVariable Long id) throws IssueDoesNotExistException{
		Optional<Issue> issue = issueRepository.findById(id);
		
		if(!issue.isPresent()) {
			throw new IssueDoesNotExistException("Issue ID: "+id);
		}
		
		return issue.get();
	}
	
	@DeleteMapping(RESTConstants.ISSUES_ID)
	public void deleteIssueById(@PathVariable Long id) {
		issueRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.ISSUES)
	public ResponseEntity<Object> addNewIssue(@RequestBody Issue issue) {
		Issue newIssue = issueRepository.save(issue);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newIssue.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.ISSUES_ID)
	public ResponseEntity<Object> updateIssue(@RequestBody Issue issue, @PathVariable Long id) {
		Optional<Issue> optionalIssue = issueRepository.findById(id);
		
		if(!optionalIssue.isPresent())
			return ResponseEntity.notFound().build();
		else {
			issue.setId(id);
			issueRepository.save(issue);
			return ResponseEntity.noContent().build();
		}
	}
}
