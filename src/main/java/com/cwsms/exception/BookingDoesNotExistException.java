package com.cwsms.exception;

public class BookingDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2446083163098121318L;
	
	public BookingDoesNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
