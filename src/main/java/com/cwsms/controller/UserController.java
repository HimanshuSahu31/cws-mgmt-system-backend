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
import com.cwsms.exception.UserNotFoundException;
import com.cwsms.model.user.User;
import com.cwsms.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value=RESTConstants.USERS)
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.USERS_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) throw new UserNotFoundException("User ID: "+id);
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel(RESTConstants.USERS_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.USERS_ID)
	public void deleteUserById(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.USERS)
	public ResponseEntity<Object> addNewUser(@RequestBody User user) {
		User newUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.USERS_ID)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent())
			return ResponseEntity.notFound().build();
		else {
			user.setId(id);
			userRepository.save(user);
			return ResponseEntity.noContent().build();
		}
	}
}
