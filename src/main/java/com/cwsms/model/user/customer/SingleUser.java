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
//	@Id
//	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_SINGLE_USER)
//	@SequenceGenerator(name=SpringConstants.GENERATOR_SINGLE_USER, sequenceName=SpringConstants.SEQUENCE_SINGLE_USER)
//	@Column(name=SpringConstants.SINGLE_USER_ID)
//	private Long id;
	
	public SingleUser() {
		
	}
}
