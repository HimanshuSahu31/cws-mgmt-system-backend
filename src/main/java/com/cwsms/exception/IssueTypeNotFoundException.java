package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IssueTypeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871393863037800327L;
	
	public IssueTypeNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
