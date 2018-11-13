package com.cwsms.model.office.type;

public abstract class OfficeType {
	protected Integer capacity;
	protected Float price;
	public OfficeType(Integer capacity, Float price) {
		super();
		this.capacity = capacity;
		this.price = price;
	}
	public OfficeType() {
		super();
	}
	protected Integer getCapacity() {
		return capacity;
	}
	protected void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	protected Float getPrice() {
		return price;
	}
	protected void setPrice(Float price) {
		this.price = price;
	}	
}
