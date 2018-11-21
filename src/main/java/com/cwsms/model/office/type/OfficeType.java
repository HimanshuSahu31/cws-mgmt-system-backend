package com.cwsms.model.office.type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.Office;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name=SpringConstants.OFFICETYPE_DISCRIMINATOR)
@Table(name=SpringConstants.TABLE_OFFICE_TYPE)
public abstract class OfficeType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator=SpringConstants.SEQUENCE_OFFICE_TYPE)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_OFFICE_TYPE, sequenceName=SpringConstants.SEQUENCE_OFFICE_TYPE)
	@Column(name=SpringConstants.OFFICETYPE_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	protected Long id;
	
	@Column(name=SpringConstants.OFFICETYPE_DESCRIPTION, length=300, nullable=false)
	protected String officeTypeDescription;
	
	@Column(name=SpringConstants.OFFICETYPE_CAPACITY, nullable=false)
	@Min(value=5)
	@Max(value=50)
	protected Integer officeTypeCapacity;
	
	@Column(name=SpringConstants.OFFICETYPE_PRICE, nullable=false)
	@DecimalMin(value=SpringConstants.OFFICETYPE_PRICE_MIN)
	@DecimalMax(value=SpringConstants.OFFICETYPE_PRICE_MAX)
	protected Float officeTypePrice;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.OFFICE_FK_TYPE)
	protected Office office;
	
	public String getOfficeTypeDescription() {
		return officeTypeDescription;
	}
	public void setOfficeTypeDescription(String officeTypeDescription) {
		this.officeTypeDescription = officeTypeDescription;
	}
	public Integer getOfficeTypeCapacity() {
		return officeTypeCapacity;
	}
	public void setOfficeTypeCapacity(Integer officeTypeCapacity) {
		this.officeTypeCapacity = officeTypeCapacity;
	}
	public Float getOfficeTypePrice() {
		return officeTypePrice;
	}
	public void setOfficeTypePrice(Float officeTypePrice) {
		this.officeTypePrice = officeTypePrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
