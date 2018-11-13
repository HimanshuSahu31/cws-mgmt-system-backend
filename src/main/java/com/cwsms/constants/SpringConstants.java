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
	public static final String WORKSPACE_OFFICES = "offices";
	public static final String WORKSPACE_RECEPTIONIST = "receptionist_id";
	public static final String WORKSPACE_ADMIN = "admin_id";
	public static final String WORKSPACE_FLOORS = "floors";
	public static final String WORKSPACE_CAPACITY = "capacity";
	public static final String WORKSPACE_CUSTOMERS = "customers";
	
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
}
