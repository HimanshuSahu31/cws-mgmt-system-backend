package com.cwsms.exception;

public class IssueTypeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871393863037800327L;
	
	public IssueTypeNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
