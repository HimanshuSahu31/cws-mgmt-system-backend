package com.cwsms.model.user;

import com.cwsms.constants.SpringConstants;

import javax.persistence.*;

@Entity
@Table(name = SpringConstants.TABLE_RIGHTS)
public class Rights {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_RIGHTS)
	@SequenceGenerator(name=SpringConstants.GENERATOR_RIGHTS, sequenceName=SpringConstants.SEQUENCE_RIGHTS)
	private Long id;

	@Column(name=SpringConstants.RIGHTS_CAN_READ, nullable=false)
	private Boolean canRead;

	@Column(name=SpringConstants.RIGHTS_CAN_WRITE, nullable=false)
	private Boolean canWrite;

	@Column(name=SpringConstants.RIGHTS_CAN_DELETE, nullable=false)
	private Boolean canDelete;

	@Column(name=SpringConstants.RIGHTS_CAN_UPDATE, nullable=false)
	private Boolean canUpdate;

	@Column(name=SpringConstants.RIGHTS_CAN_CREATE, nullable=false)
	private Boolean canCreate;

	@Column(name=SpringConstants.RIGHTS_CAN_GRANT, nullable=false)
	private Boolean canGrant;

	@Column(name=SpringConstants.RIGHTS_CAN_REVOKE, nullable=false)
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
