package com.cwsms.model.issue;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.issue.type.IssueType;
import com.cwsms.model.user.admin.Admin;

@Entity
@Table(name=SpringConstants.TABLE_ISSUE)
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_ISSUE)
	@SequenceGenerator(name=SpringConstants.GENERATOR_ISSUE, sequenceName=SpringConstants.SEQUENCE_ISSUE)
	@Column(name=SpringConstants.ISSUE_ID)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=IssueType.class)
	@JoinColumn(name=SpringConstants.ISSUE_TYPE_ID, nullable=false)
	private IssueType issueType;
	
	@Column(name=SpringConstants.ISSUE_DESCRIPTION, length=100, nullable=false)
	private String description;
	
	@Column(name=SpringConstants.ISSUE_STATUS, length=15, nullable=false)
	private String status;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, targetEntity=Admin.class)
	@JoinColumn(name=SpringConstants.ISSUE_ADMIN_ID, nullable=false)
	private Admin issueAdmin;
	
	public Issue(IssueType issueType, String description, String status) {
		super();
		this.issueType = issueType;
		this.description = description;
		this.status = status;
	}
	public Issue() {
		super();
	}
	public IssueType getIssueType() {
		return issueType;
	}
	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
