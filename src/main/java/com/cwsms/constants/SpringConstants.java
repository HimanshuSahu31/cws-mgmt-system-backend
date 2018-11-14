package com.cwsms.constants;

public class SpringConstants {
	private SpringConstants() {
		super();
	}
	
	public static final String SCAN_BASE_PACKAGE = "com.cwsms.constants.rest";
	
	// Table Workspace
	public static final String TABLE_WORKSPACE = "tb_workspace";
	public static final String SEQUENCE_WORKSPACE = "WORKSP_SEQ";
	public static final String GENERATOR_WORKSPACE = "workspace_sequence";
	public static final String WORKSPACE_OFFICES = "tb_workspace_offices";
	public static final String WORKSPACE_OFFICES_WORKSPACE = "workspace_offices_worksp_id";
	public static final String WORKSPACE_OFFICES_OFFICE = "workspace_offices_office_id";
	public static final String WORKSPACE_RECEPTIONIST = "receptionist_id";
	public static final String WORKSPACE_ADMIN = "admin_id";
	public static final String WORKSPACE_FLOORS = "floors";
	public static final String WORKSPACE_CAPACITY = "capacity";
	public static final String WORKSPACE_CUSTOMERS = "tb_workspace_customers";
	public static final String WORKSPACE_OFFICES_CUSTOMER = "workspace_cust_id";
	
	// Table Payment
	public static final String TABLE_PAYMENT = "tb_payment";
	public static final String SEQUENCE_PAYMENT = "PAYMENT_SEQ";
	public static final String GENERATOR_PAYMENT = "payment_sequence";
	public static final String PAYMENT_DETAILS = "payment_details";
	public static final String PAYMENT_AMOUNT = "payment_amount";
	public static final String PAYMENT_CUSTOMER = "payment_customer";
	
	// Table Office
	public static final String TABLE_OFFICE = "tb_office";
	public static final String GENERATOR_OFFICE = "office_sequence";
	public static final String SEQUENCE_OFFICE = "OFFICE_SEQ";
	public static final String OFFICE_TYPE = "office_type";
	public static final String OFFICE_DESCRIPTION = "office_desc";
	public static final String OFFICE_ADDRESS = "office_addr";
	public static final String OFFICE_RATING = "office_rating";
	
	// Table Office Type
	public static final String TABLE_OFFICE_TYPE = "tb_office_type";
	public static final String GENERATOR_OFFICE_TYPE = "office_type_sequence";
	public static final String SEQUENCE_OFFICE_TYPE = "OFFICE_TYPE_SEQ";
	public static final String OFFICETYPE_DISCRIMINATOR = "office_type_name";
	public static final String OFFICETYPE_DESCRIPTION = "office_type_name";
	public static final String OFFICETYPE_CAPACITY = "office_type_name";
	public static final String OFFICETYPE_PRICE = "office_type_name";
	public static final String OFFICETYPE_PRICE_MIN = "1000.0";
	public static final String OFFICETYPE_PRICE_MAX = "15000.0";
	
	// Table Issue
	public static final String TABLE_ISSUE = "tb_issue";
	public static final String GENERATOR_ISSUE = "issue_sequence";
	public static final String SEQUENCE_ISSUE = "ISSUE_SEQ";
	public static final String ISSUE_TYPE = "issue_type";
	public static final String ISSUE_STATUS = "issue_status";
	public static final String ISSUE_DESCRIPTION = "issue_desc";
	
	// Table Issue Type
	public static final String TABLE_ISSUE_TYPE = "tb_issue_type";
	public static final String GENERATOR_ISSUE_TYPE = "issue_type_sequence";
	public static final String SEQUENCE_ISSUE_TYPE = "ISSUE_TYPE_SEQ";
	public static final String ISSUE_TYPE_NAME = "issue_type_name";
	public static final String ISSUE_TYPE_PRIORITY = "issue_type_priority";
	
	// Table Booking
	public static final String TABLE_BOOKING = "tb_booking";
	public static final String GENERATOR_BOOKING = "booking_sequence";
	public static final String SEQUENCE_BOOKING = "BOOKING_SEQ";
	public static final String BOOKING_CUSTOMER = "booking_customer";
	public static final String BOOKING_ADMIN = "booking_admin";
	public static final String BOOKING_DATE_OF_BOOKING = "booking_date";
	public static final String BOOKING_DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
	public static final String BOOKING_WORKSPACE = "booking_workspace";
	public static final String BOOKING_OFFICE = "booking_office";
	public static final String BOOKING_PAYMENT = "booking_payment";
	
	// Table Meeting Room
	public static final String TABLE_MEETING_ROOM = "tb_meeting_room";
	
	// Table Cubicle
	public static final String TABLE_CUBICLE = "tb_cubicle";
}
