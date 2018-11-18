package com.cwsms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cwsms.constants.RESTConstants;
import com.cwsms.exception.AddressNotFoundException;
import com.cwsms.repository.AddressRepository;
import com.cwsms.model.address.Address;

@RestController
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping(RESTConstants.ADDRESSES)
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.ADDRESS_ID, produces= {MediaType.APPLICATION_JSON_VALUE,"application/hal+json"})
	public Resource<Address> getAllAddresses(@PathVariable Long id) throws AddressNotFoundException {
		Optional<Address> address = addressRepository.findById(id);
		if(!address.isPresent()) throw new AddressNotFoundException("Address ID: "+id);
		Resource<Address> resource = new Resource<Address>(address.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllAddresses());
		resource.add(linkTo.withRel("all-addresses"));
		return resource;
	}
}
