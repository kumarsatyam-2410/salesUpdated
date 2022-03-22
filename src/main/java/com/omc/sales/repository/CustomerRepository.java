package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustomerName(String customerName);
	public List<Customer> getCustomerById(Long id);
	

}
