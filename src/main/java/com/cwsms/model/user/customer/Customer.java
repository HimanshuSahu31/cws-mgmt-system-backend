package com.cwsms.model.user.customer;

import com.cwsms.model.booking.Booking;
import com.cwsms.model.user.User;
import com.cwsms.model.workspace.Workspace;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue(value=SpringConstants.CUSTOMER_DISCRIMINATOR)
@Table(name=SpringConstants.TABLE_CUSTOMER)
public class Customer extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2262403509003702327L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_CUSTOMER)
	@SequenceGenerator(name=SpringConstants.GENERATOR_CUSTOMER, sequenceName=SpringConstants.SEQUENCE_CUSTOMER)
	@Column(name=SpringConstants.CUSTOMER_ID)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.BOOKING_FK_CUSTOMER)
	private Booking booking;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.WORKSPACE_FK_CUSTOMERS)
	private Set<Workspace> workspace = new HashSet<>();
	
	public Customer() {
		
	}
}
