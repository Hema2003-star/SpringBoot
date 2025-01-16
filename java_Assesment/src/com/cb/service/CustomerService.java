package com.cb.service;

import com.cb.model.Customer;
import com.cb.repo.CustomerRepo;
import com.cb.repo.CustomerRepoInter;

public class CustomerService {

	CustomerRepoInter customerRepo = new CustomerRepo();

	// insertvalidation
	public String customerValidation(Customer customer) {
		String result;

		if (customer == null) {
			result = "customer Object is Null ";
		} else if (customer.getCustomerId() == 0 || customer.getName() == null || customer.getAddress() == null
				|| customer.getContactNumber() == 0) {
			result = "Invalid customer Data";
		} else {
			boolean flag = customerRepo.doInsertCustomer(customer);
			if (flag) {
				result = "customer Object Saved";
			} else {
				result = "customer Object Not Saved ";
			}
		}
		return result;
	}

	// find method
	public String findCustomerValidation(int id) {
		String result = "";

		if (id == 0) {
			result = "Invalid Id";
		} else {
			Customer customer = customerRepo.doFindCustomer(id);
			if (customer != null) {
				result = customer.toString();
			} else {
				result = "Customer Object not Found";
			}
		}
		return result;

	}

	// find all
	public String findAllCustomerValidation() {
		return customerRepo.doFindAllCustomer().toString();
	}

}
