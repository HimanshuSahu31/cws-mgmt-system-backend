package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RightsNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1598943069089013457L;

	public RightsNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
