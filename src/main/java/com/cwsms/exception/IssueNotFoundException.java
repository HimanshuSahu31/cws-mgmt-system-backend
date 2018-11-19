package com.cwsms.exception;

public class IssueNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976777561792952533L;
	
	public IssueNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
