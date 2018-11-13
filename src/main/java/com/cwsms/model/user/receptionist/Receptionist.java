package com.cwsms.model.user.receptionist;

import com.cwsms.model.user.User;
import com.cwsms.model.workspace.Workspace;

public class Receptionist extends User {
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
