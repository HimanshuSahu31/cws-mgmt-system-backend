package com.cwsms.model.user.receptionist;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.user.User;
import com.cwsms.model.workspace.Workspace;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value=SpringConstants.RECEPTIONIST_DISCRIMINATOR_VALUE)
@Table(name = SpringConstants.TABLE_RECEPTIONIST)
public class Receptionist extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4512148730457901065L;
	
	@OneToOne(fetch= FetchType.LAZY, cascade= CascadeType.PERSIST, targetEntity=Workspace.class)
	@JoinColumn(name= SpringConstants.RECEPTIONIST_WORKSPACE_ASSIGNED, nullable=false)
	private Workspace workspaceAssigned;

	public Workspace getWorkspaceAssigned() {
		return workspaceAssigned;
	}

	public void setWorkspaceAssigned(Workspace workspaceAssigned) {
		this.workspaceAssigned = workspaceAssigned;
	}

	public Receptionist(Workspace workspaceAssigned) {
		super();
		this.workspaceAssigned = workspaceAssigned;
	}

	public Receptionist() {
		super();
	}
}
