package com.examp.TCB.service;

import java.util.List;

import com.examp.TCB.model.CustomerModel;

public interface CustomerService {

	public String createCustomerDetails(CustomerModel customer);

	public CustomerModel getCustomerDetails(int customerId);

	public String updateCustomerDetails(CustomerModel customer);

	public String deleteCustomerDetails(int customerId);

	public List<CustomerModel> getAllCustomerDetails();

}
