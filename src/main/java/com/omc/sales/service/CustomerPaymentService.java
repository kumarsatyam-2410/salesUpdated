package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.omc.sales.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.CustomerPaymentDTO;
import com.omc.sales.entity.CustomerPaymentDetails;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerPaymentRepository;
import org.springframework.util.StringUtils;

@Service
public class CustomerPaymentService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerPaymentService.class);

	/** The customer repository. */
	
	@Autowired
	private CustomerPaymentRepository customerPaymentRepository;


	/**
	 * Creates the customer.
	 *
	 * @param customerDTO  the customer DTO
	 * @param callInfo the call info
	 * @return the string
	 * @throws SSNSQLException 
	 * @throws Throwable 
	 */
		
/*	@Transactional(propagation=Propagation.REQUIRED)
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
		customerEntity.setCustomerStatus(customerDTO.getCustomerStatus());
		customerEntity.setSalesExecutiveId(customerDTO.getSalesExecutiveId());
		customerEntity.setPlantId(customerDTO.getPlantId());
		customerRepository.save(customerEntity);

		LOGGER.info("Out createCustomer service with return Value customerId:"+customerEntity.getId()); 
		return customerEntity.getId();
	}

*/
	/**
	 * List all customers.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CustomerPaymentDetails> listAllCustomers() {
		LOGGER.info("In listAllCustomers  Service");
//		List<CustomerPaymentDetails> customerPaymentDetail = new ArrayList<>();
//		customerPaymentRepository.findAllByOrderByIdDesc().forEach(customerPaymentDetail::add);
//		return customerPaymentDetail;
		return customerPaymentRepository.findAllByOrderByCpIdDesc();
	}


	public Long addCustomerPayment(CustomerPaymentDTO customerPaymentDTO) {
		
		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCustomerId(customerPaymentDTO.getCustomerId());
		customerPaymentDetails.setCustomerName(customerPaymentDTO.getCustomerName());
		customerPaymentDetails.setPlantId(customerPaymentDTO.getPlantId());
		customerPaymentDetails.setPaymentMode(customerPaymentDTO.getPaymentMode());
		customerPaymentDetails.setPaymentAmount(customerPaymentDTO.getPaymentAmount());
		customerPaymentDetails.setPaymentCurrency(customerPaymentDTO.getPaymentCurrency());
		customerPaymentDetails.setPaymentDate(customerPaymentDTO.getPaymentDate());
		customerPaymentDetails.setPaymentReceivedUserId(customerPaymentDTO.getPaymentReceivedUserId());
		customerPaymentDetails.setRemark(customerPaymentDTO.getRemark());
		customerPaymentDetails.setCafNo(customerPaymentDTO.getCafNo());
		customerPaymentDetails.setSalesExecId(customerPaymentDTO.getSalesExecId());
		customerPaymentRepository.save(customerPaymentDetails);
		return customerPaymentDetails.getCpId();
		
	}

	public Long updateCustomerPayment(CustomerPaymentDTO customerPaymentDTO) {

		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCpId(customerPaymentDTO.getCpId());
		customerPaymentDetails.setCustomerId(customerPaymentDTO.getCustomerId());
		customerPaymentDetails.setCustomerName(customerPaymentDTO.getCustomerName());
		customerPaymentDetails.setPlantId(customerPaymentDTO.getPlantId());
		customerPaymentDetails.setPaymentMode(customerPaymentDTO.getPaymentMode());
		customerPaymentDetails.setPaymentAmount(customerPaymentDTO.getPaymentAmount());
		customerPaymentDetails.setPaymentCurrency(customerPaymentDTO.getPaymentCurrency());
		customerPaymentDetails.setPaymentDate(customerPaymentDTO.getPaymentDate());
		customerPaymentDetails.setPaymentReceivedUserId(customerPaymentDTO.getPaymentReceivedUserId());
		customerPaymentDetails.setRemark(customerPaymentDTO.getRemark());
		customerPaymentDetails.setCafNo(customerPaymentDTO.getCafNo());
		customerPaymentDetails.setSalesExecId(customerPaymentDTO.getSalesExecId());
		customerPaymentRepository.save(customerPaymentDetails);
		return customerPaymentDetails.getCpId();

	}

/*
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
		customerEntity.setCustomerStatus(customerDTO.getCustomerStatus());
		customerEntity.setSalesExecutiveId(customerDTO.getSalesExecutiveId());
		customerEntity.setPlantId(customerDTO.getPlantId());
		LOGGER.info("Out Customer Updated for "+customerEntity.getId()); 
		return customerEntity.getId();
	}

*/
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
public List<CustomerPaymentDetails> getCustomerPaymentByFilter(Timestamp startDate, Timestamp endDate, String paymentMode,
													  Long[] plantId , Long[] paymentReceivedUserId) {
	System.out.println("anythu"+paymentReceivedUserId);
	LOGGER.info("in  CustomerPayment service get customer payment data by dateRange,paymentMode,plantId and PaymentReceivedUserId");
	List<CustomerPaymentDetails> customer = null;
	if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && !StringUtils.isEmpty(paymentMode) && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(paymentReceivedUserId) ){

		customer = customerPaymentRepository.findCustomerByAllFilters(plantId,paymentReceivedUserId,startDate,endDate,paymentMode);
	}
	else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(paymentReceivedUserId) ) {

		customer = customerPaymentRepository.findCustomerByDateRangeAndAllId(plantId,paymentReceivedUserId,startDate,endDate);
	}
	else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(plantId)  ) {

		customer =customerPaymentRepository.findCustomerByDateRangeAndPlantId(startDate,endDate,plantId);
	}
	else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && StringUtils.isEmpty(paymentMode) && StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(paymentReceivedUserId) ){

		customer = customerPaymentRepository.findCustomerByDateRangeAndId(paymentReceivedUserId,startDate,endDate);
	}
	else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(paymentMode)  ) {

		customer = customerPaymentRepository.findCustomerPaymentDetailByDateAndPaymentMode(startDate,endDate,paymentMode);
	}
	else if(!StringUtils.isEmpty(paymentReceivedUserId)&& !StringUtils.isEmpty(plantId)  && !StringUtils.isEmpty(paymentMode)  ) {

		customer = customerPaymentRepository.findByIdAndMode(paymentReceivedUserId,plantId,paymentMode);
	}
	else if(StringUtils.isEmpty(startDate)&& StringUtils.isEmpty(endDate) && StringUtils.isEmpty(paymentMode) && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(paymentReceivedUserId) ){

		customer = customerPaymentRepository.findByPlantIdAndPaymentRecievedUserId(paymentReceivedUserId,plantId);
	}
	else if(!StringUtils.isEmpty(paymentMode)&& !StringUtils.isEmpty(plantId)    ) {

		customer = customerPaymentRepository.findByPaymentModeAndPlantId(paymentMode,plantId);
	}
	else if(!StringUtils.isEmpty(paymentMode)&& !StringUtils.isEmpty(paymentReceivedUserId)    ) {

		customer = customerPaymentRepository.findByPaymentModeAndId(paymentMode,paymentReceivedUserId);
	}
	else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && StringUtils.isEmpty(paymentMode) && StringUtils.isEmpty(plantId) && StringUtils.isEmpty(paymentReceivedUserId) ){

		customer = customerPaymentRepository.getAllBetweenDates(startDate,endDate);
	}

	else if(!StringUtils.isEmpty(plantId)  ) {

		customer = customerPaymentRepository.getCustomerByPlantId(plantId);
	}
	//System.out.println("anythu"+salesExecutiveId);
	else if(!StringUtils.isEmpty(paymentReceivedUserId)  ) {
		customer = customerPaymentRepository.findCustomerByPaymentReceivedUserId(paymentReceivedUserId);
	}

	else if(!StringUtils.isEmpty(paymentMode)  ) {

		customer = customerPaymentRepository.findCustomerByPaymentMode(paymentMode);
	}
	else  {
		customer = customerPaymentRepository.findAll();
	}
	return customer;

}


}
