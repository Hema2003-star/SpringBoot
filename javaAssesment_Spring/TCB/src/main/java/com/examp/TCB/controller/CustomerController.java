package com.examp.TCB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examp.TCB.model.CustomerModel;
import com.examp.TCB.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	// create customer
	@PostMapping
	public String createCustomer(@RequestBody CustomerModel customerModel) {
		customerService.createCustomerDetails(customerModel);
		return "created customer details successfully";
	}

	// update customer
	@PutMapping
	public String updateCustomer(@RequestBody CustomerModel customerModel) {
		customerService.updateCustomerDetails(customerModel);
		return "updated customer details successfully";
	}

	// read specific customer from db
	@GetMapping("{customerId}")
	public CustomerModel getCloudVendor(@PathVariable("customerId") int customerId) {

		return customerService.getCustomerDetails(customerId);

	}

	// read all customer from db
	@GetMapping
	public List<CustomerModel> getAllCloudVendor() {

		return customerService.getAllCustomerDetails();

	}

	// delete customer details
	@DeleteMapping("{customerId}")
	public String deleteCloudVendor(@PathVariable int customerId) {

		customerService.deleteCustomerDetails(customerId);
		return "The customer details deleted successfully";

	}

}
