package com.cb.repo;

import java.util.List;

import com.cb.model.Tariff;

public interface TariffRepoInter {
	
	public Tariff doFindTariff(String activityType);
	public boolean doUpdateTariff(Tariff tariff);
	public boolean insertTariff(Tariff tariff);
	public List<Tariff> doFindAllTariff();

}
