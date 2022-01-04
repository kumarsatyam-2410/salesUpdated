package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.entity.Customer;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerRepository;

@Service
public class CustomerService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;


	/**
	 * Creates the customer.
	 *
	 * @param customerDTO  the customer DTO
	 * @param callInfo the call info
	 * @return the string
	 * @throws SSNSQLException 
	 * @throws Throwable 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createCustomer(CustomerDTO customerDTO) throws SSNSQLException{

		LOGGER.info("Request Received for createCustomer with parameters:"+ "customername: " + customerDTO.getCustomerName());

		// validate unique customer
		Customer existingCustomerEntity = customerRepository.findByCustomerName(customerDTO.getCustomerName());
		if(existingCustomerEntity != null){
			throw new SSNSQLException("Not Unique Customer", ErrorCodes.NOT_UNIQUE_CUSTOMER);
		}
		
		Customer customerEntity = new Customer();
		customerEntity.setActive(customerDTO.isActive());
		customerEntity.setCustomerName(customerDTO.getCustomerName());
		customerEntity.setGender(customerDTO.getGender());
		customerEntity.setAddress(customerDTO.getAddress());
		customerEntity.setZipcode(customerDTO.getZipcode());
		customerEntity.setMobile(customerDTO.getMobile());
		customerEntity.setAdharNumber(customerDTO.getAdharNumber());
		customerEntity.setPackageType(customerDTO.getPackageType());
		customerEntity.setSubscriptionType(customerDTO.getSubscriptionType());
		customerEntity.setCustomerPic(customerDTO.getCustomerPic());
		customerEntity.setLatitude(customerDTO.getLatitude());
		customerEntity.setLongitude(customerDTO.getLongitude());
		customerEntity.setSubscriptionStartDate(customerDTO.getSubscriptionStartDate());
		customerEntity.setSubscriptionEndDate(customerDTO.getSubscriptionEndDate());
		customerEntity.setLastSuccessSubscriptionDate(customerDTO.getLastSuccessSubscriptionDate());
		//customerEntity.setAddedOn(customerDTO.getAddedOn());
		customerRepository.save(customerEntity);

		LOGGER.info("Out createCustomer service with return Value customerId:"+customerEntity.getId()); 
		return customerEntity.getId();
	}


	/**
	 * List all customers.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> listAllCustomers() {
		LOGGER.info("In listAllCustomers  Service");
		List<Customer> customer = new ArrayList<>();
		customerRepository.findAll().forEach(customer::add);
		return customer;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateCustomer(CustomerDTO customerDTO) {
		LOGGER.info("In updateCustomer  Service");
		Customer customerEntity = customerRepository.findByCustomerName(customerDTO.getCustomerName());
		customerEntity.setActive(customerDTO.isActive());
		customerEntity.setCustomerName(customerDTO.getCustomerName());
		customerEntity.setGender(customerDTO.getGender());
		customerEntity.setAddress(customerDTO.getAddress());
		customerEntity.setZipcode(customerDTO.getZipcode());
		customerEntity.setMobile(customerDTO.getMobile());
		customerEntity.setAdharNumber(customerDTO.getAdharNumber());
		customerEntity.setPackageType(customerDTO.getPackageType());
		customerEntity.setSubscriptionType(customerDTO.getSubscriptionType());
		customerEntity.setCustomerPic(customerDTO.getCustomerPic());
		customerEntity.setLatitude(customerDTO.getLatitude());
		customerEntity.setLongitude(customerDTO.getLongitude());
		customerEntity.setSubscriptionStartDate(customerDTO.getSubscriptionStartDate());
		customerEntity.setSubscriptionEndDate(customerDTO.getSubscriptionEndDate());
		customerEntity.setLastSuccessSubscriptionDate(customerDTO.getLastSuccessSubscriptionDate());
		//customerEntity.setAddedOn(customerDTO.getAddedOn());
		
		LOGGER.info("Out Customer Updated for "+customerEntity.getId()); 
		return customerEntity.getId();
	}


}
