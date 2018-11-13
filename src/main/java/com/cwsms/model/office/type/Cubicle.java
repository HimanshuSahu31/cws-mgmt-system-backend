package com.cwsms.model.office.type;

public class Cubicle extends OfficeType {
	
	public Cubicle() {
		super();
	}
	
	public Cubicle(String officeTypeDescription, Integer officeTypeCapacity,
			Float officeTypePrice) {
		super();
		this.officeTypeDescription = officeTypeDescription;
		this.officeTypeCapacity = officeTypeCapacity;
		this.officeTypePrice = officeTypePrice;
	}
}
