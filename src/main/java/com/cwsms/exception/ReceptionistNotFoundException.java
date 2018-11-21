package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReceptionistNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6900944976419059832L;
	
	public ReceptionistNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
