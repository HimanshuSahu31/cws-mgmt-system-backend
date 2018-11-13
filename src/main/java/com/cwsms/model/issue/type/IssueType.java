package com.cwsms.model.issue.type;

public class IssueType {
	private String issueTypeName;
	private String issueTypePriority;
	public IssueType(String issueTypeName, String issueTypePriority) {
		super();
		this.issueTypeName = issueTypeName;
		this.issueTypePriority = issueTypePriority;
	}
	public IssueType() {
		super();
	}
	public String getIssueTypeName() {
		return issueTypeName;
	}
	public void setIssueTypeName(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}
	public String getIssueTypePriority() {
		return issueTypePriority;
	}
	public void setIssueTypePriority(String issueTypePriority) {
		this.issueTypePriority = issueTypePriority;
	}
}
