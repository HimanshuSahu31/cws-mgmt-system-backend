package com.cwsms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cwsms.exception.BookingDoesNotExistException;
import com.cwsms.model.booking.Booking;
import com.cwsms.repository.BookingRepository;

@RestController
public class BookingController {
	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping(RESTConstants.BOOKINGS)
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	@GetMapping(RESTConstants.BOOKINGS_ID)
	public Booking getBooking(@PathVariable Long id) throws BookingDoesNotExistException{
		Optional<Booking> booking = bookingRepository.findById(id);
		if(!booking.isPresent()) {
			throw new BookingDoesNotExistException("Booking ID: "+id);
		}
		return booking.get();
	}
	
	@DeleteMapping(RESTConstants.BOOKINGS_ID)
	public void deleteBooking(@PathVariable Long id) {
		bookingRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.BOOKINGS)
	public ResponseEntity<Object> addNewBooking(@RequestBody Booking booking) {
		Booking newBooking = bookingRepository.save(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newBooking.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.BOOKINGS_ID)
	public ResponseEntity<Object> updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
		Optional<Booking> optionalBooking = bookingRepository.findById(id);
		
		if(!optionalBooking.isPresent())
			return ResponseEntity.notFound().build();
		else {
			booking.setId(id);
			bookingRepository.save(booking);
			return ResponseEntity.noContent().build();
		}
	}
}
