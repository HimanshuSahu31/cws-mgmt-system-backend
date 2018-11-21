package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5297446518206534548L;
	
	public PaymentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
