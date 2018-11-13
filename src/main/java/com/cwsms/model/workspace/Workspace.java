package com.cwsms.model.workspace;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.office.Office;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.model.user.receptionist.Receptionist;
import com.cwsms.model.user.customer.Customer;

@Entity
@Table(name=SpringConstants.TABLE_WORKSPACE)
public class Workspace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_WORKSPACE)
	@SequenceGenerator(name=SpringConstants.GENERATOR_WORKSPACE, sequenceName=SpringConstants.SEQUENCE_WORKSPACE)
	private Long id;
	
	@Column(name=SpringConstants.WORKSPACE_OFFICES, nullable=false)
	private List<Office> offices;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Receptionist.class)
	@JoinColumn(name=SpringConstants.WORKSPACE_RECEPTIONIST)
	private Receptionist receptionist;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Admin.class)
	@JoinColumn(name=SpringConstants.WORKSPACE_ADMIN)
	private Admin admin;
	
	@Column(name=SpringConstants.WORKSPACE_FLOORS, nullable=false)
	private Integer floors;
	
	@Column(name=SpringConstants.WORKSPACE_CAPACITY, nullable=false)
	private Integer capacity;
	
	@Column(name=SpringConstants.WORKSPACE_CUSTOMERS, nullable=false)
	private List<Customer> customers;
	
	
	public List<Office> getOffices() {
		return offices;
	}
	public void setOffices(List<Office> offices) {
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
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
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
	public Workspace(List<Office> offices, Receptionist receptionist, Admin admin, Integer floors, Integer capacity,
			List<Customer> customers) {
		super();
		this.offices = offices;
		this.receptionist = receptionist;
		this.admin = admin;
		this.floors = floors;
		this.capacity = capacity;
		this.customers = customers;
	}
	
}
