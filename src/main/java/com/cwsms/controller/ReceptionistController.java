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
import com.cwsms.exception.ReceptionistNotFoundException;
import com.cwsms.repository.ReceptionistRepository;
import com.cwsms.model.user.receptionist.Receptionist;

@RestController
public class ReceptionistController {
	
	@Autowired
	private ReceptionistRepository receptionistRepository;
	
	@GetMapping(RESTConstants.RECPTIONIST)
	public List<Receptionist> getAllReceptionists() {
		return receptionistRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.RECPTIONIST_ID, produces={MediaType.APPLICATION_JSON_VALUE, RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Receptionist> getReceptionistById(@PathVariable Long id) throws ReceptionistNotFoundException {
		Optional<Receptionist> receptionist = receptionistRepository.findById(id);
		if(!receptionist.isPresent()) throw new ReceptionistNotFoundException("Admin ID: "+id);
		Resource<Receptionist> resource = new Resource<Receptionist>(receptionist.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllReceptionists());
		resource.add(linkTo.withRel(RESTConstants.ADMIN_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.RECPTIONIST_ID)
	public void deleteReceptionistById(@PathVariable Long id) {
		receptionistRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.RECPTIONIST)
	public ResponseEntity<Object> addNewReceptionist(@RequestBody Receptionist receptionist) {
		Receptionist newReceptionist = receptionistRepository.save(receptionist);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newReceptionist.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.RECPTIONIST_ID)
	public ResponseEntity<Object> updateReceptionist(@RequestBody Receptionist receptionist, @PathVariable Long id) {
		Optional<Receptionist> optionalReceptionist = receptionistRepository.findById(id);
		
		if(!optionalReceptionist.isPresent())
			return ResponseEntity.notFound().build();
		else {
			receptionist.setId(id);
			receptionistRepository.save(receptionist);
			return ResponseEntity.noContent().build();
		}
	}
}
