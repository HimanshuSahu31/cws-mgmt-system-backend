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
import com.cwsms.exception.WorkspaceNotFoundException;
import com.cwsms.model.workspace.Workspace;
import com.cwsms.repository.WorkspaceRepository;

@RestController
public class WorkspaceController {
	
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@GetMapping(RESTConstants.WORKSPACE)
	public List<Workspace> getAllWorkspaces() {
		return workspaceRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.WORKSPACE_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Workspace> getWorkspaceById(@PathVariable Long id) throws WorkspaceNotFoundException {
		Optional<Workspace> workspace = workspaceRepository.findById(id);
		if(!workspace.isPresent()) throw new WorkspaceNotFoundException("Workspace ID: "+id);
		Resource<Workspace> resource = new Resource<Workspace>(workspace.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllWorkspaces());
		resource.add(linkTo.withRel(RESTConstants.WORKSPACE_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.WORKSPACE_ID)
	public void deleteWorkspaceById(@PathVariable Long id) {
		workspaceRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.WORKSPACE)
	public ResponseEntity<Object> addNewWorkspace(@RequestBody Workspace workspace) {
		Workspace newWorkspace = workspaceRepository.save(workspace);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newWorkspace.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.WORKSPACE_ID)
	public ResponseEntity<Object> updateWorkspace(@RequestBody Workspace workspace, @PathVariable Long id) {
		Optional<Workspace> optionalWorkspace = workspaceRepository.findById(id);
		
		if(!optionalWorkspace.isPresent())
			return ResponseEntity.notFound().build();
		else {
			workspace.setId(id);
			workspaceRepository.save(workspace);
			return ResponseEntity.noContent().build();
		}
	}
}
