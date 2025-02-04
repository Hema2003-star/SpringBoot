package com.examp.TCB.controller;

import com.examp.TCB.model.BillingModel;
import com.examp.TCB.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

	    @Autowired
	    private BillingService billingService;

	    // Endpoint to generate bill for a specific customer
	    @PostMapping("/generate/{customerId}")  // notice the use of {customerId} in the URL
	    public ResponseEntity<BillingModel> generateBillForCustomer(@PathVariable int customerId) {
	        return billingService.generateBillForCustomer(customerId); // Calling service method
	    }

	    // Endpoint to list bills for all customers
	    @GetMapping("/listAll")
	    public ResponseEntity<List<BillingModel>> listBillsForAllCustomers() {
	        return billingService.listBillForAllCustomers();
	    }
	    
	    @GetMapping("{customerId}")
	    public ResponseEntity<BillingModel> getBillsForCustomer(@PathVariable("customerId") int  customerId) {
	        return billingService. getBillingDetails(customerId);
	    }
	   

	   
}

