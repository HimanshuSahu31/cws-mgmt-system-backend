package com.cwsms.model.payment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.booking.Booking;
import com.cwsms.model.user.customer.Customer;

@Entity
@Table(name=SpringConstants.TABLE_PAYMENT)
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.SEQUENCE_PAYMENT)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_PAYMENT, sequenceName=SpringConstants.SEQUENCE_PAYMENT)
	@Column(name=SpringConstants.PAYMENT_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	private Long id;
	
	@Column(name=SpringConstants.PAYMENT_DETAILS, length=255, nullable=false)
	private String details;
	
	@Column(name=SpringConstants.PAYMENT_AMOUNT, scale=10, precision=2, nullable=false)
	private Float amount;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, targetEntity=Booking.class)
	@JoinColumn(name=SpringConstants.PAYMENT_FK_BOOKING)
	private Booking booking;
	
	public Payment(Long id, String details, Float amount, Customer customer) {
		super();
		this.id = id;
		this.details = details;
		this.amount = amount;
	}
	public Payment() {
		super();
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Boolean makePayment() {
		return null;
	}
	
	public Boolean getPaymentStatus() {
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
