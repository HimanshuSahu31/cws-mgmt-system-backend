package com.cwsms.model.payment;

import com.cwsms.model.user.customer.Customer;

public class Payment {
	private String details;
	private Float amount;
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
