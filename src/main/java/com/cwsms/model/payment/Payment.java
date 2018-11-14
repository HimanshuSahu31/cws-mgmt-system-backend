package com.cwsms.model.payment;

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

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.user.customer.Customer;

@Entity
@Table(name=SpringConstants.TABLE_PAYMENT)
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_PAYMENT)
	@SequenceGenerator(name=SpringConstants.GENERATOR_PAYMENT, sequenceName=SpringConstants.SEQUENCE_PAYMENT)
	private Long id;
	
	@Column(name=SpringConstants.PAYMENT_DETAILS, length=255, nullable=false)
	private String details;
	
	@Column(name=SpringConstants.PAYMENT_AMOUNT, scale=10, precision=2, nullable=false)
	private Float amount;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Customer.class)
	@JoinColumn(name=SpringConstants.PAYMENT_CUSTOMER, nullable=false)
	private Customer customer;
	
	public Payment(String details, Float amount, Customer customer) {
		super();
		this.details = details;
		this.amount = amount;
		this.customer = customer;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Boolean makePayment() {
		return null;
	}
	
	public Boolean getPaymentStatus() {
		return null;
	}
}
