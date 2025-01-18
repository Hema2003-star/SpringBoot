package com.examp.TCB.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examp.TCB.model.CustomerModel;
import com.examp.TCB.repo.CustomerRepo;
import com.examp.TCB.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	// constructor
	public CustomerServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	// create customer
	@Override
	public String createCustomerDetails(CustomerModel customer) {
		customerRepo.save(customer);
		return "Created successfully";
	}
	
	// get customer
	public CustomerModel getCustomerDetails(int customerId) {
	    return customerRepo.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));
	}
	

	// update customer
	@Override
	public String updateCustomerDetails(CustomerModel customer) {
		customerRepo.save(customer);
		return "updated successfully";
	}

	// delete customer
	@Override
	public String deleteCustomerDetails(int customerId) {
		customerRepo.deleteById(customerId);
		return "deleted successfully";
	}

	// list all the customer
	@Override
	public List<CustomerModel> getAllCustomerDetails() {

		return customerRepo.findAll();
	}

}
