package com.cwsms.model.user.customer;

import com.cwsms.model.user.User;

import java.util.List;

import com.cwsms.model.booking.Booking;
import com.cwsms.model.issue.Issue;
import com.cwsms.model.office.type.OfficeType;

public abstract class Customer extends User{
	public List<Booking> viewPreviousBookings(){
		return null;
	}
	
	public Customer viewUsageAnalytics() {
		return null;
	}
	
	public Boolean bookOffice(final OfficeType officeType) {
		return null;
	}
	
	public Boolean cancelBooking(Booking booking) {
		return null;
	}
	
	public void raiseIssue(final Issue issue) {
		
	}
	
	public void requestNationalPass() {
		
	}
	
	public Boolean makePayment() {
		return null;
	}
}
