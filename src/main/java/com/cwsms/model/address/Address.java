package com.cwsms.model.address;

import com.cwsms.constants.SpringConstants;

import javax.persistence.*;

@Entity
@Table(name = SpringConstants.TABLE_ADDRESS)
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_ADDRESS)
	@SequenceGenerator(name=SpringConstants.GENERATOR_ADDRESS, sequenceName=SpringConstants.SEQUENCE_ADDRESS)
	private Long id;

	@Column(name=SpringConstants.ADDRESS_LINE_ONE, length=300, nullable=false)
	private String addressLineOne;

	@Column(name=SpringConstants.ADDRESS_LINE_TWO, length=300, nullable=false)
	private String addressLineTwo;

	@Column(name=SpringConstants.ADDRESS_LINE_THREE, length=300, nullable=false)
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
	
	public Address(String addressLineOne, String addressLineTwo, String addressLineThree, String pincode, String area,
			String city, String state, String country) {
		super();
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressLineThree = addressLineThree;
		this.pincode = pincode;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
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
}
