package com.examp.TCB.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examp.TCB.model.TariffModel;

public interface TariffService {

	public ResponseEntity<String> createTariffDetails(TariffModel tariff);

	public ResponseEntity<TariffModel> getTariffDetails(String activityType);

	public ResponseEntity<String> updateTariffDetails(TariffModel tariff);

	public ResponseEntity<String> deleteTariffDetails(String activityType);

	public ResponseEntity<List<TariffModel>> getAllTariffDetails();

}
