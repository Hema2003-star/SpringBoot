package com.cb.model;

public class Customer {

	private int customerId;
	private String name;
	private String address;
	private long contactNumber;

	// default constructor
	public Customer() {
		super();
	}

	// parameterized constructor
	public Customer(int customerId, String name, String address, long contactNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	// Getters and Setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return " \n Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + "]";
	}

}
