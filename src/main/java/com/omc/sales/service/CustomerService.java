package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerHistory;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerHistoryRepository;
import com.omc.sales.repository.CustomerRepository;

@Service
public class CustomerService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerHistoryRepository customerHistoryRepository;


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
		//  Customer existingCustomerEntity = customerRepository.findByCustomerName(customerDTO.getCustomerName());
//		Customer existingCustomerEntity = customerRepository.findById(customerDTO.getId()).get();
//		if(existingCustomerEntity != null){
//			throw new SSNSQLException("Not Unique Customer", ErrorCodes.NOT_UNIQUE_CUSTOMER);
//		}
		
		Customer customerEntity = new Customer();

		customerEntity.setId(customerDTO.getId());
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
		customerEntity.setAddedOn(customerDTO.getAddedOn());
		customerEntity.setCustomerStatus(customerDTO.getCustomerStatus());
		customerEntity.setSalesExecutiveId(customerDTO.getSalesExecutiveId());
		customerEntity.setPlantId(customerDTO.getPlantId());
		customerEntity.setOmcId(customerDTO.getOmcId());
		customerEntity.setCustomerUid(customerDTO.getCustomerUid());
		customerEntity.setCustomerType(customerDTO.getCustomerType());////////////////////////////////////////
		customerEntity.setSubscriptionPackageAmount(customerDTO.getSubscriptionPackageAmount());
		customerEntity.setSubscription_Package_id(customerDTO.getSubscription_Package_id());
		customerEntity.setType(customerDTO.getType());
		customerEntity.setDate_cancell_hold_unhold(customerDTO.getDate_cancell_hold_unhold());
		customerEntity.setRemarks(customerDTO.getRemarks());
		customerEntity.setSpiCategory(customerDTO.getSpiCategory());
		customerEntity.setDeviceConnected(customerDTO.getDeviceConnected());
		customerEntity.setFatherHusbandName(customerDTO.getFatherHusbandName());
		customerEntity.setPoll_no(customerDTO.getPoll_no());
		customerEntity.setWire_meter(customerDTO.getWire_meter());
		customerEntity.setBigBoard(customerDTO.getBigBoard());
		customerEntity.setSmallBoard(customerDTO.getSmallBoard());
		customerEntity.setLed(customerDTO.getLed());
		customerEntity.setTypeOfEstablishment(customerDTO.getTypeOfEstablishment());
		customerEntity.setLiveDate(customerDTO.getLiveDate());
		customerEntity.setCurrentPackageAmount(customerDTO.getCurrentPackageAmount());
		customerEntity.setCurrentPackageId(customerDTO.getCurrentPackageId());
		customerEntity.setCafNo(customerDTO.getCafNo());
		customerEntity.setBillingType(customerDTO.getBillingType());
		customerEntity.setSll(customerDTO.getSll());
		customerEntity.setNoOfRcb(customerDTO.getNoOfRcb());
		customerEntity.setCreatedBy(customerDTO.getCreatedBy());
		customerEntity.setPaymentBy(customerDTO.getPaymentBy());
		customerEntity.setActivatedBy(customerDTO.getActivatedBy());
		customerEntity.setTypeOfBoard(customerDTO.getTypeOfBoard());
		customerEntity.setInstallationCertificate(customerDTO.getInstallationCertificate());
			customerRepository.save(customerEntity);

		LOGGER.info("Out createCustomer service with return Value customerId:"+customerEntity.getId()); 
		return customerEntity.getId();
	}


	/**
	 * List all customers.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> listAllCustomers()throws SSNSQLException  {
		LOGGER.info("In listAllCustomers  Service");
		List<Customer> customer = new ArrayList<>();
		customerRepository.findAll().forEach(customer::add);
		return customer;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateCustomer(CustomerDTO customerDTO) {
		LOGGER.info("In updateCustomer  Service");
		Customer customerEntity = customerRepository.findAllById(customerDTO.getId());
		
		
		if(customerDTO.getId() != null && customerDTO.getId() >= 0)
		customerEntity.setId(customerDTO.getId());
		
		customerEntity.setActive(customerDTO.isActive());
		if(customerDTO.getCustomerName() != null && customerDTO.getCustomerName().length() > 0 )
		customerEntity.setCustomerName(customerDTO.getCustomerName());
		
		if(customerDTO.getGender() != null && customerDTO.getGender().length() > 0 )
		customerEntity.setGender(customerDTO.getGender());
		
		if(customerDTO.getAddress() != null && customerDTO.getAddress().length() > 0 )
		customerEntity.setAddress(customerDTO.getAddress());
		
		System.out.println("lenght =" + customerDTO.getZipcode().length());
		if(customerDTO.getZipcode() != null && customerDTO.getZipcode().length() > 0 )
		customerEntity.setZipcode(customerDTO.getZipcode());
		
		if(customerDTO.getMobile() != null && customerDTO.getMobile().length() > 0 )
		customerEntity.setMobile(customerDTO.getMobile());
		
		if(customerDTO.getAdharNumber() != null && customerDTO.getAdharNumber().length() > 0 )
		customerEntity.setAdharNumber(customerDTO.getAdharNumber());
		
		if(customerDTO.getPackageType() != null && customerDTO.getPackageType().length() > 0 )
		customerEntity.setPackageType(customerDTO.getPackageType());
		
		if(customerDTO.getSubscriptionType() != null && customerDTO.getSubscriptionType().length() > 0 )
		customerEntity.setSubscriptionType(customerDTO.getSubscriptionType());
		
		if(customerDTO.getCustomerPic() != null && customerDTO.getCustomerPic().length() > 0 )
		customerEntity.setCustomerPic(customerDTO.getCustomerPic());
		
		if(customerDTO.getLatitude() != null && customerDTO.getLatitude().length() > 0 )
		customerEntity.setLatitude(customerDTO.getLatitude());
		
		if(customerDTO.getLongitude() != null && customerDTO.getLongitude().length() > 0 )
		customerEntity.setLongitude(customerDTO.getLongitude());
		
		customerEntity.setSubscriptionStartDate(customerDTO.getSubscriptionStartDate());
		customerEntity.setSubscriptionEndDate(customerDTO.getSubscriptionEndDate());
		customerEntity.setLastSuccessSubscriptionDate(customerDTO.getLastSuccessSubscriptionDate());
		//customerEntity.setAddedOn(customerDTO.getAddedOn());
		
		if(customerDTO.getCustomerStatus() != null && customerDTO.getCustomerStatus().length() > 0 )
		customerEntity.setCustomerStatus(customerDTO.getCustomerStatus());
		
		if(customerDTO.getSalesExecutiveId() != 0 && customerDTO.getSalesExecutiveId() >= 0 )
		customerEntity.setSalesExecutiveId(customerDTO.getSalesExecutiveId());
		
		if(customerDTO.getPlantId() != 0 && customerDTO.getPlantId() >= 0 )
		customerEntity.setPlantId(customerDTO.getPlantId());
		
		if(customerDTO.getOmcId() != null && customerDTO.getOmcId() >= 0 )
		customerEntity.setOmcId(customerDTO.getOmcId());
		
		if(customerDTO.getCustomerUid() != null && customerDTO.getCustomerUid().length() > 0 )
		customerEntity.setCustomerUid(customerDTO.getCustomerUid());
		
		if(customerDTO.getCustomerType() != null && customerDTO.getCustomerType().length() > 0 )
		customerEntity.setCustomerType(customerDTO.getCustomerType()); 
		
		if(customerDTO.getSubscriptionPackageAmount() != null && customerDTO.getSubscriptionPackageAmount() != null )
		customerEntity.setSubscriptionPackageAmount(customerDTO.getSubscriptionPackageAmount());
		
		if(customerDTO.getSubscription_Package_id() != null && customerDTO.getSubscription_Package_id() >= 0 )
		customerEntity.setSubscription_Package_id(customerDTO.getSubscription_Package_id());
		
		if(customerDTO.getType() != null && customerDTO.getType().length() > 0 )
		customerEntity.setType(customerDTO.getType());
		
		customerEntity.setDate_cancell_hold_unhold(customerDTO.getDate_cancell_hold_unhold());
		
		if(customerDTO.getRemarks() != null && customerDTO.getRemarks().length() > 0 )
		customerEntity.setRemarks(customerDTO.getRemarks());
		
		if(customerDTO.getSpiCategory() != null && customerDTO.getSpiCategory().length() > 0 )
		customerEntity.setSpiCategory(customerDTO.getSpiCategory());
		
		if(customerDTO.getDeviceConnected() != null && customerDTO.getDeviceConnected().length() > 0 )
		customerEntity.setDeviceConnected(customerDTO.getDeviceConnected());
		
		if(customerDTO.getFatherHusbandName() != null && customerDTO.getFatherHusbandName().length() > 0 )
		customerEntity.setFatherHusbandName(customerDTO.getFatherHusbandName());
		
		if(customerDTO.getPoll_no() != null && customerDTO.getPoll_no() >= 0 )
		customerEntity.setPoll_no(customerDTO.getPoll_no());
		
		if(customerDTO.getWire_meter() != null && customerDTO.getWire_meter() != null )
		customerEntity.setWire_meter(customerDTO.getWire_meter());
		
		if(customerDTO.getBigBoard() != null && customerDTO.getBigBoard().length() > 0 )
		customerEntity.setBigBoard(customerDTO.getBigBoard());
		
		if(customerDTO.getSmallBoard() != null && customerDTO.getSmallBoard().length() > 0 )
		customerEntity.setSmallBoard(customerDTO.getSmallBoard());
		
		if(customerDTO.getLed() != null && customerDTO.getLed().length() > 0 )
		customerEntity.setLed(customerDTO.getLed());
		
		if(customerDTO.getTypeOfEstablishment() != null && customerDTO.getTypeOfEstablishment().length() > 0 )
		customerEntity.setTypeOfEstablishment(customerDTO.getTypeOfEstablishment());
		
		customerEntity.setLiveDate(customerDTO.getLiveDate());
		
		if(customerDTO.getCurrentPackageAmount() != null && customerDTO.getCurrentPackageAmount() != null )
		customerEntity.setCurrentPackageAmount(customerDTO.getCurrentPackageAmount());
		
		if(customerDTO.getCurrentPackageId() != null && customerDTO.getCurrentPackageId() >= 0 )
		customerEntity.setCurrentPackageId(customerDTO.getCurrentPackageId());
		
		if(customerDTO.getCafNo() != null && customerDTO.getCafNo().length() > 0 )
		customerEntity.setCafNo(customerDTO.getCafNo());
		
		if(customerDTO.getBillingType() != null && customerDTO.getBillingType().length() > 0 )
		customerEntity.setBillingType(customerDTO.getBillingType());
		
		if(customerDTO.getSll() != null && customerDTO.getSll() .length() > 0 )
		customerEntity.setSll(customerDTO.getSll());
		
		if(customerDTO.getNoOfRcb() != null && customerDTO.getNoOfRcb() >= 0 )
		customerEntity.setNoOfRcb(customerDTO.getNoOfRcb());
		
		if(customerDTO.getCreatedBy() != 0 && customerDTO.getCreatedBy() > 0 )
		customerEntity.setCreatedBy(customerDTO.getCreatedBy());
		
    	if(customerDTO.getPaymentBy() != 0 && customerDTO.getPaymentBy() >= 0 )
		customerEntity.setPaymentBy(customerDTO.getPaymentBy());
    	
		if(customerDTO.getActivatedBy() != 0 && customerDTO.getActivatedBy() >= 0 )
		customerEntity.setActivatedBy(customerDTO.getActivatedBy());
		
		if(customerDTO.getTypeOfBoard() != null && customerDTO.getTypeOfBoard() .length() > 0 )
		customerEntity.setTypeOfBoard(customerDTO.getTypeOfBoard());
		
		if(customerDTO.getInstallationCertificate() != null && customerDTO.getInstallationCertificate() .length() > 0 )
		customerEntity.setInstallationCertificate(customerDTO.getInstallationCertificate());
		
		LOGGER.info("Out Customer Updated for "+customerEntity.getId()); 
		CustomerHist(customerEntity);
		return customerEntity.getId();
		
	}


	private void CustomerHist(Customer customerEntity) {
		
		CustomerHistory customerHistory=new CustomerHistory();
		
		Timestamp current_ts = new Timestamp(new Date().getTime());
		customerHistory.setCustomerHistoryDate(current_ts);
		customerHistory.setId(customerEntity.getId());
		customerHistory.setCustomerName(customerEntity.getCustomerName());
		customerHistory.setGender(customerEntity.getGender());
		customerHistory.setAddress(customerEntity.getAddress());
		customerHistory.setZipcode(customerEntity.getZipcode());
		customerHistory.setMobile(customerEntity.getMobile());
		customerHistory.setAdharNumber(customerEntity.getAdharNumber());
		customerHistory.setPackageType(customerEntity.getPackageType());
		customerHistory.setSubscriptionType(customerEntity.getSubscriptionType());
		customerHistory.setCustomerPic(customerEntity.getCustomerPic());
		customerHistory.setLatitude(customerEntity.getLatitude());
		customerHistory.setLongitude(customerEntity.getLongitude());
		customerHistory.setSubscriptionStartDate(customerEntity.getSubscriptionStartDate());
		customerHistory.setSubscriptionEndDate(customerEntity.getSubscriptionEndDate());
		customerHistory.setLastSuccessSubscriptionDate(customerEntity.getLastSuccessSubscriptionDate());
		customerHistory.setActive(true);
		customerHistory.setCustomerStatus(customerEntity.getCustomerStatus());
		customerHistory.setSalesExecutiveId(customerEntity.getSalesExecutiveId());
		customerHistory.setCustAcqId(customerEntity.getCustAcqId());
		customerHistory.setPlantId(customerEntity.getPlantId());
		customerHistory.setOmcId(customerEntity.getOmcId());
		customerHistory.setLed(customerEntity.getLed());
		customerHistory.setLiveDate(customerEntity.getLiveDate());
		customerHistory.setSubscriptionPackageAmount(customerEntity.getSubscriptionPackageAmount());
		customerHistory.setSubscription_Package_id(customerEntity.getSubscription_Package_id());
		customerHistory.setBigBoard(customerEntity.getBigBoard());
		customerHistory.setSmallBoard(customerEntity.getSmallBoard());
		customerHistory.setTypeOfEstablishment(customerEntity.getTypeOfEstablishment());
		customerHistory.setPoll_no(customerEntity.getPoll_no());
		customerHistory.setWire_meter(customerEntity.getWire_meter());
		customerHistory.setFatherHusbandName(customerEntity.getFatherHusbandName());
		customerHistory.setDeviceConnected(customerEntity.getDeviceConnected());
		customerHistory.setSpiCategory(customerEntity.getSpiCategory());
		customerHistory.setRemarks(customerEntity.getRemarks());
		customerHistory.setDate_cancell_hold_unhold(customerEntity.getDate_cancell_hold_unhold());
		customerHistory.setType(customerEntity.getType());
		customerHistory.setCustomerType(customerEntity.getCustomerType());     ////////////////
		customerHistory.setCustomerUid(customerEntity.getCustomerUid());
		customerHistory.setCurrentPackageId(customerEntity.getCurrentPackageId());
		customerHistory.setCurrentPackageAmount(customerEntity.getCurrentPackageAmount());
		customerHistory.setCafNo(customerEntity.getCafNo());
		customerHistory.setSll(customerEntity.getSll());
		customerHistory.setNoOfRcb(customerHistory.getNoOfRcb());
		customerHistory.setBillingType(customerEntity.getBillingType());
		customerHistory.setCreatedBy(customerEntity.getCreatedBy());
		customerHistory.setPaymentBy(customerHistory.getPaymentBy());
		customerHistory.setActivatedBy(customerEntity.getActivatedBy());
		customerHistory.setTypeOfBoard(customerEntity.getTypeOfBoard());
		customerHistory.setInstallationCertificate(customerEntity.getInstallationCertificate());
		customerHistoryRepository.save(customerHistory);

		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> getCustomerById(Long id) {
	
		List<Customer> customer=new ArrayList<>();
		customerRepository.getCustomerById(id).forEach(customer::add);
		return customer;
	}


	public List<Customer> getCustomerBySll(String sll) {
		
		return customerRepository.findAllCustomerBySll(sll);
	}


}
