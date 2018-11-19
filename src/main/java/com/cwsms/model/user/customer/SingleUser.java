package com.cwsms.model.user.customer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;

@Entity
@Table(name=SpringConstants.TABLE_SINGLE_USER)
public class SingleUser extends Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2682033411507511424L;
	
	public SingleUser() {
		
	}
}
