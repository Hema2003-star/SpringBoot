package com.examp.TCB.controller;

import com.examp.TCB.model.BillingModel;
import com.examp.TCB.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

	    @Autowired
	    private BillingService billingService;

	    // Endpoint to generate bill for a specific customer
	    @PostMapping("/generate/{customerId}")  // notice the use of {customerId} in the URL
	    public BillingModel generateBillForCustomer(@PathVariable int customerId) {
	        return billingService.generateBillForCustomer(customerId); // Calling service method
	    }

	    // Endpoint to generate bills for all customers
	    @GetMapping("/generateAll")
	    public List<BillingModel> generateBillsForAllCustomers() {
	        return billingService.generateBillForAllCustomers();
	    }

	   
}

