package com.cwsms.model.office.type;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;

@Entity
@Table(name=SpringConstants.TABLE_CUBICLE)
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
	
	public Cubicle(Integer id) {
		super();
		this.id = new Long(id);
	}
}
