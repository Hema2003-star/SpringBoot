package com.examp.TCB.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examp.TCB.model.TelecomModel;
import com.examp.TCB.repo.TelecomRepo;
import com.examp.TCB.service.TelecomService;

@Service
public class TelecomServiceImpl implements TelecomService {
	
	@Autowired
	private TelecomRepo telecomRepo;

	// constructor
	public TelecomServiceImpl(TelecomRepo telecomRepo) {
		super();
		this.telecomRepo = telecomRepo;
	}

	@Override
	public String createTelecomDetails(TelecomModel telecom) {
		telecomRepo.save(telecom);
		return "Created Telecom Activity successfully";
	}

	@Override
	public TelecomModel getTelecoDetails(int activityId) {

		return telecomRepo.findById(activityId).get();
	}

	@Override
	public String updateTelecomDetails(TelecomModel telecom) {
		telecomRepo.save(telecom);
		return "Updated Telecom Activity successfully";
	}

	@Override
	public String deleteTelecomDetails(int activityId) {
		telecomRepo.deleteById(activityId);
		return "Deleted telecom activity successfully";
	}

	@Override
	public List<TelecomModel> getAllTelecomDetails() {
		return telecomRepo.findAll();
	}

}
