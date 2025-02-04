package com.examp.TCB.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examp.TCB.model.TariffModel;

public interface TariffRepo extends JpaRepository<TariffModel, String> {
	 TariffModel findByActivityType(String activityType);

}
