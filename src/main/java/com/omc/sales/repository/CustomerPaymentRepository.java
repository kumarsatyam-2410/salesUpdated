package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerPaymentDetails;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPaymentDetails, Long> {

	public CustomerPaymentDetails findByCustomerId(Long customerId);
	

}
