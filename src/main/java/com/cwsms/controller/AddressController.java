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
	
	@GetMapping(value=RESTConstants.ADDRESSES_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Address> getAllAddresses(@PathVariable Long id) throws AddressNotFoundException {
		Optional<Address> address = addressRepository.findById(id);
		if(!address.isPresent()) throw new AddressNotFoundException("Address ID: "+id);
		Resource<Address> resource = new Resource<Address>(address.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllAddresses());
		resource.add(linkTo.withRel(RESTConstants.ADDRESSES_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.ADDRESSES_ID)
	public void deleteAddressById(@PathVariable Long id) {
		addressRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.ADDRESSES)
	public ResponseEntity<Object> addNewAddress(@RequestBody Address address) {
		Address newAddress = addressRepository.save(address);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newAddress.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.ADDRESSES_ID)
	public ResponseEntity<Object> updateAddress(@RequestBody Address address, @PathVariable Long id) {
		Optional<Address> optionalAddress = addressRepository.findById(id);
		
		if(!optionalAddress.isPresent())
			return ResponseEntity.notFound().build();
		else {
			address.setId(id);
			addressRepository.save(address);
			return ResponseEntity.noContent().build();
		}
	}
}
