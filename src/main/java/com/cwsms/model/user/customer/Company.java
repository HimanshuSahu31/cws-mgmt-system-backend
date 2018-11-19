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
	
	public Company() {
		
	}
}
