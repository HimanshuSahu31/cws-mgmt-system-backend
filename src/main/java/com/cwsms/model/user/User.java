package com.cwsms.model.user;

import java.util.Date;
import com.cwsms.model.address.Address;

public abstract class User {
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected Address address;
	protected Date dateOfBirth;
	protected String email;
	protected String phoneNumber;
	protected String idProof;
	protected Boolean status;
	protected String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected String getMiddleName() {
		return middleName;
	}
	protected void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected Address getAddress() {
		return address;
	}
	protected void setAddress(Address address) {
		this.address = address;
	}
	protected Date getDateOfBirth() {
		return dateOfBirth;
	}
	protected void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getPhoneNumber() {
		return phoneNumber;
	}
	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	protected String getIdProof() {
		return idProof;
	}
	protected void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	protected Boolean getStatus() {
		return status;
	}
	protected void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
