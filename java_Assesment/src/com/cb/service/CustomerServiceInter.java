package com.cb.service;

import com.cb.model.Customer;

public interface CustomerServiceInter {
	
	public String customerValidation(Customer customer);
	public String findCustomerValidation(int id);
	public String findAllCustomerValidation() ;

}
