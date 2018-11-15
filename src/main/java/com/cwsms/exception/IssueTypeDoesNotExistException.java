package com.cwsms.exception;

public class IssueTypeDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871393863037800327L;
	
	public IssueTypeDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
