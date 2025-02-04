package com.examp.TCB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> createCustomer(@RequestBody CustomerModel customerModel) {
		return customerService.createCustomerDetails(customerModel);

	}

	// update customer
	@PutMapping
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerModel customerModel) {
		return customerService.updateCustomerDetails(customerModel);

	}

	// read specific customer from db
	@GetMapping("{customerId}")
	public ResponseEntity<CustomerModel> getCustomerDetails(@PathVariable("customerId") int customerId) {
		return customerService.getCustomerDetails(customerId);

	}

	// read all customer from db
	@GetMapping
	public ResponseEntity<List<CustomerModel>> getAllCustomerDetails() {
		return customerService.getAllCustomerDetails();

	}

	// delete customer details
	@DeleteMapping("{customerId}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable int customerId) {
		return customerService.deleteCustomerDetails(customerId);

	}

}
