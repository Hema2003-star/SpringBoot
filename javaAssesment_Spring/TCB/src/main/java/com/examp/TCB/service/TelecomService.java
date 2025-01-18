package com.examp.TCB.service;

import java.util.List;

import com.examp.TCB.model.TelecomModel;

public interface TelecomService {
	

		public String createTelecomDetails(TelecomModel telecom);

		public TelecomModel getTelecoDetails(int activityId);

		public String updateTelecomDetails(TelecomModel telecom);

		public String deleteTelecomDetails(int activityId);

		public List<TelecomModel> getAllTelecomDetails();

	}


