package com.cwsms.model.office;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.address.Address;
import com.cwsms.model.booking.Booking;
import com.cwsms.model.office.type.OfficeType;
import com.cwsms.model.workspace.Workspace;

@Entity
@Table(name=SpringConstants.TABLE_OFFICE)
public class Office {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_OFFICE)
	@SequenceGenerator(name=SpringConstants.GENERATOR_OFFICE, sequenceName=SpringConstants.SEQUENCE_OFFICE)
	@Column(name=SpringConstants.OFFICE_ID)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=OfficeType.class)
	@JoinColumn(name=SpringConstants.OFFICE_TYPE, nullable=false)
	private OfficeType officeType;
	
	@Column(name=SpringConstants.OFFICE_DESCRIPTION, length=300, nullable=false)
	private String officeDescription;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Address.class)
	@JoinColumn(name=SpringConstants.OFFICE_ADDRESS, nullable=false)
	private Address officeAddress;
	
	@Column(name=SpringConstants.OFFICE_RATING, nullable=false)
	@Min(value=1)
	@Max(value=5)
	private Integer officeRating;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.OFFICE_FK_BOOKING)
	private Booking booking;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.WORKSPACE_FK_OFFICES)
	private Set<Workspace> workspace = new HashSet<Workspace>();
	
	public String getOfficeDescription() {
		return officeDescription;
	}

	public void setOfficeDescription(String officeDescription) {
		this.officeDescription = officeDescription;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Integer getOfficeRating() {
		return officeRating;
	}

	public void setOfficeRating(Integer officeRating) {
		this.officeRating = officeRating;
	}

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
