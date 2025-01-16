package com.cb.service;

import com.cb.model.Tariff;
import com.cb.repo.TariffRepo;
import com.cb.repo.TariffRepoInter;

public class TariffService {

	TariffRepoInter tariffRepo = new TariffRepo();

	// updatevalidation
	public String updateTariffValidation(Tariff tariff) {
		String result;

		if (tariff == null) {
			result = "tariff Object is Null ";
		} else if (tariff.getActivityType() == null || tariff.getRate() == 0) {
			result = "Invalid tariff Data";
		} else {
			boolean flag = tariffRepo.insertTariff(tariff);
			if (flag) {
				result = "tariff Object Saved";
			} else {
				result = "tariff Object Not Saved ";
			}
		}
		return result;
	}

	// find method
	public String findtariffValidation(int id) {
		String result = "";

		if (id == 0) {
			result = "Invalid Id";
		} else {
			Tariff tariff = tariffRepo.doFindTariff(result);
			if (tariff != null) {
				result = tariff.toString();
			} else {
				result = "tariff Object not Found";
			}
		}
		return result;

	}

	// find all
	public String findAllTariffValidation() {
		return tariffRepo.doFindAllTariff().toString();
	}

}
