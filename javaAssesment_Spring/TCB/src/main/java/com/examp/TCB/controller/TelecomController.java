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
import com.examp.TCB.model.TariffModel;
import com.examp.TCB.model.TelecomModel;
import com.examp.TCB.service.CustomerService;
import com.examp.TCB.service.TariffService;
import com.examp.TCB.service.TelecomService;

@RestController
@RequestMapping("/telecom")
public class TelecomController {

	@Autowired
	private TelecomService telecomService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TariffService tariffService;

	// create activity
	@PostMapping
	public String createTelecom(@RequestBody TelecomModel telecomModel) {

		if (telecomModel.getCustomer() == null || telecomModel.getTariff() == null) {
			return "Customer or Tariff information is missing in the request.";
		}
		
		// Fetch the Customer and Tariff objects based on IDs
		CustomerModel customer = customerService.getCustomerDetails(telecomModel.getCustomer().getCustomerId());
		TariffModel tariff = tariffService.getTariffDetails(telecomModel.getTariff().getActivityType());

		// Set the fetched entities in the TelecomModel
		telecomModel.setCustomer(customer);
		telecomModel.setTariff(tariff);

		telecomService.createTelecomDetails(telecomModel);
		return "Created telecom details successfully";
	}

	// update customer
	@PutMapping
	public String updateTelecom(@RequestBody TelecomModel telecomModel) {
		telecomService.updateTelecomDetails(telecomModel);
		return "updated telecom details successfully";
	}

	// read specific customer from db
	@GetMapping("{activityId}")
	public TelecomModel getTelecom(@PathVariable("activityId") int activityId) {

		return telecomService.getTelecoDetails(activityId);

	}

	// read all customer from db
	@GetMapping
	public List<TelecomModel> getAllTelecom() {

		return telecomService.getAllTelecomDetails();

	}

	// delete customer details
	@DeleteMapping("{activityId}")
	public String deleteTariff(@PathVariable int activityId) {

		telecomService.deleteTelecomDetails(activityId);
		return "The Telecom details deleted successfully";

	}

}
