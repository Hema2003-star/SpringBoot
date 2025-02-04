package com.examp.TCB.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examp.TCB.model.BillingModel;
import com.examp.TCB.model.TariffModel;

public interface BillingRepo extends JpaRepository<BillingModel,Integer> {
	BillingModel findByCustomerId(int CustomerId);

}
