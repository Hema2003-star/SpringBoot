package com.examp.TCB.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examp.TCB.model.TelecomModel;

public interface TelecomService {

	public ResponseEntity<String> createTelecomDetails(TelecomModel telecom);

	public ResponseEntity<TelecomModel> getTelecomDetails(int activityId);

	public ResponseEntity<String> updateTelecomDetails(TelecomModel telecom);

	public ResponseEntity<String> deleteTelecomDetails(int activityId);

	public ResponseEntity<List<TelecomModel>> getAllTelecomDetails();

}
