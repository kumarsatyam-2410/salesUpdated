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

import com.omc.sales.dto.CustomerAcquisitionDTO;
import com.omc.sales.entity.CustomerAcquisition;
import com.omc.sales.entity.CustomerAcquisitionHistory;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerAcquisitionHistoryRepository;
import com.omc.sales.repository.CustomerAcquisitionRepository;

@Service
public class CustomerAcquisitionService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerAcquisitionService.class);

	/** The customerAcquisition repository. */
	@Autowired
	private CustomerAcquisitionRepository customerAcquisitionRepository;
	
	@Autowired
	private CustomerAcquisitionHistoryRepository customerAcquisitionHistoryRepository;


	/**
	 * Creates the customerAcquisition.
	 *
	 * @param customerAcquisitionDTO  the customerAcquisition DTO
	 * @param callInfo the call info
	 * @return the string
	 * @throws SSNSQLException 
	 * @throws Throwable 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createCustomerAcquisition(CustomerAcquisitionDTO customerAcquisitionDTO) throws SSNSQLException{

		LOGGER.info("Request Received for createCustomerAcquisition with parameters:"+ "customerName: " + customerAcquisitionDTO.getCustomerName());

		 //validate unique customerAcquisition
		CustomerAcquisition existingCustomerAcquisitionEntity = customerAcquisitionRepository.findByCustomerName(customerAcquisitionDTO.getCustomerName());
		if(existingCustomerAcquisitionEntity != null){
			throw new SSNSQLException("Not Unique CustomerAcquisition", ErrorCodes.NOT_UNIQUE_CUSTOMER);
		}
		
		CustomerAcquisition customerAcquisitionEntity = new CustomerAcquisition();
		customerAcquisitionEntity.setActive(customerAcquisitionDTO.isActive());
		customerAcquisitionEntity.setCustomerName(customerAcquisitionDTO.getCustomerName());
		customerAcquisitionEntity.setPlantId(Long.valueOf(customerAcquisitionDTO.getPlantId()));
		customerAcquisitionEntity.setGender(customerAcquisitionDTO.getGender());
		customerAcquisitionEntity.setAddress(customerAcquisitionDTO.getAddress());
		customerAcquisitionEntity.setZipcode(customerAcquisitionDTO.getZipcode());
		customerAcquisitionEntity.setMobile(customerAcquisitionDTO.getMobile());
		customerAcquisitionEntity.setAdharNumber(customerAcquisitionDTO.getAdharNumber());
		customerAcquisitionEntity.setPackageType(customerAcquisitionDTO.getPackageType());
		customerAcquisitionEntity.setSubscriptionType(customerAcquisitionDTO.getSubscriptionType());
		customerAcquisitionEntity.setLatitude(customerAcquisitionDTO.getLatitude());
		customerAcquisitionEntity.setLongitude(customerAcquisitionDTO.getLongitude());
		customerAcquisitionEntity.setSubscriptionStartDate(customerAcquisitionDTO.getSubscriptionStartDate());
		customerAcquisitionEntity.setSubscriptionEndDate(customerAcquisitionDTO.getSubscriptionEndDate());
		customerAcquisitionEntity.setLastSuccessSubscriptionDate(customerAcquisitionDTO.getLastSuccessSubscriptionDate());
		customerAcquisitionEntity.setAcquisitionStatus(customerAcquisitionDTO.getAcquisition_status().toString());
		customerAcquisitionEntity.setUploadCafPath(customerAcquisitionDTO.getUpload_caf_path());
		customerAcquisitionEntity.setUploadInstallationCertificate(customerAcquisitionDTO.getUpload_installation_certificate());
		customerAcquisitionEntity.setNoBoardInstallationRequired(customerAcquisitionDTO.getNo_board_installation_required());
		customerAcquisitionEntity.setNoPollsInstallationRequired(customerAcquisitionDTO.getNo_polls_installation_required());
		customerAcquisitionEntity.setNoRcbsInstallationRequired(customerAcquisitionDTO.getNo_rcbs_installation_required());
		customerAcquisitionEntity.setNoSllInstallationRequired(customerAcquisitionDTO.getNo_sll_installation_required());
		customerAcquisitionEntity.setNoWireInMeterRequired(customerAcquisitionDTO.getNo_wire_in_meter_required());
		//customerAcquisitionEntity.setAddedOn(customerAcquisitionDTO.getAddedOn());
		customerAcquisitionRepository.save(customerAcquisitionEntity);

		LOGGER.info("Out createCustomerAcquisition service with return Value customerAcquisitionId:"+customerAcquisitionEntity.getId()); 
		return customerAcquisitionEntity.getId();
	}


	/**
	 * List all customerAcquisitions.
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CustomerAcquisition> listAllCustomerAcquisitions() {
		LOGGER.info("In listAllCustomerAcquisitions  Service");
		List<CustomerAcquisition> customerAcquisition = new ArrayList<>();
		customerAcquisitionRepository.findAll().forEach(customerAcquisition::add);
		return customerAcquisition;
	}


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateCustomerAcquisition(CustomerAcquisitionDTO customerAcquisitionDTO) {
		
		LOGGER.info("In updateCustomerAcquisition  Service");
		CustomerAcquisition customerAcquisitionEntity = customerAcquisitionRepository.findByCustomerName(customerAcquisitionDTO.getCustomerName());
		
		historiseCustomerAcq(customerAcquisitionEntity);
		
		customerAcquisitionEntity.setActive(customerAcquisitionDTO.isActive());
		customerAcquisitionEntity.setCustomerName(customerAcquisitionDTO.getCustomerName());
		customerAcquisitionEntity.setPlantId(Long.valueOf(customerAcquisitionDTO.getPlantId()));
		customerAcquisitionEntity.setGender(customerAcquisitionDTO.getGender());
		customerAcquisitionEntity.setAddress(customerAcquisitionDTO.getAddress());
		customerAcquisitionEntity.setZipcode(customerAcquisitionDTO.getZipcode());
		customerAcquisitionEntity.setMobile(customerAcquisitionDTO.getMobile());
		customerAcquisitionEntity.setAdharNumber(customerAcquisitionDTO.getAdharNumber());
		customerAcquisitionEntity.setPackageType(customerAcquisitionDTO.getPackageType());
		customerAcquisitionEntity.setSubscriptionType(customerAcquisitionDTO.getSubscriptionType());
		customerAcquisitionEntity.setLatitude(customerAcquisitionDTO.getLatitude());
		customerAcquisitionEntity.setLongitude(customerAcquisitionDTO.getLongitude());
		customerAcquisitionEntity.setSubscriptionStartDate(customerAcquisitionDTO.getSubscriptionStartDate());
		customerAcquisitionEntity.setSubscriptionEndDate(customerAcquisitionDTO.getSubscriptionEndDate());
		customerAcquisitionEntity.setLastSuccessSubscriptionDate(customerAcquisitionDTO.getLastSuccessSubscriptionDate());
		customerAcquisitionEntity.setAcquisitionStatus(customerAcquisitionDTO.getAcquisition_status());
		customerAcquisitionEntity.setUploadCafPath(customerAcquisitionDTO.getUpload_caf_path());
		customerAcquisitionEntity.setUploadInstallationCertificate(customerAcquisitionDTO.getUpload_installation_certificate());
		customerAcquisitionEntity.setNoBoardInstallationRequired(customerAcquisitionDTO.getNo_board_installation_required());
		customerAcquisitionEntity.setNoPollsInstallationRequired(customerAcquisitionDTO.getNo_polls_installation_required());
		customerAcquisitionEntity.setNoRcbsInstallationRequired(customerAcquisitionDTO.getNo_rcbs_installation_required());
		customerAcquisitionEntity.setNoSllInstallationRequired(customerAcquisitionDTO.getNo_sll_installation_required());
		customerAcquisitionEntity.setNoWireInMeterRequired(customerAcquisitionDTO.getNo_wire_in_meter_required());
		
		LOGGER.info("Out CustomerAcquisition Updated for "+customerAcquisitionEntity.getId()); 
		return customerAcquisitionEntity.getId();
	}


	private void historiseCustomerAcq(CustomerAcquisition customerAcquisitionEntity) {
		
		CustomerAcquisitionHistory customerAcquisitionHistory = new CustomerAcquisitionHistory();
		
		customerAcquisitionHistory.setCust_acq_id(customerAcquisitionEntity.getId());
		customerAcquisitionHistory.setActive(customerAcquisitionEntity.isActive());
		customerAcquisitionHistory.setCustomerName(customerAcquisitionEntity.getCustomerName());
		customerAcquisitionHistory.setPlantId(Long.valueOf(customerAcquisitionEntity.getPlantId()));
		customerAcquisitionHistory.setGender(customerAcquisitionEntity.getGender());
		customerAcquisitionHistory.setAddress(customerAcquisitionEntity.getAddress());
		customerAcquisitionHistory.setZipcode(customerAcquisitionEntity.getZipcode());
		customerAcquisitionHistory.setMobile(customerAcquisitionEntity.getMobile());
		customerAcquisitionHistory.setAdharNumber(customerAcquisitionEntity.getAdharNumber());
		customerAcquisitionHistory.setPackageType(customerAcquisitionEntity.getPackageType());
		customerAcquisitionHistory.setSubscriptionType(customerAcquisitionEntity.getSubscriptionType());
		customerAcquisitionHistory.setLatitude(customerAcquisitionEntity.getLatitude());
		customerAcquisitionHistory.setLongitude(customerAcquisitionEntity.getLongitude());
		customerAcquisitionHistory.setSubscriptionStartDate(customerAcquisitionEntity.getSubscriptionStartDate());
		customerAcquisitionHistory.setSubscriptionEndDate(customerAcquisitionEntity.getSubscriptionEndDate());
		customerAcquisitionHistory.setLastSuccessSubscriptionDate(customerAcquisitionEntity.getLastSuccessSubscriptionDate());
		customerAcquisitionHistory.setAcquisition_status(customerAcquisitionEntity.getAcquisitionStatus());
		customerAcquisitionHistory.setUpload_caf_path(customerAcquisitionEntity.getUploadCafPath());
		customerAcquisitionHistory.setUpload_installation_certificate(customerAcquisitionEntity.getUploadInstallationCertificate());
		customerAcquisitionHistory.setNo_board_installation_required(customerAcquisitionEntity.getNoBoardInstallationRequired());
		customerAcquisitionHistory.setNo_polls_installation_required(customerAcquisitionEntity.getNoPollsInstallationRequired());
		customerAcquisitionHistory.setNo_rcbs_installation_required(customerAcquisitionEntity.getNoRcbsInstallationRequired());
		customerAcquisitionHistory.setNo_sll_installation_required(customerAcquisitionEntity.getNoSllInstallationRequired());
		customerAcquisitionHistory.setNo_wire_in_meter_required(customerAcquisitionEntity.getNoWireInMeterRequired());
		
		customerAcquisitionHistory.setHistoryCreatedOn(new Timestamp(new Date().getTime()));
		
		customerAcquisitionHistoryRepository.save(customerAcquisitionHistory);
		
	}


}
