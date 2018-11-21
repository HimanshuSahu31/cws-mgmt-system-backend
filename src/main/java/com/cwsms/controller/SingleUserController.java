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
import com.cwsms.exception.SingleUserNotFoundException;
import com.cwsms.model.user.customer.SingleUser;
import com.cwsms.repository.SingleUserRepository;

@RestController
public class SingleUserController {
	
	@Autowired
	private SingleUserRepository singleUserRepository;
	
	@GetMapping(RESTConstants.SINGLE_USER)
	public List<SingleUser> getAllSingleUsers() {
		return singleUserRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.SINGLE_USER_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<SingleUser> getSingleUserById(@PathVariable Long id) throws SingleUserNotFoundException {
		Optional<SingleUser> singleUser = singleUserRepository.findById(id);
		if(!singleUser.isPresent()) throw new SingleUserNotFoundException("Single User ID: "+id);
		Resource<SingleUser> resource = new Resource<SingleUser>(singleUser.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllSingleUsers());
		resource.add(linkTo.withRel(RESTConstants.SINGLE_USER_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.SINGLE_USER_ID)
	public void deleteSingleUserById(@PathVariable Long id) {
		singleUserRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.SINGLE_USER)
	public ResponseEntity<Object> addNewSingleUser(@RequestBody SingleUser singleUser) {
		SingleUser newSingleUser = singleUserRepository.save(singleUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newSingleUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.SINGLE_USER_ID)
	public ResponseEntity<Object> updateSingleUser(@RequestBody SingleUser singleUser, @PathVariable Long id) {
		Optional<SingleUser> optionalSingleUser = singleUserRepository.findById(id);
		
		if(!optionalSingleUser.isPresent())
			return ResponseEntity.notFound().build();
		else {
			singleUser.setId(id);
			singleUserRepository.save(singleUser);
			return ResponseEntity.noContent().build();
		}
	}
}
