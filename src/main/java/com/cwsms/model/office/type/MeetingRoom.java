package com.cwsms.model.office.type;

public class MeetingRoom extends OfficeType {
	public MeetingRoom() {
		super();
	}
	
	public MeetingRoom(String officeTypeDescription, Integer officeTypeCapacity,
			Float officeTypePrice) {
		super();
		this.officeTypeDescription = officeTypeDescription;
		this.officeTypeCapacity = officeTypeCapacity;
		this.officeTypePrice = officeTypePrice;
	}
}
