package com.cb.service;

import com.cb.model.Billing;
import com.cb.model.Customer;
import com.cb.repo.BillingRepo;
import com.cb.repo.BillingRepoInter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.cb.repo.CustomerRepo;
import com.cb.repo.CustomerRepoInter;

public class BillingService {

	CustomerRepoInter customerRepo = new CustomerRepo(); // Initialize this object
	BillingRepoInter billingRepo = new BillingRepo();

	// Generate bill for a specific customer
	public String generateBillForCustomer(int customerId) {
		Customer customer = customerRepo.doFindCustomer(customerId);
		if (customer == null) {
			return "Customer ID " + customerId + " not found.";
		}

		Billing billing = billingRepo.calculateAndStoreBill(customerId);
		if (billing != null) {
			String billText = "======Final Bill for Customer " + customer.getCustomerId() + "======";
			billText += "\nCustomer Name  :" + customer.getName();
			billText += "\n-----------------------------------";
			billText += "\nTotal Price    : " + billing.getTotalBill();
			billText += "\n-----------------------------------";

			String filename = "D:\\customer" + customer.getCustomerId() + ".txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
				writer.write(billText);
				System.out.println("Bill saved to file: " + filename);
			} catch (IOException e) {
				System.out.println("Error generating file: " + e.getMessage());
			}

			return "Bill for Customer ID " + customerId + " generated successfully.";
		}
		return "Failed to generate bill for Customer ID " + customerId;
	}

	// Generate bill for all customers
	public List<Billing> generateBillForAllCustomers() {
		return billingRepo.generateBillForAllCustomers();
	}
}
