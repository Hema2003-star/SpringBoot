package com.examp.TCB.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examp.TCB.model.TariffModel;
import com.examp.TCB.repo.TariffRepo;
import com.examp.TCB.service.TariffService;

@Service
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
	public String createTariffDetails(TariffModel tariff) {
		tariffRepo.save(tariff);
		return "created successfully";
	}

	// get tariff
	@Override
	public TariffModel getTariffDetails(String activityType) {
	    return tariffRepo.findById(activityType)
	            .orElseThrow(() -> new RuntimeException("Tariff not found"));
	}

	// update tariff
	@Override
	public String updateTariffDetails(TariffModel tariff) {
		tariffRepo.save(tariff);
		return "updated successfully";
	}

	// delete tariff details
	@Override
	public String deleteTariffDetails(String activityType) {
		tariffRepo.deleteById(activityType);
		return "deleted successfully";
	}

	// get all tariff
	@Override
	public List<TariffModel> getAllTariffDetails() {

		return tariffRepo.findAll();
	}

}
