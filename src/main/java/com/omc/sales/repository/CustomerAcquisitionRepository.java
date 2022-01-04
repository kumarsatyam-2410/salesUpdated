package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerAcquisition;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerAcquisitionRepository extends JpaRepository<CustomerAcquisition, Long> {

	public CustomerAcquisition findByCustomerName(String customerName);
	
	

}
