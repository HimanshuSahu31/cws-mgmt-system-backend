package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IssueNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976777561792952533L;
	
	public IssueNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
