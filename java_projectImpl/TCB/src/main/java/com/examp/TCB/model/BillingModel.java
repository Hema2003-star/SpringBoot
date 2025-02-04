package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TCB_Billing")
@Getter
@Setter //@data    //spring container create object and assign default value for field
@NoArgsConstructor
@AllArgsConstructor

public class BillingModel {

	@Id
	private int customerId;
	private String customerName;
	private double totalBill;



	// to string
	@Override
	public String toString() {
		return "BillingModel [customerId=" + customerId + ", customerName=" + customerName + ", totalBill=" + totalBill
				+ "]";
	}

}
