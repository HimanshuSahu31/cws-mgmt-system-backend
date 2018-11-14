package com.cwsms.model.user.admin;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.type.OfficeType;
import com.cwsms.model.user.Rights;
import com.cwsms.model.user.User;
import com.cwsms.model.issue.Issue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = SpringConstants.TABLE_ADMIN)
public class Admin extends User {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= SpringConstants.GENERATOR_ADMIN)
	@SequenceGenerator(name=SpringConstants.GENERATOR_ADMIN, sequenceName=SpringConstants.SEQUENCE_ADMIN)
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity= Rights.class)
	@JoinColumn(name=SpringConstants.ADMIN_RIGHTS, nullable=false)
	private Rights rights;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity = Issue.class)
	@JoinColumn(name=SpringConstants.ADMIN_ISSUES, nullable=false)
	private List<Issue> issuesAssigned;

	public Admin(Rights rights, List<Issue> issuesAssigned) {
		super();
		this.rights = rights;
		this.issuesAssigned = issuesAssigned;
	}
	public Admin() {
		super();
	}
	public Rights getRights() {
		return rights;
	}
	public void setRights(Rights rights) {
		this.rights = rights;
	}
	public List<Issue> getIssuesAssigned() {
		return issuesAssigned;
	}
	public void setIssuesAssigned(List<Issue> issuesAssigned) {
		this.issuesAssigned = issuesAssigned;
	}
	
	
}
