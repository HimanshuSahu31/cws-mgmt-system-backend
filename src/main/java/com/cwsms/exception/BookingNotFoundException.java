package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2446083163098121318L;
	
	public BookingNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
