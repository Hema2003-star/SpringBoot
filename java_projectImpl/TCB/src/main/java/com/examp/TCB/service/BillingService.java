package com.examp.TCB.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examp.TCB.model.BillingModel;

public interface BillingService {
	
	// method to build individual cust
	public ResponseEntity<BillingModel> generateBillForCustomer(int customerId);
	
	// to list 
	public ResponseEntity<List<BillingModel>> listBillForAllCustomers();
	
	//get details
	public ResponseEntity<BillingModel> getBillingDetails(int customerId);

}
