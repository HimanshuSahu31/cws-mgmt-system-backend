package com.cwsms.constants;

public class RESTConstants {

	private RESTConstants() {
		super();
	}

	// Common
	public static final String ID = "/{id}";

	// Booking Controller
	public static final String BOOKINGS = "/bookings";
	public static final String BOOKINGS_ID = "/bookings{id}";

	// Issue Controller
	public static final String ISSUES = "/issues";
	public static final String ISSUES_ID = "/issues{id}";

	// Issue Type Controller
	public static final String ISSUE_TYPES = "/issuetype";
	public static final String ISSUE_TYPE_ID = "/issuetype{id}";
}
