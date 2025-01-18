package com.examp.TCB.service;

import java.util.List;

import com.examp.TCB.model.BillingModel;

public interface BillingService {

	public BillingModel generateBillForCustomer(int customerId);

	public List<BillingModel> generateBillForAllCustomers();

}
