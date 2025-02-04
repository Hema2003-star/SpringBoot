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

import com.examp.TCB.model.TelecomModel;
import com.examp.TCB.service.TelecomService;

@RestController
@RequestMapping("/telecom")
public class TelecomController {

	@Autowired
	private TelecomService telecomService;

	// create activity
	@PostMapping
	public ResponseEntity<String> createTelecom(@RequestBody TelecomModel telecomModel) {
		return telecomService.createTelecomDetails(telecomModel);

	}

	// update customer
	@PutMapping
	public ResponseEntity<String> updateTelecom(@RequestBody TelecomModel telecomModel) {
		return telecomService.updateTelecomDetails(telecomModel);

	}

	// read specific customer from db
	@GetMapping("{activityId}")
	public ResponseEntity<TelecomModel> getTelecom(@PathVariable("activityId") int activityId) {
		return telecomService.getTelecomDetails(activityId);

	}

	// read all customer from db
	@GetMapping
	public ResponseEntity<List<TelecomModel>> getAllTelecom() {
		return telecomService.getAllTelecomDetails();

	}

	// delete customer details
	@DeleteMapping("{activityId}")
	public ResponseEntity<String> deleteTariff(@PathVariable int activityId) {
		return telecomService.deleteTelecomDetails(activityId);

	}

}
