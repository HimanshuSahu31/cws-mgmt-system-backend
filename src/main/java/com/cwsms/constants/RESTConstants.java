package com.cwsms.constants;

public class RESTConstants {

	private RESTConstants() {
		super();
	}

	// Common
	public static final String ID = "/{id}";
	public static final String ERROR = "/error";
	public static final String MEDIA_TYPE_JSON_HAL = "application/hal+json";

	// Booking Controller
	public static final String BOOKINGS = "/bookings";
	public static final String BOOKINGS_ID = "/bookings/{id}";
	public static final String BOOKINGS_LINK = "all-bookings";

	// Issue Controller
	public static final String ISSUES = "/issues";
	public static final String ISSUES_ID = "/issues/{id}";
	public static final String ISSUES_LINK = "all-users";

	// Issue Type Controller
	public static final String ISSUE_TYPES = "/issuetype";
	public static final String ISSUE_TYPE_ID = "/issuetype/{id}";
	public static final String ISSUE_TYPES_LINK = "all-users";
	
	// Address Controller
	public static final String ADDRESSES = "/addresses";
	public static final String ADDRESSES_ID = "/addresses/{id}";
	public static final String ADDRESSES_LINK = "all-addresses";
	
	// User Controller
	public static final String USERS = "/users";
	public static final String USERS_ID = "/users/{id}";
	public static final String USERS_LINK = "all-users";
}
