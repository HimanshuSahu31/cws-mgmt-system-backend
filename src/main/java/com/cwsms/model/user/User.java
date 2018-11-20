package com.cwsms.model.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.address.Address;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name=SpringConstants.USER_DISCRIMINATOR)
@DiscriminatorValue(value=SpringConstants.USER_DISCRIMINATOR_VALUE)
@Table(name = SpringConstants.TABLE_USER)
public abstract class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1902095698133115692L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.SEQUENCE_USER)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_USER, sequenceName=SpringConstants.SEQUENCE_USER)
	@Column(name=SpringConstants.USER_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL, unique=true)
	protected Long id;
	
	@Column(name=SpringConstants.USER_USERNAME, length=30, nullable=false, updatable=false, unique=true)
	protected String username;
	
	@Column(name=SpringConstants.USER_PASSWORD, length=255, nullable=false, updatable=true)
	protected char[] password;

	@Column(name=SpringConstants.USER_FIRST_NAME, length=20, nullable=false)
	protected String firstName;

	@Column(name=SpringConstants.USER_MIDDLE_NAME, length=20, nullable=false)
	protected String middleName;

	@Column(name=SpringConstants.USER_LAST_NAME, length=20, nullable=false)
	protected String lastName;

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, targetEntity=Address.class)
	@JoinColumn(name=SpringConstants.USER_ADDRESS, nullable=false)
	protected Address userAddress;

	@Column(name=SpringConstants.USER_DATE_OF_BIRTH, length=20, nullable=false)
	//@DateTimeFormat(pattern=SpringConstants.USER_DATE_FORMAT)
	protected String dateOfBirth;

	@Column(name=SpringConstants.USER_EMAIL, length=300, nullable=false)
	protected String email;

	@Column(name=SpringConstants.USER_PHONE_NUMBER, length=15, nullable=false)
	protected String phoneNumber;

	@Column(name=SpringConstants.USER_ID_PROOF, length=50, nullable=false)
	protected String idProof;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinTable(name=SpringConstants.TB_USER_RIGHTS, joinColumns={@JoinColumn(name=SpringConstants.USER_ID)}, inverseJoinColumns={@JoinColumn(name=SpringConstants.RIGHTS_ID)})
	protected Set<Rights> userRights = new HashSet<>();

	@Column(name=SpringConstants.USER_STATUS, nullable=false)
	protected Boolean status;

	public User(Long id, String username, char[] password, String firstName, String middleName, String lastName,
			String dateOfBirth, String email, String phoneNumber, String idProof,
			Set<Rights> userRights, Boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.idProof = idProof;
		this.userRights = userRights;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Rights> getRights() {
		return userRights;
	}

	public void setRights(Set<Rights> rights) {
		this.userRights = rights;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public Set<Rights> getUserRights() {
		return userRights;
	}

	public void setUserRights(Set<Rights> userRights) {
		this.userRights = userRights;
	}
	
	
}
