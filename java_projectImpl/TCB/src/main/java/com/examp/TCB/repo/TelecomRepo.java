package com.examp.TCB.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examp.TCB.model.TelecomModel;

public interface TelecomRepo extends JpaRepository<TelecomModel, Integer> {
	 List<TelecomModel> findByCustomerCustomerId(int customerId);

}
