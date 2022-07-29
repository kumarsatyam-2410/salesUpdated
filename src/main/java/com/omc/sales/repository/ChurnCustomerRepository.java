package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.ChurnCustomer;

public interface ChurnCustomerRepository extends JpaRepository<ChurnCustomer,Long> {

	List<ChurnCustomer> findAllByOrderByIdDesc();

}
