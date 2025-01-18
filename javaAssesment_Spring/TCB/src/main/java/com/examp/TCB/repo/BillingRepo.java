package com.examp.TCB.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examp.TCB.model.BillingModel;

public interface BillingRepo extends JpaRepository<BillingModel,Integer> {

}
