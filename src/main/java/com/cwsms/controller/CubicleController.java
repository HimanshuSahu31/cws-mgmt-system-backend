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
import com.cwsms.exception.CubicleNotFoundException;
import com.cwsms.model.office.type.Cubicle;
import com.cwsms.repository.CubicleRepository;;

@RestController
public class CubicleController {
	
	@Autowired
	private CubicleRepository cubicleRepository;
	
	@GetMapping(RESTConstants.CUBICLE)
	public List<Cubicle> getAllCubicles() {
		return cubicleRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.CUBICLE_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Cubicle> getCubicleById(@PathVariable Long id) throws CubicleNotFoundException {
		Optional<Cubicle> cubicle = cubicleRepository.findById(id);
		if(!cubicle.isPresent()) throw new CubicleNotFoundException("Cubicle ID: "+id);
		Resource<Cubicle> resource = new Resource<Cubicle>(cubicle.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllCubicles());
		resource.add(linkTo.withRel(RESTConstants.CUBICLE_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.CUBICLE_ID)
	public void deleteCubicleById(@PathVariable Long id) {
		cubicleRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.CUBICLE)
	public ResponseEntity<Object> addNewCubicle(@RequestBody Cubicle cubicle) {
		Cubicle newCubicle = cubicleRepository.save(cubicle);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newCubicle.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.CUBICLE_ID)
	public ResponseEntity<Object> updateCubicle(@RequestBody Cubicle cubicle, @PathVariable Long id) {
		Optional<Cubicle> optionalCubicle = cubicleRepository.findById(id);
		
		if(!optionalCubicle.isPresent())
			return ResponseEntity.notFound().build();
		else {
			cubicle.setId(id);
			cubicleRepository.save(cubicle);
			return ResponseEntity.noContent().build();
		}
	}
}
