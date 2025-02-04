package com.examp.TCB.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examp.TCB.model.CustomerModel;

public interface CustomerRepo extends JpaRepository<CustomerModel, Integer>{

}
