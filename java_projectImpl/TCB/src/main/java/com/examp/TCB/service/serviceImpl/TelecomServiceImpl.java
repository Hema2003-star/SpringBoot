package com.examp.TCB.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examp.TCB.exception.TelecomNotFoundException;
import com.examp.TCB.model.TelecomModel;
import com.examp.TCB.repo.TelecomRepo;
import com.examp.TCB.service.TelecomService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TelecomServiceImpl implements TelecomService {

	@Autowired
	private TelecomRepo telecomRepo;

	// constructor
	public TelecomServiceImpl(TelecomRepo telecomRepo) {
		super();
		this.telecomRepo = telecomRepo;
	}

	@Override
	public ResponseEntity<String> createTelecomDetails(TelecomModel telecom) {
		log.info("adding activity");
		telecomRepo.save(telecom);
		return new ResponseEntity<>("Created Telecom Activity successfully", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TelecomModel> getTelecomDetails(int activityId) {
		log.info("getting activity");

		try {
			return new ResponseEntity<>(telecomRepo.findById(activityId).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> updateTelecomDetails(TelecomModel telecom) {
		log.info("updating activity");
		telecomRepo.save(telecom);
		return new ResponseEntity<>("Updated Telecom Activity successfully", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> deleteTelecomDetails(int activityId) {
		log.info("deleting activity");
		if (telecomRepo.findById(activityId).isEmpty())
			throw new TelecomNotFoundException("Requested activity details not found");
		telecomRepo.deleteById(activityId);
		return new ResponseEntity<>("Deleted telecom activity successfully", HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<List<TelecomModel>> getAllTelecomDetails() {
		return new ResponseEntity<>(telecomRepo.findAll(), HttpStatus.OK);
	}

}
