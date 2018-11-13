package com.cwsms.model.workspace;

import java.util.List;

import com.cwsms.model.office.Office;
import com.cwsms.model.user.admin.Admin;
import com.cwsms.model.user.receptionist.Receptionist;
import com.cwsms.model.user.customer.Customer;

public class Workspace {
	private List<Office> offices;
	private Receptionist receptionist;
	private Admin admin;
	private Integer floors;
	private Integer capacity;
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
