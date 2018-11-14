package com.cwsms.model.office.type;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;

@Entity
@Table(name=SpringConstants.TABLE_MEETING_ROOM)
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
