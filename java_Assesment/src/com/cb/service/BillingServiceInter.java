package com.cb.service;

import java.util.List;

import com.cb.model.Billing;

public interface BillingServiceInter {
	public String generateBillForCustomer(int customerId);
	public List<Billing> generateBillForAllCustomers();

}
