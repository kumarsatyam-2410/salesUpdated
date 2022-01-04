package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.CustomerAcquisitionHistory;



/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerAcquisitionHistoryRepository extends JpaRepository<CustomerAcquisitionHistory, Long> {

	//public CustomerAcquisitionHistory findByCustomerName(String customerName);
	
	

}
