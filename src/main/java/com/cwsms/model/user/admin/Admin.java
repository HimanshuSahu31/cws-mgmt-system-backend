package com.cwsms.model.user.admin;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.user.User;
import com.cwsms.model.issue.Issue;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value=SpringConstants.ADMIN_DISCRIMINATOR_VALUE)
@Table(name = SpringConstants.TABLE_ADMIN)
public class Admin extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -457170900709667129L;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity = Issue.class, mappedBy=SpringConstants.ADMIN_FK_ISSUES)
	private Set<Issue> issuesAssigned = new HashSet<>();

	public Admin(Set<Issue> issuesAssigned) {
		super();
		this.issuesAssigned = issuesAssigned;
	}
	public Admin() {
		super();
	}
	public Admin(Integer id) {
		this.id = new Long(id);
	}
	
}
