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
import com.cwsms.exception.RightsNotFoundException;
import com.cwsms.model.user.Rights;
import com.cwsms.repository.RightsRepository;

@RestController
public class RightsController {
	
	@Autowired
	private RightsRepository rightsRepository;
	
	@GetMapping(RESTConstants.RIGHTS)
	public List<Rights> getAllRightss() {
		return rightsRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.RIGHTS_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Rights> getRightsById(@PathVariable Long id) throws RightsNotFoundException {
		Optional<Rights> rights = rightsRepository.findById(id);
		if(!rights.isPresent()) throw new RightsNotFoundException("Rights ID: "+id);
		Resource<Rights> resource = new Resource<Rights>(rights.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllRightss());
		resource.add(linkTo.withRel(RESTConstants.RIGHTS_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.RIGHTS_ID)
	public void deleteRightsById(@PathVariable Long id) {
		rightsRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.RIGHTS)
	public ResponseEntity<Object> addNewRights(@RequestBody Rights rights) {
		Rights newRights = rightsRepository.save(rights);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newRights.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.RIGHTS_ID)
	public ResponseEntity<Object> updateRights(@RequestBody Rights rights, @PathVariable Long id) {
		Optional<Rights> optionalRights = rightsRepository.findById(id);
		
		if(!optionalRights.isPresent())
			return ResponseEntity.notFound().build();
		else {
			rights.setId(id);
			rightsRepository.save(rights);
			return ResponseEntity.noContent().build();
		}
	}
}
