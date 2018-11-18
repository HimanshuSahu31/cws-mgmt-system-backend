package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8750234597719509675L;
	
	public AddressNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
