package com.examp.TCB.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.examp.TCB.model.BillingModel;
import com.examp.TCB.model.CustomerModel;
import com.examp.TCB.model.TariffModel;
import com.examp.TCB.model.TelecomModel;
import com.examp.TCB.repo.BillingRepo;
import com.examp.TCB.repo.CustomerRepo;
import com.examp.TCB.repo.TelecomRepo;
import com.examp.TCB.service.BillingService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepo billingRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private TelecomRepo telecomRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Transactional
	@Override
	public ResponseEntity<BillingModel> generateBillForCustomer(int customerId) {

		log.info("Generating the bill");
		log.error("The error log in Billing");
		log.warn("The warn log in Billing");
		log.debug("The debug log in Billing");
		log.trace("The trace log in Billing");
		// Fetch the customer from the repository
		CustomerModel customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		// Fetch all telecom activities for the customer
		List<TelecomModel> telecomActivities = telecomRepo.findByCustomerCustomerId(customerId);


		double totalBill = 0.0;

		// Calculate total bill for the customer
		for (TelecomModel activity : telecomActivities) {
			TariffModel tariffs = activity.getTariff();
			String type = tariffs.getActivityType();
			
			TariffModel tariff = restTemplate.getForObject("http://localhost:8080/tariff/"+type,TariffModel.class);
			if (tariff != null) {
				double rate = tariff.getRate();
				totalBill += activity.getValue() * rate;
			}
		}

		// Create and save the billing record
		BillingModel billing = new BillingModel(customerId, customer.getCustomerName(), totalBill);

		billingRepo.save(billing);

		return new ResponseEntity<>(billing,HttpStatus.OK);
	}

	// get tariff
	@Override
	public ResponseEntity<BillingModel> getBillingDetails(int customerId) {
		return new ResponseEntity<>(billingRepo.findByCustomerId(customerId),HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<BillingModel>> listBillForAllCustomers() {

		try {
			return new ResponseEntity<>(billingRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
}
