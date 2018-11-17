package com.cwsms.model.user.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;

@Entity
@Table(name = SpringConstants.TABLE_COMPANY)
public class Company extends Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -428294711312699229L;
//	@Id
//	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_COMPANY)
//	@SequenceGenerator(name=SpringConstants.GENERATOR_COMPANY, sequenceName=SpringConstants.SEQUENCE_COMPANY)
//	@Column(name=SpringConstants.COMPANY_ID)
//	private Long id;
	
	public Company() {
		
	}
}
