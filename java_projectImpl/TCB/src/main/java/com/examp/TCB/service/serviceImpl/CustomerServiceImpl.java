package com.examp.TCB.service.serviceImpl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest.BodyPublishers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.examp.TCB.exception.TelecomNotFoundException;
import com.examp.TCB.model.CustomerModel;
import com.examp.TCB.repo.CustomerRepo;
import com.examp.TCB.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	// Constructor for dependency injection
	public CustomerServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public ResponseEntity<String> createCustomerDetails(CustomerModel customer) {
		log.info("adding customer");
		customerRepo.save(customer);
		return new ResponseEntity<>("successfully created", HttpStatus.CREATED);
	}

	////////////////////////////////////////////////////////////////////////
//	@Override
//	public CustomerModel getCustomerDetails(int customerId) {
//		log.info("getting customer");
//
//		// Check if the customer exists in the local database
//		if (customerRepo.findById(customerId).isEmpty()) {
//			throw new TelecomNotFoundException("Requested customer details not found");
//		}
//
//		// Customer found in local database, proceed to make the HTTP request
//		try {
//			// Create a new HttpClient instance
//			HttpClient client = HttpClient.newHttpClient();
//
//			// Create an HTTP request to the external API
//			HttpRequest request = HttpRequest.newBuilder()
//					.uri(new URI("http://example.com/api/customers/" + customerId)).build();
//
//			// Send the request and get the response
//			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//			// Check the response status
//			if (response.statusCode() == 200) {
//				log.info("Successfully fetched external data for customer ID: " + customerId);
//				// Process the response data here if needed
//			} else {
//				log.error("Failed to fetch external data for customer ID: " + customerId);
//			}
//		} catch (Exception e) {
//			log.error("Error during HTTP request", e);
//		}
//
//		// Return customer data from local repository
//		return customerRepo.findById(customerId).get();
//	}

	//////////////////////////////////////////////////////////////////////////

	@Override
	public ResponseEntity<CustomerModel> getCustomerDetails(int customerId) {
		log.info("getting customer");

		try {
			return new ResponseEntity<>(customerRepo.findById(customerId).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	// update customer
	@Override
	public ResponseEntity<String> updateCustomerDetails(CustomerModel customer) {
		log.info("updating customer");
		customerRepo.save(customer);
		return new ResponseEntity<>("successfully updated", HttpStatus.CREATED);
	}

	// delete customer
	@Override
	public ResponseEntity<String> deleteCustomerDetails(int customerId) {
		log.info("deleting customer");
		if (customerRepo.findById(customerId).isEmpty())
			throw new TelecomNotFoundException("Requested customer details not found  for deletion");
		customerRepo.deleteById(customerId);
		return new ResponseEntity<>("deleted successfully", HttpStatus.CREATED);

	}

	// list all the customer
	@Override
	public ResponseEntity<List<CustomerModel>> getAllCustomerDetails() {

		try {
			return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
