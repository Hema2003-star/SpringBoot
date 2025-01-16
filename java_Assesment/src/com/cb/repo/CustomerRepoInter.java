package com.cb.repo;

import java.util.List;

import com.cb.model.Customer;

public interface CustomerRepoInter {
	
	public boolean doInsertCustomer(Customer customer) ;
	public Customer doFindCustomer(int id) ;
	public List<Customer> doFindAllCustomer();

}
