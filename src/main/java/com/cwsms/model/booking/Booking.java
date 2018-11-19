package com.cwsms.model.booking;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator=SpringConstants.SEQUENCE_BOOKING)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_BOOKING, sequenceName=SpringConstants.SEQUENCE_BOOKING)
	@Column(name=SpringConstants.BOOKING_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Customer.class)
	@JoinColumn(name=SpringConstants.CUSTOMER_ID, nullable=false)
	private Customer customer;
	
	@Column(name=SpringConstants.BOOKING_DATE_OF_BOOKING, length=20, nullable=false)
	@DateTimeFormat(pattern=SpringConstants.BOOKING_DATE_FORMAT)
	private Date dateOfBooking;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Office.class)
	@JoinColumn(name=SpringConstants.OFFICE_ID, nullable=false)
	private Office office;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.BOOKING_FK_PAYMENT)
	private Set<Payment> payment = new HashSet<>();
	
	public Booking(Long id, Customer customer, Admin admin, Date dateOfBooking, Workspace workspace, Office office,
			Set<Payment> payment) {
		super();
		this.id = id;
		this.customer = customer;
		this.dateOfBooking = dateOfBooking;
		this.office = office;
		this.payment = payment;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	
}
