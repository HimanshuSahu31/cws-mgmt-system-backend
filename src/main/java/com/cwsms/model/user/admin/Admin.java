package com.cwsms.model.user.admin;

import com.cwsms.model.user.Rights;
import com.cwsms.model.user.User;
import com.cwsms.model.issue.Issue;

import java.util.List;

public class Admin extends User {
	private Rights rights;
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
