package com.cwsms.exception;

public class BookingNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2446083163098121318L;
	
	public BookingNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
