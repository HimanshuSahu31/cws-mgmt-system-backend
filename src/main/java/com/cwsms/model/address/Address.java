package com.cwsms.model.address;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.Office;
import com.cwsms.model.user.User;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = SpringConstants.TABLE_ADDRESS)
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 591204668284727338L;

	@Id
	@SequenceGenerator(name=SpringConstants.SEQUENCE_ADDRESS, sequenceName=SpringConstants.SEQUENCE_ADDRESS, allocationSize=1)
	@GeneratedValue(strategy= GenerationType.IDENTITY, generator= SpringConstants.SEQUENCE_ADDRESS)
	@Column(name=SpringConstants.ADDRESS_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	private Long id;

	@Column(name=SpringConstants.ADDRESS_LINE_ONE, length=300, nullable=false)
	private String addressLineOne;

	@Column(name=SpringConstants.ADDRESS_LINE_TWO, length=300, nullable=true)
	private String addressLineTwo;

	@Column(name=SpringConstants.ADDRESS_LINE_THREE, length=300, nullable=true)
	private String addressLineThree;

	@Column(name=SpringConstants.ADDRESS_PINCODE, length=10, nullable=false)
	private String pincode;

	@Column(name=SpringConstants.ADDRESS_AREA, length=100, nullable=false)
	private String area;

	@Column(name=SpringConstants.ADDRESS_CITY, length=100, nullable=false)
	private String city;

	@Column(name=SpringConstants.ADDRESS_STATE, length=100, nullable=false)
	private String state;

	@Column(name=SpringConstants.ADDRESS_COUNTRY, length=50, nullable=false)
	private String country;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.OFFICE_FK_ADDRESS)
	private Office office;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.USER_FK_ADDRESS)
	private User user;
	
	public Address(Long id, String addressLineOne, String addressLineTwo, String addressLineThree, String pincode,
			String area, String city, String state, String country, Office office, User user) {
		super();
		this.id = id;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.pincode = pincode;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.office = office;
		this.user = user;
	}
	public Address(Integer id) {
		super();
		this.id = new Long(id);
	}
	public Address() {
		super();
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getAddressLineThree() {
		return addressLineThree;
	}
	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
