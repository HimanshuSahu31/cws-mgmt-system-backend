package com.cwsms.model.user;

import java.util.Date;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.address.Address;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = SpringConstants.TABLE_USER)
public abstract class User {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_USER)
	@SequenceGenerator(name=SpringConstants.GENERATOR_USER, sequenceName=SpringConstants.SEQUENCE_USER)
	private Long id;

	@Column(name=SpringConstants.USER_FIRST_NAME, length=300, nullable=false)
	private String firstName;

	@Column(name=SpringConstants.USER_MIDDLE_NAME, length=300, nullable=false)
	private String middleName;

	@Column(name=SpringConstants.USER_LAST_NAME, length=300, nullable=false)
	private String lastName;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Address.class)
	@JoinColumn(name=SpringConstants.USER_ADDRESS, nullable=false)
	private Address address;

	@Column(name=SpringConstants.USER_DATE_OF_BIRTH, length=20, nullable=false)
	@DateTimeFormat(pattern=SpringConstants.USER_DATE_FORMAT)
	private Date dateOfBirth;

	@Column(name=SpringConstants.USER_EMAIL, length=50, nullable=false)
	private String email;

	@Column(name=SpringConstants.USER_PHONE_NUMBER, length=15, nullable=false)
	private String phoneNumber;

	@Column(name=SpringConstants.USER_ID_PROOF, length=50, nullable=false)
	private String idProof;

	@Column(name=SpringConstants.USER_STATUS, nullable=false)
	private Boolean status;

	public User(String firstName, String middleName, String lastName, Address address, Date dateOfBirth, String email, String phoneNumber, String idProof, Boolean status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.idProof = idProof;
		this.status = status;
	}

	public User() { super(); }

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
