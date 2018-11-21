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
import com.cwsms.model.office.Office;
import com.cwsms.repository.OfficeRepository;
import com.cwsms.exception.OfficeNotFoundException;

@RestController
public class OfficeController {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@GetMapping(RESTConstants.OFFICE)
	public List<Office> getAllOffices() {
		return officeRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.OFFICE_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Office> getOfficeById(@PathVariable Long id) throws OfficeNotFoundException {
		Optional<Office> office = officeRepository.findById(id);
		if(!office.isPresent()) throw new OfficeNotFoundException("Office ID: "+id);
		Resource<Office> resource = new Resource<Office>(office.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllOffices());
		resource.add(linkTo.withRel(RESTConstants.OFFICE_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.OFFICE_ID)
	public void deleteOfficeById(@PathVariable Long id) {
		officeRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.OFFICE)
	public ResponseEntity<Object> addNewOffice(@RequestBody Office office) {
		Office newOffice = officeRepository.save(office);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newOffice.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.OFFICE_ID)
	public ResponseEntity<Object> updateOffice(@RequestBody Office office, @PathVariable Long id) {
		Optional<Office> optionalOffice = officeRepository.findById(id);
		
		if(!optionalOffice.isPresent())
			return ResponseEntity.notFound().build();
		else {
			office.setId(id);
			officeRepository.save(office);
			return ResponseEntity.noContent().build();
		}
	}
}
