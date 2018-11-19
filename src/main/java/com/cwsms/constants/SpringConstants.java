package com.cwsms.constants;

public class SpringConstants {
	private SpringConstants() {
		super();
	}
	
	public static final String SCAN_PACKAGE_ENTITY = "com.cwsms.model";
	public static final String SCAN_PACKAGE_CONTROLLER = "com.cwsms.controller";
	public static final String COLUMN_BIG_SERIAL = "bigserial";
	
	// Table Workspace
	public static final String TABLE_WORKSPACE = "tb_workspace";
	public static final String SEQUENCE_WORKSPACE = "workspace_seq";
	public static final String WORKSPACE_OFFICES = "tb_workspace_offices";
	public static final String WORKSPACE_OFFICES_WORKSPACE = "workspace_offices_worksp_id";
	public static final String WORKSPACE_OFFICES_OFFICE = "workspace_offices_office_id";
	public static final String WORKSPACE_RECEPTIONIST = "receptionist_id";
	public static final String WORKSPACE_ADMIN = "admin_id";
	public static final String WORKSPACE_FLOORS = "floors";
	public static final String WORKSPACE_CAPACITY = "capacity";
	public static final String WORKSPACE_CUSTOMERS = "tb_workspace_customers";
	public static final String WORKSPACE_OFFICES_CUSTOMER = "workspace_cust_id";
	public static final String WORKSPACE_ID = "workspace_id";
	public static final String WORKSPACE_FK_BOOKING = "workspace";
	public static final String WORKSPACE_FK_CUSTOMERS = "customers";
	public static final String WORKSPACE_FK_OFFICES = "offices";
	
	// Table Payment
	public static final String TABLE_PAYMENT = "tb_payment";
	public static final String SEQUENCE_PAYMENT = "payment_seq";
	public static final String PAYMENT_DETAILS = "payment_details";
	public static final String PAYMENT_AMOUNT = "payment_amount";
	public static final String PAYMENT_CUSTOMER = "payment_customer";
	public static final String PAYMENT_ID = "payment_id";
	public static final String PAYMENT_FK_BOOKING = "payment_booking_id";
	
	// Table Office
	public static final String TABLE_OFFICE = "tb_office";
	public static final String SEQUENCE_OFFICE = "office_seq";
	public static final String OFFICE_TYPE = "office_type";
	public static final String OFFICE_DESCRIPTION = "office_desc";
	public static final String OFFICE_ADDRESS = "office_address";
	public static final String OFFICE_RATING = "office_rating";
	public static final String OFFICE_ID = "office_id";
	public static final String OFFICE_FK_TYPE = "officeType";
	public static final String OFFICE_FK_ADDRESS = "officeAddress";
	public static final String OFFICE_FK_BOOKING = "office";
	
	// Table Office Type
	public static final String TABLE_OFFICE_TYPE = "tb_office_type";
	public static final String SEQUENCE_OFFICE_TYPE = "office_type_seq";
	public static final String OFFICETYPE_DISCRIMINATOR = "office_type_name";
	public static final String OFFICETYPE_DESCRIPTION = "office_type_description";
	public static final String OFFICETYPE_CAPACITY = "office_type_capacity";
	public static final String OFFICETYPE_PRICE = "office_type_price";
	public static final String OFFICETYPE_PRICE_MIN = "1000.0";
	public static final String OFFICETYPE_PRICE_MAX = "15000.0";
	public static final String OFFICETYPE_ID = "office_type_id";
	
	// Table Issue
	public static final String TABLE_ISSUE = "tb_issue";
	public static final String SEQUENCE_ISSUE = "issue_seq";
	public static final String ISSUE_TYPE = "issue_type";
	public static final String ISSUE_STATUS = "issue_status";
	public static final String ISSUE_DESCRIPTION = "issue_desc";
	public static final String ISSUE_ID = "issue_id";
	public static final String ISSUE_FK = "issueType";
	public static final String ISSUE_ADMIN_ID = "issue_admin";
	
	// Table Issue Type
	public static final String TABLE_ISSUE_TYPE = "tb_issue_type";
	public static final String SEQUENCE_ISSUE_TYPE = "issue_type_seq";
	public static final String ISSUE_TYPE_NAME = "issue_type_name";
	public static final String ISSUE_TYPE_PRIORITY = "issue_type_priority";
	public static final String ISSUE_TYPE_ID = "issue_type_id";
	
	// Table Booking
	public static final String TABLE_BOOKING = "tb_booking";
	public static final String SEQUENCE_BOOKING = "booking_seq";
	public static final String BOOKING_CUSTOMER = "booking_customer";
	public static final String BOOKING_ADMIN = "booking_admin";
	public static final String BOOKING_DATE_OF_BOOKING = "booking_date";
	public static final String BOOKING_DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
	public static final String BOOKING_WORKSPACE = "booking_workspace";
	public static final String BOOKING_OFFICE = "booking_office";
	public static final String BOOKING_PAYMENT = "booking_payment";
	public static final String BOOKING_ID = "booking_id";
	public static final String BOOKING_FK_CUSTOMER = "customer";
	public static final String BOOKING_FK_ADMIN = "admin";
	public static final String BOOKING_FK_PAYMENT = "booking";
	
	// Table Meeting Room
	public static final String TABLE_MEETING_ROOM = "tb_meeting_room";
	public static final String MEETING_ROOM_ID = "meeting_room_id";
	
	// Table Cubicle
	public static final String TABLE_CUBICLE = "tb_cubicle";
	public static final String CUBICLE_ID = "cubicle_id";

	// Table Address
	public static final String TABLE_ADDRESS = "tb_address";
	public static final String SEQUENCE_ADDRESS = "address_seq";
	public static final String ADDRESS_LINE_ONE = "address_line_one";
	public static final String ADDRESS_LINE_TWO= "address_line_two";
	public static final String ADDRESS_LINE_THREE = "address_line_three";
	public static final String ADDRESS_PINCODE = "address_pincode";
	public static final String ADDRESS_AREA = "address_area";
	public static final String ADDRESS_CITY = "address_city";
	public static final String ADDRESS_STATE = "address_state";
	public static final String ADDRESS_COUNTRY = "address_country";
	public static final String ADDRESS_ID = "address_id";

	// Table User
	public static final String TABLE_USER = "tb_user";
	public static final String SEQUENCE_USER = "user_seq";
	public static final String USER_DISCRIMINATOR = "user_type";
	public static final String USER_USERNAME = "user_username";
	public static final String USER_PASSWORD = "user_password";
	public static final String USER_FIRST_NAME = "user_fname";
	public static final String USER_MIDDLE_NAME = "user_mname";
	public static final String USER_LAST_NAME = "user_lname";
	public static final String USER_ADDRESS = "user_address";
	public static final String USER_DATE_OF_BIRTH = "user_dob";
	public static final String USER_DATE_FORMAT = "dd/MM/yyyy";
	public static final String USER_EMAIL = "user_email";
	public static final String USER_PHONE_NUMBER = "user_phone";
	public static final String USER_ID_PROOF = "user_id_proof";
	public static final String USER_STATUS = "user_status";
	public static final String TB_USER_RIGHTS = "tb_user_rights";
	public static final String USER_ID = "user_id";
	public static final String USER_FK_RIGHTS = "userRights";
	public static final String USER_FK_ADDRESS = "userAddress";

	//Table Rights
	public static final String TABLE_RIGHTS = "tb_rights";
	public static final String SEQUENCE_RIGHTS = "rights_seq";
	public static final String RIGHTS_CAN_READ = "rights_can_read";
	public static final String RIGHTS_CAN_WRITE = "rights_can_write";
	public static final String RIGHTS_CAN_DELETE = "rights_can_delete";
	public static final String RIGHTS_CAN_UPDATE = "rights_can_update";
	public static final String RIGHTS_CAN_CREATE = "rights_can_create";
	public static final String RIGHTS_CAN_GRANT = "rights_can_grant";
	public static final String RIGHTS_CAN_REVOKE = "rights_can_revoke";
	public static final String RIGHTS_ID = "rights_id";
	public static final String RIGHTS_FK = "users";

	// Table Admin
	public static final String TABLE_ADMIN = "tb_admin";
	public static final String SEQUENCE_ADMIN= "admin_seq";
	public static final String ADMIN_ISSUES = "admin_issues";
	public static final String ADMIN_ID = "admin_id";
	public static final String ADMIN_FK_ISSUES = "issueAdmin";

	// Table Receptionist
	public static final String TABLE_RECEPTIONIST = "tb_receptionist";
	public static final String RECEPTIONIST_WORKSPACE_ASSIGNED = "receptionist_workspace";
	public static final String RECEPTIONIST_ID = "receptionist_id";
	
	// Table Company
	public static final String TABLE_COMPANY = "tb_company";
	public static final String COMPANY_ID = "company_id";
	
	// Table Single User
	public static final String TABLE_SINGLE_USER = "tb_single_user";
	public static final String SINGLE_USER_ID = "single_user_id";
	
	// Table Customer
	public static final String TABLE_CUSTOMER = "tb_customer";
	public static final String CUSTOMER_DISCRIMINATOR = "customer_type";
	public static final String SEQUENCE_CUSTOMER= "customer_seq";
	public static final String CUSTOMER_ID = "customer_id";
}
