package com.cwsms.exception;

public class IssueDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976777561792952533L;
	
	public IssueDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
