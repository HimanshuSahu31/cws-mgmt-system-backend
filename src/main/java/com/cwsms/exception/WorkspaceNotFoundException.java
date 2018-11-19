package com.cwsms.exception;

public class WorkspaceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4444605164502608466L;
	
	public WorkspaceNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
