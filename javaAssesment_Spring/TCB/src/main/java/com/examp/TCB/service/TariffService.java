package com.examp.TCB.service;

import java.util.List;

import com.examp.TCB.model.TariffModel;

public interface TariffService {

	public String createTariffDetails(TariffModel tariff);

	public TariffModel getTariffDetails(String activityType);

	public String updateTariffDetails(TariffModel tariff);

	public String deleteTariffDetails(String activityType);

	public List<TariffModel> getAllTariffDetails();

}
