package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerAcquisition;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findAllById(Long id);
	public Customer findByCustomerName(String customerName);
	public List<Customer> getCustomerById(Long id);
	public List<Customer> findAllCustomerBySll(String sll);
	

}
