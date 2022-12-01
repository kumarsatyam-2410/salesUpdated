package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.omc.sales.repository.PlantRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerHistory;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerHistoryRepository;
import com.omc.sales.repository.CustomerRepository;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class CustomerService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerHistoryRepository customerHistoryRepository;

	@Autowired
	private PlantRepository plantRepository;


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
		customerEntity.setCustAcqId(customerDTO.getCustAcqId());
		customerEntity.setPaymentStatus(customerDTO.getPaymentStatus());
		customerEntity.setChannelNo(customerDTO.getChannelNo());
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

		//customerEntity.setPlantId(customerRepository.findAllById(Long.valueOf()).getPlantId());




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
		customerEntity.setUnSubscribe(customerDTO.getUnSubscribe());
		customerEntity.setLastExpiryDate(customerDTO.getLastExpiryDate());
		customerEntity.setChurnDate(customerDTO.getChurnDate());
		customerEntity.setUnsubType(customerDTO.getUnsubType());
		customerEntity.setAadharPicFront(customerDTO.getAadharPicFront());
		customerEntity.setAadharPicBack(customerDTO.getAadharPicBack());
		customerEntity.setKycDocType(customerDTO.getKycDocType());
		customerEntity.setCountry(customerDTO.getCountry());
		customerEntity.setState(customerDTO.getState());
		customerEntity.setDistrict(customerDTO.getDistrict());
		customerEntity.setAge(customerDTO.getAge());
		customerEntity.setOtiCharge(customerDTO.getOtiCharge());

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
		return customerRepository.findAll();
		
		
//		List<Customer> customer = new ArrayList<>();
//		customerRepository.findAll().forEach(customer::add);
//		return customer;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateCustomer(CustomerDTO customerDTO) {
		LOGGER.info("In updateCustomer  Service");
		Customer customerEntity = customerRepository.findAllById(customerDTO.getId());
		CustomerHist(customerEntity);

		customerEntity.setId(customerDTO.getId());
		customerEntity.setActive(customerDTO.isActive());
		customerEntity.setCustAcqId(customerDTO.getCustAcqId());
		customerEntity.setPaymentStatus(customerDTO.getPaymentStatus());
		customerEntity.setChannelNo(customerDTO.getChannelNo());
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
		customerEntity.setUnSubscribe(customerDTO.getUnSubscribe());
		customerEntity.setLastExpiryDate(customerDTO.getLastExpiryDate());
		customerEntity.setChurnDate(customerDTO.getChurnDate());
		customerEntity.setUnsubType(customerDTO.getUnsubType());
		customerEntity.setAadharPicFront(customerDTO.getAadharPicFront());
		customerEntity.setAadharPicBack(customerDTO.getAadharPicBack());
		customerEntity.setKycDocType(customerDTO.getKycDocType());
		customerEntity.setCountry(customerDTO.getCountry());
		customerEntity.setState(customerDTO.getState());
		customerEntity.setDistrict(customerDTO.getDistrict());
		customerEntity.setAge(customerDTO.getAge());
		customerEntity.setOtiCharge(customerDTO.getOtiCharge());

		

		customerRepository.save(customerEntity);
		LOGGER.info("Out Customer Updated for "+customerEntity.getId()); 
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
		//customerHistory.setPlantId(customerEntity.getPlantId());
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
		customerHistory.setUnSubscribe(customerEntity.getUnSubscribe());
		customerHistory.setLastExpiryDate(customerEntity.getLastExpiryDate());
		customerHistory.setUnsubType(customerEntity.getUnsubType());
		customerHistory.setChurnDate(customerEntity.getChurnDate());
		customerHistory.setAadharPicFront(customerEntity.getAadharPicFront());
		customerHistory.setAadharPicBack(customerEntity.getAadharPicBack());
/*		customerHistory.setKycDocType(customerEntity.getKycDocType());
		customerHistory.setOtiCharge(customerEntity.getOtiCharge());
		customerHistory.setAge(customerEntity.getAge());
		customerHistory.setCountry(customerEntity.getCountry());
		customerHistory.setState(customerEntity.getState());
		customerHistory.setDistrict(customerEntity.getDistrict());
		customerHistoryRepository.save(customerHistory);*/

		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> getCustomerById(Long id) {
	
		List<Customer> customer=new ArrayList<>();
		customerRepository.getCustomerById(id).forEach(customer::add);
		return customer;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> getCustomerBySll(String sll) {
		
		return customerRepository.findAllCustomerBySll(sll);
	}



	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteCustomer(Long id) {
		LOGGER.info("In deleteSalesInventory  Service");
		customerRepository.deleteById(id);
		return id;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Customer> getCustomerByDateRangeAndStatus(Timestamp startDate, Timestamp endDate, String customerStatus,
														  Long[] plantId , Long[] salesExecutiveId) {
		System.out.println("anythu"+salesExecutiveId);
		LOGGER.info("in  Customer service get customer data by dateRange,customerStatus,plantId and salesExecutiveId");
		List<Customer> customer = null;
		if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && !StringUtils.isEmpty(customerStatus) && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(salesExecutiveId) ){

			customer = customerRepository.findCustomerByAllFilters(plantId, salesExecutiveId, startDate, endDate,customerStatus);
		}
		else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(salesExecutiveId) ) {

          customer = customerRepository.findCustomerByDateRangeAndAllId(plantId,salesExecutiveId,startDate,endDate);
		}
		else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(plantId)  ) {

			customer =customerRepository.findCustomerByDateRangeAndPlantId(startDate,endDate,plantId);
		}
		else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && StringUtils.isEmpty(customerStatus) && StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(salesExecutiveId) ){

			customer = customerRepository.findCustomerByDateRangeAndId(salesExecutiveId,startDate,endDate);
		}
		else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate)  && !StringUtils.isEmpty(customerStatus)  ) {

			customer = customerRepository.findSubscriptionStartDateBetweenAndAcquisitionStatus(startDate,endDate,customerStatus);
		}
		else if(!StringUtils.isEmpty(salesExecutiveId)&& !StringUtils.isEmpty(plantId)  && !StringUtils.isEmpty(customerStatus)  ) {

			customer = customerRepository.findByIdAndStatus(salesExecutiveId,plantId,customerStatus);
		}
		else if(StringUtils.isEmpty(startDate)&& StringUtils.isEmpty(endDate) && StringUtils.isEmpty(customerStatus) && !StringUtils.isEmpty(plantId) && !StringUtils.isEmpty(salesExecutiveId) ){

			customer = customerRepository.findByPlantIdAndSalesExecutiveId(plantId,salesExecutiveId);
		}
		else if(!StringUtils.isEmpty(customerStatus)&& !StringUtils.isEmpty(plantId)    ) {

			customer = customerRepository.findByCustomerStatusAndPlantId(customerStatus,plantId);
		}
		else if(!StringUtils.isEmpty(customerStatus)&& !StringUtils.isEmpty(salesExecutiveId)    ) {

			customer = customerRepository.findByCustomerStatusAndSalesExecutiveId(customerStatus,salesExecutiveId);
		}
		else if(!StringUtils.isEmpty(startDate)&& !StringUtils.isEmpty(endDate) && StringUtils.isEmpty(customerStatus) && StringUtils.isEmpty(plantId) && StringUtils.isEmpty(salesExecutiveId) ){

			customer = customerRepository.getAllBetweenDates(startDate,endDate);
		}

		else if(!StringUtils.isEmpty(plantId)  ) {

			customer = customerRepository.getCustomerByPlantId(plantId);
		}
		//System.out.println("anythu"+salesExecutiveId);
		else if(!StringUtils.isEmpty(salesExecutiveId)  ) {
			customer = customerRepository.findCustomerBySalesExecutiveId(salesExecutiveId);
		}

		else if(!StringUtils.isEmpty(customerStatus)  ) {

			customer = customerRepository.findCustomerByCustomerStatus(customerStatus);
		}
		else  {
			customer = customerRepository.getAllCustomer();
		}
		return customer;

	}



}




