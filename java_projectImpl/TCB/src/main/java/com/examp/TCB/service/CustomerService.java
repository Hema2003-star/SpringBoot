package com.examp.TCB.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examp.TCB.model.CustomerModel;

public interface CustomerService {

	public ResponseEntity<String> createCustomerDetails(CustomerModel customer);

	public ResponseEntity<CustomerModel> getCustomerDetails(int customerId);

	public ResponseEntity<String> updateCustomerDetails(CustomerModel customer);

	public ResponseEntity<String> deleteCustomerDetails(int customerId);

	public ResponseEntity<List<CustomerModel>> getAllCustomerDetails();

}
