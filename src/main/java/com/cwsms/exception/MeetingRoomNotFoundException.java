package com.cwsms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MeetingRoomNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6503867250015528632L;

	public MeetingRoomNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
