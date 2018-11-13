package com.cwsms.model.office;

import com.cwsms.model.office.type.OfficeType;

public class Office {
	private OfficeType officeType;

	public OfficeType getOfficeType() {
		return officeType;
	}

	public void setOfficeType(OfficeType officeType) {
		this.officeType = officeType;
	}

	public Office(OfficeType officeType) {
		super();
		this.officeType = officeType;
	}

	public Office() {
		super();
	}
}
