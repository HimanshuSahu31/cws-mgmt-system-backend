package com.cwsms.model.user;

public class Rights {
	private Boolean canRead;
	private Boolean canWrite;
	private Boolean canDelete;
	private Boolean canUpdate;
	private Boolean canCreate;
	private Boolean canGrant;
	private Boolean canRevoke;
	public Rights(Boolean canRead, Boolean canWrite, Boolean canDelete, Boolean canUpdate, Boolean canCreate,
			Boolean canGrant, Boolean canRevoke) {
		super();
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.canDelete = canDelete;
		this.canUpdate = canUpdate;
		this.canCreate = canCreate;
		this.canGrant = canGrant;
		this.canRevoke = canRevoke;
	}
	public Rights() {
		super();
	}
	public Boolean getCanRead() {
		return canRead;
	}
	public void setCanRead(Boolean canRead) {
		this.canRead = canRead;
	}
	public Boolean getCanWrite() {
		return canWrite;
	}
	public void setCanWrite(Boolean canWrite) {
		this.canWrite = canWrite;
	}
	public Boolean getCanDelete() {
		return canDelete;
	}
	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}
	public Boolean getCanUpdate() {
		return canUpdate;
	}
	public void setCanUpdate(Boolean canUpdate) {
		this.canUpdate = canUpdate;
	}
	public Boolean getCanCreate() {
		return canCreate;
	}
	public void setCanCreate(Boolean canCreate) {
		this.canCreate = canCreate;
	}
	public Boolean getCanGrant() {
		return canGrant;
	}
	public void setCanGrant(Boolean canGrant) {
		this.canGrant = canGrant;
	}
	public Boolean getCanRevoke() {
		return canRevoke;
	}
	public void setCanRevoke(Boolean canRevoke) {
		this.canRevoke = canRevoke;
	}
}
