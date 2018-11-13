package com.cwsms.model.booking;

import java.util.Date;

import com.cwsms.model.office.Office;
import com.cwsms.model.payment.Payment;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.model.user.customer.Customer;
import com.cwsms.model.workspace.Workspace;

public class Booking {
	private Customer customer;
	private Admin admin;
	private Date dateOfBooking;
	private Workspace workspace;
	private Office office;
	private Payment payment;
	public Booking(Customer customer, Admin admin, Date dateOfBooking, Workspace workspace, Office office,
			Payment payment) {
		super();
		this.customer = customer;
		this.admin = admin;
		this.dateOfBooking = dateOfBooking;
		this.workspace = workspace;
		this.office = office;
		this.payment = payment;
	}
	public Booking() {
		super();
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public Workspace getWorkspace() {
		return workspace;
	}
	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
