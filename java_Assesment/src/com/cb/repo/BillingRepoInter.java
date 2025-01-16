package com.cb.repo;

import java.util.List;

import com.cb.model.Billing;

public interface BillingRepoInter {
	
	public Billing calculateAndStoreBill(int customerId);
	public void storeBillInDatabase(int customerId, String customerName, double totalBill);
	public List<Billing> generateBillForAllCustomers();
	public Billing calculateBillWithoutStoring(int customerId);

}
