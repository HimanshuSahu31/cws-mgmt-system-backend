package com.cwsms.model.workspace;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.Office;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.model.user.receptionist.Receptionist;
import com.cwsms.model.user.customer.Customer;

@Entity
@Table(name=SpringConstants.TABLE_WORKSPACE)
public class Workspace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.SEQUENCE_WORKSPACE)
	@SequenceGenerator(name=SpringConstants.SEQUENCE_WORKSPACE, sequenceName=SpringConstants.SEQUENCE_WORKSPACE)
	@Column(name=SpringConstants.WORKSPACE_ID, updatable=false, columnDefinition=SpringConstants.COLUMN_BIG_SERIAL)
	private Long id;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name=SpringConstants.WORKSPACE_OFFICES, joinColumns={@JoinColumn(name=SpringConstants.WORKSPACE_ID)}, inverseJoinColumns={@JoinColumn(name=SpringConstants.OFFICE_ID)})
	private Set<Office> offices = new HashSet<Office>();
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Receptionist.class)
	@JoinColumn(name=SpringConstants.WORKSPACE_RECEPTIONIST, nullable=false)
	private Receptionist receptionist;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Admin.class)
	@JoinColumn(name=SpringConstants.WORKSPACE_ADMIN, nullable=false)
	private Admin admin;
	
	@Column(name=SpringConstants.WORKSPACE_FLOORS, nullable=false)
	@Min(value=1)
	@Max(value=10)
	private Integer floors;
	
	@Column(name=SpringConstants.WORKSPACE_CAPACITY, nullable=false)
	@Min(value=5)
	@Max(value=50)
	private Integer capacity;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name=SpringConstants.WORKSPACE_CUSTOMERS, joinColumns={@JoinColumn(name=SpringConstants.WORKSPACE_ID)}, inverseJoinColumns={@JoinColumn(name=SpringConstants.CUSTOMER_ID)})
	private Set<Customer> customers = new HashSet<Customer>();
	
	public Set<Office> getOffices() {
		return offices;
	}
	public void setOffices(Set<Office> offices) {
		this.offices = offices;
	}
	public Receptionist getReceptionist() {
		return receptionist;
	}
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public Workspace() {
		super();
	}
	public Integer getFloors() {
		return floors;
	}
	public void setFloors(Integer floors) {
		this.floors = floors;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Workspace(Set<Office> offices, Receptionist receptionist, Admin admin, Integer floors, Integer capacity,
			Set<Customer> customers) {
		super();
		this.offices = offices;
		this.receptionist = receptionist;
		this.admin = admin;
		this.floors = floors;
		this.capacity = capacity;
		this.customers = customers;
	}
	
}
