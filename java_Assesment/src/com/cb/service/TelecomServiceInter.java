package com.cb.service;

import com.cb.model.TelecomActivity;

public interface TelecomServiceInter {
	
	public String insertActivityValidation(TelecomActivity activity);
	public String findActivityValidation(int id);
	public String findAllActivityValidation();

}
