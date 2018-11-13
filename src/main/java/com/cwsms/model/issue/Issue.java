package com.cwsms.model.issue;

import com.cwsms.model.issue.type.IssueType;

public class Issue {
	private IssueType issueType;
	private String description;
	private String status;
	
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
	
	
}
