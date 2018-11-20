package com.cwsms.model.issue.type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.issue.Issue;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name=SpringConstants.TABLE_ISSUE_TYPE)
public class IssueType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator=SpringConstants.SEQUENCE_ISSUE_TYPE)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_ISSUE_TYPE, sequenceName=SpringConstants.SEQUENCE_ISSUE_TYPE)
	@Column(name=SpringConstants.ISSUE_TYPE_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	private Long id;
	
	@Column(name=SpringConstants.ISSUE_TYPE_NAME, length=30, nullable=true)
	private String issueTypeName;
	
	@Column(name=SpringConstants.ISSUE_TYPE_PRIORITY, length=30, nullable=true)
	private String issueTypePriority;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE, mappedBy=SpringConstants.ISSUE_FK)
	private Issue issue;
	
	public IssueType(String issueTypeName, String issueTypePriority) {
		super();
		this.issueTypeName = issueTypeName;
		this.issueTypePriority = issueTypePriority;
	}
	public IssueType(Integer id) {
		this.id = new Long(id);
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
