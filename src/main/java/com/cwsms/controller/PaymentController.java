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
import com.cwsms.exception.PaymentNotFoundException;
import com.cwsms.model.payment.Payment;
import com.cwsms.repository.PaymentRepository;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@GetMapping(RESTConstants.PAYMENT)
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.PAYMENT_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<Payment> getPaymentById(@PathVariable Long id) throws PaymentNotFoundException {
		Optional<Payment> payment = paymentRepository.findById(id);
		if(!payment.isPresent()) throw new PaymentNotFoundException("Payment ID: "+id);
		Resource<Payment> resource = new Resource<Payment>(payment.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllPayments());
		resource.add(linkTo.withRel(RESTConstants.PAYMENT_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.PAYMENT_ID)
	public void deletePaymentById(@PathVariable Long id) {
		paymentRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.PAYMENT)
	public ResponseEntity<Object> addNewPayment(@RequestBody Payment payment) {
		Payment newPayment = paymentRepository.save(payment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newPayment.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.PAYMENT_ID)
	public ResponseEntity<Object> updatePayment(@RequestBody Payment payment, @PathVariable Long id) {
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		
		if(!optionalPayment.isPresent())
			return ResponseEntity.notFound().build();
		else {
			payment.setId(id);
			paymentRepository.save(payment);
			return ResponseEntity.noContent().build();
		}
	}
}
