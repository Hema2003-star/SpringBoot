package com.examp.TCB.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examp.TCB.exception.TelecomNotFoundException;
import com.examp.TCB.model.TariffModel;
import com.examp.TCB.repo.TariffRepo;
import com.examp.TCB.service.TariffService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TariffServiceImpl implements TariffService {

	@Autowired
	private TariffRepo tariffRepo;

	// constructor
	public TariffServiceImpl(TariffRepo tariffRepo) {
		super();
		this.tariffRepo = tariffRepo;
	}

	// create tariff
	@Override
	public ResponseEntity<String> createTariffDetails(TariffModel tariff) {
		log.info("adding tariff");
		tariffRepo.save(tariff);
		return new ResponseEntity<>("successfully created", HttpStatus.CREATED);
	}

	// get tariff
	@Override
	public ResponseEntity<TariffModel> getTariffDetails(String activityType) {
		log.info("getting tariff");

		try {
			return new ResponseEntity<>(tariffRepo.findById(activityType).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	// update tariff
	@Override
	public ResponseEntity<String> updateTariffDetails(TariffModel tariff) {
		log.info("updating tariff");
		tariffRepo.save(tariff);
		return new ResponseEntity<>("successfully updated", HttpStatus.CREATED);
	}

	// delete tariff details
	@Override
	public ResponseEntity<String> deleteTariffDetails(String activityType) {
		log.info("deleting tariff");
		if (tariffRepo.findById(activityType).isEmpty())
			throw new TelecomNotFoundException("Requested tariff details not found for deletion");
		tariffRepo.deleteById(activityType);
		return new ResponseEntity<>("successfully deleted", HttpStatus.CREATED);
	}

	// get all tariff
	@Override
	public ResponseEntity<List<TariffModel>> getAllTariffDetails() {

		return new ResponseEntity<>(tariffRepo.findAll(), HttpStatus.OK);
	}

}
