package com.cwsms.model.user.admin;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.user.User;
import com.cwsms.model.issue.Issue;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = SpringConstants.TABLE_ADMIN)
public class Admin extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -457170900709667129L;

//	@Id
//	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_ADMIN)
//	@SequenceGenerator(name=SpringConstants.GENERATOR_ADMIN, sequenceName=SpringConstants.SEQUENCE_ADMIN)
//	@Column(name=SpringConstants.ADMIN_ID)
//	private Long id;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity = Issue.class, mappedBy=SpringConstants.ADMIN_FK_ISSUES)
	private Set<Issue> issuesAssigned = new HashSet<>();

	public Admin(Set<Issue> issuesAssigned) {
		super();
		this.issuesAssigned = issuesAssigned;
	}
	public Admin() {
		super();
	}
	
	public Set<Issue> getIssuesAssigned() {
		return issuesAssigned;
	}
	public void setIssuesAssigned(Set<Issue> issuesAssigned) {
		this.issuesAssigned = issuesAssigned;
	}
	
	
	
}
