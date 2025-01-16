package com.cb.service;

import com.cb.model.Tariff;

public interface TariffServiceInter {
	
	public String updateTariffValidation(Tariff tariff);
	public String findtariffValidation(int id);
	public String findAllTariffValidation();

}
