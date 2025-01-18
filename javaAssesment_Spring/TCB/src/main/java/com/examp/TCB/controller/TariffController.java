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

import com.examp.TCB.model.TariffModel;
import com.examp.TCB.service.TariffService;

@RestController
@RequestMapping("/tariff")
public class TariffController {

	@Autowired
	private TariffService tariffService;

	// create customer
	@PostMapping
	public String createTariff(@RequestBody TariffModel TariffModel) {
		tariffService.createTariffDetails(TariffModel);
		return "created tariff details successfully";
	}

	// update customer
	@PutMapping
	public String updateTariff(@RequestBody TariffModel tariffModel) {
		tariffService.updateTariffDetails(tariffModel);
		return "updated tariff details successfully";
	}

	// read specific customer from db
	@GetMapping("{activityType}")
	public TariffModel getTariff(@PathVariable("activityType") String activityType) {

		return tariffService.getTariffDetails(activityType);

	}

	// read all customer from db
	@GetMapping
	public List<TariffModel> getAllTariff() {

		return tariffService.getAllTariffDetails();

	}

	// delete customer details
	@DeleteMapping("{activityType}")
	public String deleteTariff(@PathVariable String activityType) {

		tariffService.deleteTariffDetails(activityType);
		return "The Tariff details deleted successfully";

	}

}
