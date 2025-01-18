package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "TCB_Billing")

public class BillingModel {

	@Id
	private int customerId;
	private String customerName;
	private double totalBill;


	public BillingModel() {
		super();
	}

	public BillingModel(int customerId, String customerName, double totalBill) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalBill = totalBill;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}


	@Override
	public String toString() {
		return "BillingModel [customerId=" + customerId + ", customerName=" + customerName + ", totalBill=" + totalBill
				+ "]";
	}

}
