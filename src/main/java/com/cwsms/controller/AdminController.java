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
import com.cwsms.exception.AdminNotFoundException;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.repository.AdminRepository;

@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping(RESTConstants.ADMIN)
	public List<Admin> getAllAdmin() {
		System.out.println("dekh:"+adminRepository.findAll().size());
		return adminRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.ADMIN_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Admin> getAdminById(@PathVariable Long id) throws AdminNotFoundException {
		Optional<Admin> admin = adminRepository.findById(id);
		if(!admin.isPresent()) throw new AdminNotFoundException("Admin ID: "+id);
		Resource<Admin> resource = new Resource<Admin>(admin.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllAdmin());
		resource.add(linkTo.withRel(RESTConstants.ADMIN_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.ADMIN_ID)
	public void deleteAdminById(@PathVariable Long id) {
		adminRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.ADMIN)
	public ResponseEntity<Object> addNewAdmin(@RequestBody Admin admin) {
		Admin newAdmin = adminRepository.save(admin);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newAdmin.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.ADMIN_ID)
	public ResponseEntity<Object> updateAdmin(@RequestBody Admin admin, @PathVariable Long id) {
		Optional<Admin> optionalAdmin = adminRepository.findById(id);
		
		if(!optionalAdmin.isPresent())
			return ResponseEntity.notFound().build();
		else {
			admin.setId(id);
			adminRepository.save(admin);
			return ResponseEntity.noContent().build();
		}
	}
}
