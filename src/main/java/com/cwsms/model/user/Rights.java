package com.cwsms.model.user;

import com.cwsms.constants.SpringConstants;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = SpringConstants.TABLE_RIGHTS)
public class Rights implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6216907676570262704L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.SEQUENCE_RIGHTS)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_RIGHTS, sequenceName=SpringConstants.SEQUENCE_RIGHTS)
	@Column(name=SpringConstants.RIGHTS_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
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
	
	@ManyToMany(mappedBy=SpringConstants.USER_FK_RIGHTS, cascade= {CascadeType.PERSIST,CascadeType.MERGE}, fetch=FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	public Rights(Long id, Boolean canRead, Boolean canWrite, Boolean canDelete, Boolean canUpdate, Boolean canCreate,
			Boolean canGrant, Boolean canRevoke) {
		super();
		this.id = id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rights(Integer id) {
		super();
		this.id = new Long(id);
	}
}
