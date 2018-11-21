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
	public static final String ISSUES_TYPE = "/issues/type/{id}";

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

	// Admin Controller
	public static final String ADMIN = "/admin";
	public static final String ADMIN_ID = "/admin/{id}";
	public static final String ADMIN_LINK = "all-admin";

	// Receptionist Controller
	public static final String RECPTIONIST = "/receptionist";
	public static final String RECPTIONIST_ID = "/receptionist/{id}";
	public static final String RECPTIONIST_LINK = "all-receptionist";

	// Single User Controller
	public static final String SINGLE_USER = "/singleuser";
	public static final String SINGLE_USER_ID = "/singleuser/{id}";
	public static final String SINGLE_USER_LINK = "all-single-user";

	// Receptionist Controller
	public static final String COMPANY = "/company";
	public static final String COMPANY_ID = "/company/{id}";
	public static final String COMPANY_LINK = "all-company";

	// Office Controller
	public static final String OFFICE = "/office";
	public static final String OFFICE_ID = "/office/{id}";
	public static final String OFFICE_LINK = "all-office";

	// Cubicle Controller
	public static final String CUBICLE = "/cubicle";
	public static final String CUBICLE_ID = "/cubicle/{id}";
	public static final String CUBICLE_LINK = "all-cubicle";

	// Meeting Room Controller
	public static final String MEETING_ROOM = "/meetingroom";
	public static final String MEETING_ROOM_ID = "/meetingroom/{id}";
	public static final String MEETING_ROOM_LINK = "all-meetingroom";

	// Payment Controller
	public static final String PAYMENT = "/payment";
	public static final String PAYMENT_ID = "/payment/{id}";
	public static final String PAYMENT_LINK = "all-payment";

	// Rights Controller
	public static final String RIGHTS = "/rights";
	public static final String RIGHTS_ID = "/rights/{id}";
	public static final String RIGHTS_LINK = "all-rights";

	// Workspace Controller
	public static final String WORKSPACE = "/workspace";
	public static final String WORKSPACE_ID = "/workspace/{id}";
	public static final String WORKSPACE_LINK = "all-workspace";
}
