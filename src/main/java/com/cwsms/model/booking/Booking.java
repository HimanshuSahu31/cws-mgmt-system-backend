package com.cwsms.model.booking;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.Office;
import com.cwsms.model.payment.Payment;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.model.user.customer.Customer;
import com.cwsms.model.workspace.Workspace;

@Entity
@Table(name=SpringConstants.TABLE_BOOKING)
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_BOOKING)
	@SequenceGenerator(name=SpringConstants.GENERATOR_BOOKING, sequenceName=SpringConstants.SEQUENCE_BOOKING)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Customer.class)
	@JoinColumn(name=SpringConstants.BOOKING_CUSTOMER, nullable=false)
	private Customer customer;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Admin.class)
	@JoinColumn(name=SpringConstants.BOOKING_ADMIN, nullable=false)
	private Admin admin;
	
	@Column(name=SpringConstants.BOOKING_DATE_OF_BOOKING, length=20, nullable=false)
	@DateTimeFormat(pattern=SpringConstants.BOOKING_DATE_FORMAT)
	private Date dateOfBooking;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Workspace.class)
	@JoinColumn(name=SpringConstants.BOOKING_WORKSPACE, nullable=false)
	private Workspace workspace;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Office.class)
	@JoinColumn(name=SpringConstants.BOOKING_OFFICE, nullable=false)
	private Office office;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Payment.class)
	@JoinColumn(name=SpringConstants.BOOKING_PAYMENT, nullable=false)
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
