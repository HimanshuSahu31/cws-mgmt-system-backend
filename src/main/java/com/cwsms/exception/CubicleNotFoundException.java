package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CubicleNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7928193564363045461L;

	public CubicleNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
