package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		CustomerAcquisition existingCustomerAcquisitionEntity =customerAcquisitionRepository.findByCustomerName(customerAcquisitionDTO.getCustomerName());
		if(existingCustomerAcquisitionEntity != null){
			throw new SSNSQLException("Not Unique CustomerAcquisition", ErrorCodes.NOT_UNIQUE_CUSTOMER);
		}
		
		CustomerAcquisition customerAcquisitionEntity = new CustomerAcquisition();
		
		customerAcquisitionEntity.setAbhApprovalStatus(customerAcquisitionDTO.getAbhApprovalStatus());
		customerAcquisitionEntity.setSalesheadApprovalStatus(customerAcquisitionDTO.getSalesheadApprovalStatus());
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
		customerAcquisitionEntity.setCustomerUserId(customerAcquisitionEntity.getCustomerUserId());
		customerAcquisitionEntity.setRechargeNo(customerAcquisitionDTO.getRechargeNo());
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		customerAcquisitionEntity.setPackageId(customerAcquisitionEntity.getPackageId());
		customerAcquisitionEntity.setAmount(customerAcquisitionDTO.getAmount());
		customerAcquisitionEntity.setPaymentDate(customerAcquisitionDTO.getPaymentDate());
		customerAcquisitionEntity.setPaymentStatus(customerAcquisitionDTO.getPaymentStatus());
		customerAcquisitionEntity.setPaymentMode(customerAcquisitionDTO.getPaymentMode());
		customerAcquisitionEntity.setPaymentCurrency(customerAcquisitionDTO.getPaymentCurrency());
		customerAcquisitionEntity.setFathersName(customerAcquisitionDTO.getFathersName());
		customerAcquisitionEntity.setHusbandName(customerAcquisitionDTO.getHusbandName());
		customerAcquisitionEntity.setConAddress(customerAcquisitionDTO.getConAddress());
		customerAcquisitionEntity.setConVillage(customerAcquisitionDTO.getConVillage());
		customerAcquisitionEntity.setConTehsil(customerAcquisitionDTO.getConTehsil());
		customerAcquisitionEntity.setConPostoffice(customerAcquisitionDTO.getConPostoffice());
		customerAcquisitionEntity.setConPincode(customerAcquisitionDTO.getConPincode());
		customerAcquisitionEntity.setPermanentAddress(customerAcquisitionDTO.getPermanentAddress());
		customerAcquisitionEntity.setPermanentVillage(customerAcquisitionDTO.getPermanentVillage());
		customerAcquisitionEntity.setPermanentTehsil(customerAcquisitionDTO.getPermanentTehsil());
		customerAcquisitionEntity.setPermanentPostoffice(customerAcquisitionDTO.getPermanentPostoffice());
		customerAcquisitionEntity.setPermanentPincode(customerAcquisitionDTO.getPermanentPincode());
		customerAcquisitionEntity.setIdProofType(customerAcquisitionDTO.getIdProofType());
		customerAcquisitionEntity.setIdProfDocNo(customerAcquisitionDTO.getIdProfDocNo());
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		customerAcquisitionEntity.setAddressProofDocNo(customerAcquisitionDTO.getAddressProofDocNo());
		customerAcquisitionEntity.setNatureOfSupply(customerAcquisitionDTO.getNatureOfSupply());
		customerAcquisitionEntity.setOmcId(customerAcquisitionDTO.getOmcId());
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		customerAcquisitionEntity.setSubscriptionPackageId(customerAcquisitionDTO.getSubscriptionPackageId());
		customerAcquisitionEntity.setSubscriptionPackageAmount(customerAcquisitionDTO.getSubscriptionPackageAmount());
		customerAcquisitionEntity.setSpiCategory(customerAcquisitionDTO.getSpiCategory());
		customerAcquisitionEntity.setDeviceConnected(customerAcquisitionDTO.getDeviceConnected());
		customerAcquisitionEntity.setPollNo(customerAcquisitionDTO.getPollNo());
		customerAcquisitionEntity.setBigBoard(customerAcquisitionDTO.getBigBoard());
		customerAcquisitionEntity.setSmallBoard(customerAcquisitionDTO.getSmallBoard());
		customerAcquisitionEntity.setLed(customerAcquisitionDTO.getLed());
		customerAcquisitionEntity.setTypeOfEstablishment(customerAcquisitionDTO.getTypeOfEstablishment());
		customerAcquisitionEntity.setProfessionOccupation(customerAcquisitionDTO.getProfessionOccupation());
		customerAcquisitionEntity.setConnectionAddressDistrict(customerAcquisitionDTO.getConnectionAddressDistrict());
		customerAcquisitionEntity.setPermanentAddressDistrict(customerAcquisitionDTO.getPermanentAddressDistrict());
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		customerAcquisitionEntity.setPermanentAddressDocNo(customerAcquisitionDTO.getPermanentAddressDocNo());
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
		
		customerAcquisitionEntity.setAbhApprovalStatus(customerAcquisitionDTO.getAbhApprovalStatus());
		customerAcquisitionEntity.setSalesheadApprovalStatus(customerAcquisitionDTO.getSalesheadApprovalStatus());
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
		
		
		
		customerAcquisitionEntity.setCustomerUserId(customerAcquisitionEntity.getCustomerUserId());
		customerAcquisitionEntity.setRechargeNo(customerAcquisitionDTO.getRechargeNo());
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		customerAcquisitionEntity.setPackageId(customerAcquisitionEntity.getPackageId());
		customerAcquisitionEntity.setAmount(customerAcquisitionDTO.getAmount());
		customerAcquisitionEntity.setPaymentDate(customerAcquisitionDTO.getPaymentDate());
		customerAcquisitionEntity.setPaymentStatus(customerAcquisitionDTO.getPaymentStatus());
		customerAcquisitionEntity.setPaymentMode(customerAcquisitionDTO.getPaymentMode());
		customerAcquisitionEntity.setPaymentCurrency(customerAcquisitionDTO.getPaymentCurrency());
		customerAcquisitionEntity.setFathersName(customerAcquisitionDTO.getFathersName());
		customerAcquisitionEntity.setHusbandName(customerAcquisitionDTO.getHusbandName());
		customerAcquisitionEntity.setConAddress(customerAcquisitionDTO.getConAddress());
		customerAcquisitionEntity.setConVillage(customerAcquisitionDTO.getConVillage());
		customerAcquisitionEntity.setConTehsil(customerAcquisitionDTO.getConTehsil());
		customerAcquisitionEntity.setConPostoffice(customerAcquisitionDTO.getConPostoffice());
		customerAcquisitionEntity.setConPincode(customerAcquisitionDTO.getConPincode());
		customerAcquisitionEntity.setPermanentAddress(customerAcquisitionDTO.getPermanentAddress());
		customerAcquisitionEntity.setPermanentVillage(customerAcquisitionDTO.getPermanentVillage());
		customerAcquisitionEntity.setPermanentTehsil(customerAcquisitionDTO.getPermanentTehsil());
		customerAcquisitionEntity.setPermanentPostoffice(customerAcquisitionDTO.getPermanentPostoffice());
		customerAcquisitionEntity.setPermanentPincode(customerAcquisitionDTO.getPermanentPincode());
		customerAcquisitionEntity.setIdProofType(customerAcquisitionDTO.getIdProofType());
		customerAcquisitionEntity.setIdProfDocNo(customerAcquisitionDTO.getIdProfDocNo());
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		customerAcquisitionEntity.setAddressProofDocNo(customerAcquisitionDTO.getAddressProofDocNo());
		customerAcquisitionEntity.setNatureOfSupply(customerAcquisitionDTO.getNatureOfSupply());
		
		customerAcquisitionEntity.setOmcId(customerAcquisitionDTO.getOmcId());
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		customerAcquisitionEntity.setSubscriptionPackageId(customerAcquisitionDTO.getSubscriptionPackageId());
		customerAcquisitionEntity.setSubscriptionPackageAmount(customerAcquisitionDTO.getSubscriptionPackageAmount());
		customerAcquisitionEntity.setSpiCategory(customerAcquisitionDTO.getSpiCategory());
		customerAcquisitionEntity.setDeviceConnected(customerAcquisitionDTO.getDeviceConnected());
		customerAcquisitionEntity.setPollNo(customerAcquisitionDTO.getPollNo());
		customerAcquisitionEntity.setBigBoard(customerAcquisitionDTO.getBigBoard());
		customerAcquisitionEntity.setSmallBoard(customerAcquisitionDTO.getSmallBoard());
		customerAcquisitionEntity.setLed(customerAcquisitionDTO.getLed());
		customerAcquisitionEntity.setTypeOfEstablishment(customerAcquisitionDTO.getTypeOfEstablishment());
		customerAcquisitionEntity.setProfessionOccupation(customerAcquisitionDTO.getProfessionOccupation());
		customerAcquisitionEntity.setConnectionAddressDistrict(customerAcquisitionDTO.getConnectionAddressDistrict());
		customerAcquisitionEntity.setPermanentAddressDistrict(customerAcquisitionDTO.getPermanentAddressDistrict());
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		
		
		LOGGER.info("Out CustomerAcquisition Updated for "+customerAcquisitionEntity.getId()); 
		return customerAcquisitionEntity.getId();
	}


	private void historiseCustomerAcq(CustomerAcquisition customerAcquisitionEntity) {
		
		CustomerAcquisitionHistory customerAcquisitionHistory = new CustomerAcquisitionHistory();
		
		customerAcquisitionHistory.setCust_acq_id(customerAcquisitionEntity.getId());
		customerAcquisitionHistory.setActive(customerAcquisitionEntity.isActive());
		
		customerAcquisitionHistory.setAbhApprovalStatus(customerAcquisitionEntity.getAbhApprovalStatus());
		customerAcquisitionHistory.setSalesheadApprovalStatus(customerAcquisitionEntity.getSalesheadApprovalStatus());
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
		
		customerAcquisitionHistory.setOmcId(customerAcquisitionEntity.getOmcId());
		customerAcquisitionHistory.setSubscriptionPackageId(customerAcquisitionEntity.getSubscriptionPackageId());
		customerAcquisitionHistory.setSubscriptionPackageAmount(customerAcquisitionEntity.getSubscriptionPackageAmount());
		customerAcquisitionHistory.setSpiCategory(customerAcquisitionEntity.getSpiCategory());
		customerAcquisitionHistory.setDeviceConnected(customerAcquisitionEntity.getDeviceConnected());
		customerAcquisitionHistory.setPollNo(customerAcquisitionEntity.getPollNo());
		customerAcquisitionHistory.setBigBoard(customerAcquisitionEntity.getBigBoard());
		customerAcquisitionHistory.setSmallBoard(customerAcquisitionEntity.getSmallBoard());
		customerAcquisitionHistory.setLed(customerAcquisitionEntity.getLed());
		customerAcquisitionHistory.setTypeOfEstablishment(customerAcquisitionEntity.getTypeOfEstablishment());
		customerAcquisitionHistory.setProfessionOccupation(customerAcquisitionEntity.getProfessionOccupation());
		customerAcquisitionHistory.setConnectionAddressDistrict(customerAcquisitionEntity.getConnectionAddressDistrict());
		customerAcquisitionHistory.setPermanentAddressDistrict(customerAcquisitionEntity.getPermanentAddressDistrict());
		customerAcquisitionHistory.setPermanentAddressProofType(customerAcquisitionEntity.getPermanentAddressProofType());
		customerAcquisitionHistory.setPermanentAddressDocNo(customerAcquisitionEntity.getPermanentAddressDocNo());
		
		customerAcquisitionHistory.setHistoryCreatedOn(new Timestamp(new Date().getTime()));
		
		customerAcquisitionHistoryRepository.save(customerAcquisitionHistory);
		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CustomerAcquisition> CustomerAcquisitionById(Long id) {
		
		List<CustomerAcquisition> customerAcquisition= new ArrayList<>();
		customerAcquisitionRepository.getAllCustomerAcquisitionByid(id).forEach(customerAcquisition::add);
		return customerAcquisition;
	}


	
}
