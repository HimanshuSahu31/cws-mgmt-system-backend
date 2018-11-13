package com.cwsms.exception;

public class WorkspaceDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4444605164502608466L;
	
	public WorkspaceDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
