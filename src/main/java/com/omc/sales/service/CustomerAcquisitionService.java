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
		customerAcquisitionEntity.setCafNo(customerAcquisitionDTO.getCafNo());
		customerAcquisitionEntity.setBillingType(customerAcquisitionDTO.getBillingType());
		customerAcquisitionEntity.setSalesExecutiveId(customerAcquisitionDTO.getSalesExecutiveId());
		customerAcquisitionEntity.setCreatedBy(customerAcquisitionDTO.getCreatedBy());
		//customerAcquisitionEntity.setAddedOn(customerAcquisitionDTO.getAddedOn());
		customerAcquisitionEntity.setPaymentBy(customerAcquisitionDTO.getPaymentBy());
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
		CustomerAcquisition customerAcquisitionEntity = customerAcquisitionRepository.findAllById(customerAcquisitionDTO.getId());
		
		// historiseCustomerAcq(customerAcquisitionEntity);
		
		customerAcquisitionEntity.setActive(customerAcquisitionDTO.isActive());
		
		if(customerAcquisitionDTO.getAbhApprovalStatus() != null && customerAcquisitionDTO.getAbhApprovalStatus().length() > 0 )
		customerAcquisitionEntity.setAbhApprovalStatus(customerAcquisitionDTO.getAbhApprovalStatus());
		
		if(customerAcquisitionDTO.getSalesheadApprovalStatus() != null && customerAcquisitionDTO.getSalesheadApprovalStatus().length() > 0 )
		customerAcquisitionEntity.setSalesheadApprovalStatus(customerAcquisitionDTO.getSalesheadApprovalStatus());
		
		if(customerAcquisitionDTO.getCustomerName() != null && customerAcquisitionDTO.getCustomerName().length() > 0 )
		customerAcquisitionEntity.setCustomerName(customerAcquisitionDTO.getCustomerName());
		
		if(customerAcquisitionDTO.getPlantId() != null && customerAcquisitionDTO.getPlantId().length() > 0 )
		customerAcquisitionEntity.setPlantId(Long.valueOf(customerAcquisitionDTO.getPlantId()));
		
		if(customerAcquisitionDTO.getGender() != null && customerAcquisitionDTO.getGender().length() > 0 )
		customerAcquisitionEntity.setGender(customerAcquisitionDTO.getGender());
		
		if(customerAcquisitionDTO.getAddress() != null && customerAcquisitionDTO.getAddress().length() > 0 )
		customerAcquisitionEntity.setAddress(customerAcquisitionDTO.getAddress());
		
		if(customerAcquisitionDTO.getZipcode() != null && customerAcquisitionDTO.getZipcode().length() > 0 )
		customerAcquisitionEntity.setZipcode(customerAcquisitionDTO.getZipcode());
		
		if(customerAcquisitionDTO.getMobile() != null && customerAcquisitionDTO.getMobile().length() > 0 )
		customerAcquisitionEntity.setMobile(customerAcquisitionDTO.getMobile());
		
		if(customerAcquisitionDTO.getAdharNumber() != null && customerAcquisitionDTO.getAdharNumber().length() > 0 )
		customerAcquisitionEntity.setAdharNumber(customerAcquisitionDTO.getAdharNumber());
		
		if(customerAcquisitionDTO.getPackageType() != null && customerAcquisitionDTO.getPackageType().length() > 0 )
		customerAcquisitionEntity.setPackageType(customerAcquisitionDTO.getPackageType());
		
		if(customerAcquisitionDTO.getSubscriptionType() != null && customerAcquisitionDTO.getSubscriptionType().length() > 0 )
		customerAcquisitionEntity.setSubscriptionType(customerAcquisitionDTO.getSubscriptionType());
		
		if(customerAcquisitionDTO.getLatitude() != null && customerAcquisitionDTO.getLatitude().length() > 0 )
		customerAcquisitionEntity.setLatitude(customerAcquisitionDTO.getLatitude());
		
		if(customerAcquisitionDTO.getLongitude() != null && customerAcquisitionDTO.getLongitude().length() > 0 )
		customerAcquisitionEntity.setLongitude(customerAcquisitionDTO.getLongitude());
		
		customerAcquisitionEntity.setSubscriptionStartDate(customerAcquisitionDTO.getSubscriptionStartDate());
		customerAcquisitionEntity.setSubscriptionEndDate(customerAcquisitionDTO.getSubscriptionEndDate());
		customerAcquisitionEntity.setLastSuccessSubscriptionDate(customerAcquisitionDTO.getLastSuccessSubscriptionDate());
		
		if(customerAcquisitionDTO.getAcquisition_status() != null && customerAcquisitionDTO.getAcquisition_status().length() > 0 )
		customerAcquisitionEntity.setAcquisitionStatus(customerAcquisitionDTO.getAcquisition_status());
		
		if(customerAcquisitionDTO.getUpload_caf_path() != null && customerAcquisitionDTO.getUpload_caf_path().length() > 0 )
		customerAcquisitionEntity.setUploadCafPath(customerAcquisitionDTO.getUpload_caf_path());
		
		if(customerAcquisitionDTO.getUpload_installation_certificate() != null && customerAcquisitionDTO.getUpload_installation_certificate().length() > 0 )
		customerAcquisitionEntity.setUploadInstallationCertificate(customerAcquisitionDTO.getUpload_installation_certificate());
		
		if(customerAcquisitionDTO.getNo_board_installation_required() != 0 && customerAcquisitionDTO.getNo_board_installation_required() >= 0)
		customerAcquisitionEntity.setNoBoardInstallationRequired(customerAcquisitionDTO.getNo_board_installation_required());
		if(customerAcquisitionDTO.getNo_polls_installation_required() != 0 && customerAcquisitionDTO.getNo_polls_installation_required() >= 0)
		customerAcquisitionEntity.setNoPollsInstallationRequired(customerAcquisitionDTO.getNo_polls_installation_required());
		if(customerAcquisitionDTO.getNo_rcbs_installation_required() != 0 && customerAcquisitionDTO.getNo_rcbs_installation_required() >= 0)
		customerAcquisitionEntity.setNoRcbsInstallationRequired(customerAcquisitionDTO.getNo_rcbs_installation_required());
		if(customerAcquisitionDTO.getNo_sll_installation_required() != 0 && customerAcquisitionDTO.getNo_sll_installation_required() >= 0)
		customerAcquisitionEntity.setNoSllInstallationRequired(customerAcquisitionDTO.getNo_sll_installation_required());
		if(customerAcquisitionDTO.getNo_wire_in_meter_required() != 0 && customerAcquisitionDTO.getNo_wire_in_meter_required() >= 0)
		customerAcquisitionEntity.setNoWireInMeterRequired(customerAcquisitionDTO.getNo_wire_in_meter_required());
		
		if(customerAcquisitionDTO.getCustomerUserId() != null && customerAcquisitionDTO.getCustomerUserId().length() > 0 )
		customerAcquisitionEntity.setCustomerUserId(customerAcquisitionDTO.getCustomerUserId());
		
		if(customerAcquisitionDTO.getRechargeNo() != null && customerAcquisitionDTO.getRechargeNo().length() > 0 )
		customerAcquisitionEntity.setRechargeNo(customerAcquisitionDTO.getRechargeNo());
		
		if(customerAcquisitionDTO.getCustomerType() != null && customerAcquisitionDTO.getCustomerType().length() > 0 )
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		
		if(customerAcquisitionDTO.getPackageId() != 0 && customerAcquisitionDTO.getPackageId() >= 0)
		customerAcquisitionEntity.setPackageId(customerAcquisitionDTO.getPackageId());
		
		if(customerAcquisitionDTO.getAmount() != null && customerAcquisitionDTO.getAmount() != null )
		customerAcquisitionEntity.setAmount(customerAcquisitionDTO.getAmount());
		
		customerAcquisitionEntity.setPaymentDate(customerAcquisitionDTO.getPaymentDate());
		
		if(customerAcquisitionDTO.getPaymentStatus() != null && customerAcquisitionDTO.getPaymentStatus().length() > 0 )
		customerAcquisitionEntity.setPaymentStatus(customerAcquisitionDTO.getPaymentStatus());
		
		if(customerAcquisitionDTO.getPaymentMode() != null && customerAcquisitionDTO.getPaymentMode().length() > 0 )
		customerAcquisitionEntity.setPaymentMode(customerAcquisitionDTO.getPaymentMode());
		
		if(customerAcquisitionDTO.getPaymentCurrency() != null && customerAcquisitionDTO.getPaymentCurrency().length() > 0 )
		customerAcquisitionEntity.setPaymentCurrency(customerAcquisitionDTO.getPaymentCurrency());
		
		if(customerAcquisitionDTO.getFathersName() != null && customerAcquisitionDTO.getFathersName().length() > 0 )
		customerAcquisitionEntity.setFathersName(customerAcquisitionDTO.getFathersName());
		
		if(customerAcquisitionDTO.getHusbandName() != null && customerAcquisitionDTO.getHusbandName().length() > 0 )
		customerAcquisitionEntity.setHusbandName(customerAcquisitionDTO.getHusbandName());
		
		if(customerAcquisitionDTO.getConAddress() != null && customerAcquisitionDTO.getConAddress().length() > 0 )
		customerAcquisitionEntity.setConAddress(customerAcquisitionDTO.getConAddress());
		
		if(customerAcquisitionDTO.getConVillage() != null && customerAcquisitionDTO.getConVillage().length() > 0 )
		customerAcquisitionEntity.setConVillage(customerAcquisitionDTO.getConVillage());
		
		if(customerAcquisitionDTO.getConTehsil() != null && customerAcquisitionDTO.getConTehsil().length() > 0 )
		customerAcquisitionEntity.setConTehsil(customerAcquisitionDTO.getConTehsil());
		
		if(customerAcquisitionDTO.getConPostoffice() != null && customerAcquisitionDTO.getConPostoffice().length() > 0 )
		customerAcquisitionEntity.setConPostoffice(customerAcquisitionDTO.getConPostoffice());
		
		if(customerAcquisitionDTO.getConPincode() != null && customerAcquisitionDTO.getConPincode().length() > 0 )
		customerAcquisitionEntity.setConPincode(customerAcquisitionDTO.getConPincode());
		
		if(customerAcquisitionDTO.getPermanentAddress() != null && customerAcquisitionDTO.getPermanentAddress().length() > 0 )
		customerAcquisitionEntity.setPermanentAddress(customerAcquisitionDTO.getPermanentAddress());
		
		if(customerAcquisitionDTO.getPermanentVillage() != null && customerAcquisitionDTO.getPermanentVillage().length() > 0 )
		customerAcquisitionEntity.setPermanentVillage(customerAcquisitionDTO.getPermanentVillage());
		
		if(customerAcquisitionDTO.getPermanentPostoffice() != null && customerAcquisitionDTO.getPermanentPostoffice().length() > 0 )
		customerAcquisitionEntity.setPermanentPostoffice(customerAcquisitionDTO.getPermanentPostoffice());
		
		if(customerAcquisitionDTO.getPermanentPincode() != null && customerAcquisitionDTO.getPermanentPincode().length() > 0 )
		customerAcquisitionEntity.setPermanentPincode(customerAcquisitionDTO.getPermanentPincode());

		if(customerAcquisitionDTO.getIdProofType() != null && customerAcquisitionDTO.getIdProofType().length() > 0 )
		customerAcquisitionEntity.setIdProofType(customerAcquisitionDTO.getIdProofType());
		
		if(customerAcquisitionDTO.getIdProfDocNo() != null && customerAcquisitionDTO.getIdProfDocNo().length() > 0 )
		customerAcquisitionEntity.setIdProfDocNo(customerAcquisitionDTO.getIdProfDocNo());
		
		if(customerAcquisitionDTO.getAddressProofType() != null && customerAcquisitionDTO.getAddressProofType().length() > 0 )
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		
		if(customerAcquisitionDTO.getAddressProofDocNo() != null && customerAcquisitionDTO.getAddressProofDocNo().length() > 0 )
		customerAcquisitionEntity.setAddressProofDocNo(customerAcquisitionDTO.getAddressProofDocNo());
		
		if(customerAcquisitionDTO.getNatureOfSupply() != null && customerAcquisitionDTO.getNatureOfSupply().length() > 0 )
		customerAcquisitionEntity.setNatureOfSupply(customerAcquisitionDTO.getNatureOfSupply());
		
		if(customerAcquisitionDTO.getOmcId() != null && customerAcquisitionDTO.getOmcId() != null )
		customerAcquisitionEntity.setOmcId(customerAcquisitionDTO.getOmcId());
		
		if(customerAcquisitionDTO.getCustomerType() != null && customerAcquisitionDTO.getCustomerType().length() > 0 )
		customerAcquisitionEntity.setCustomerType(customerAcquisitionDTO.getCustomerType());
		
		if(customerAcquisitionDTO.getSubscriptionPackageId() != null && customerAcquisitionDTO.getSubscriptionPackageId() != null )
		customerAcquisitionEntity.setSubscriptionPackageId(customerAcquisitionDTO.getSubscriptionPackageId());
		
		if(customerAcquisitionDTO.getSubscriptionPackageAmount() != null && customerAcquisitionDTO.getSubscriptionPackageAmount() != null )
		customerAcquisitionEntity.setSubscriptionPackageAmount(customerAcquisitionDTO.getSubscriptionPackageAmount());
		
		if(customerAcquisitionDTO.getSpiCategory() != null && customerAcquisitionDTO.getSpiCategory().length() > 0 )
		customerAcquisitionEntity.setSpiCategory(customerAcquisitionDTO.getSpiCategory());
		
		if(customerAcquisitionDTO.getDeviceConnected() != null && customerAcquisitionDTO.getDeviceConnected().length() > 0 )
		customerAcquisitionEntity.setDeviceConnected(customerAcquisitionDTO.getDeviceConnected());
		
		if(customerAcquisitionDTO.getPollNo() != null && customerAcquisitionDTO.getPollNo() != null )
		customerAcquisitionEntity.setPollNo(customerAcquisitionDTO.getPollNo());
		
		if(customerAcquisitionDTO.getBigBoard() != null && customerAcquisitionDTO.getBigBoard().length() > 0 )
		customerAcquisitionEntity.setBigBoard(customerAcquisitionDTO.getBigBoard());
		
		if(customerAcquisitionDTO.getSmallBoard() != null && customerAcquisitionDTO.getSmallBoard().length() > 0 )
		customerAcquisitionEntity.setSmallBoard(customerAcquisitionDTO.getSmallBoard());
		
		if(customerAcquisitionDTO.getLed() != null && customerAcquisitionDTO.getLed().length() > 0 )
		customerAcquisitionEntity.setLed(customerAcquisitionDTO.getLed());
		
		if(customerAcquisitionDTO.getTypeOfEstablishment() != null && customerAcquisitionDTO.getTypeOfEstablishment().length() > 0 )
		customerAcquisitionEntity.setTypeOfEstablishment(customerAcquisitionDTO.getTypeOfEstablishment());
		
		if(customerAcquisitionDTO.getProfessionOccupation() != null && customerAcquisitionDTO.getProfessionOccupation().length() > 0 )
		customerAcquisitionEntity.setProfessionOccupation(customerAcquisitionDTO.getProfessionOccupation());
		
		if(customerAcquisitionDTO.getConnectionAddressDistrict() != null && customerAcquisitionDTO.getConnectionAddressDistrict().length() > 0 )
		customerAcquisitionEntity.setConnectionAddressDistrict(customerAcquisitionDTO.getConnectionAddressDistrict());
		
		if(customerAcquisitionDTO.getPermanentAddressDistrict() != null && customerAcquisitionDTO.getPermanentAddressDistrict().length() > 0 )
		customerAcquisitionEntity.setPermanentAddressDistrict(customerAcquisitionDTO.getPermanentAddressDistrict());
		
		if(customerAcquisitionDTO.getAddressProofType() != null && customerAcquisitionDTO.getAddressProofType().length() > 0 )
		customerAcquisitionEntity.setAddressProofType(customerAcquisitionDTO.getAddressProofType());
		
		if(customerAcquisitionDTO.getCafNo() != null && customerAcquisitionDTO.getCafNo().length() > 0 )
		customerAcquisitionEntity.setCafNo(customerAcquisitionDTO.getCafNo());
		
		if(customerAcquisitionDTO.getBillingType() != null && customerAcquisitionDTO.getBillingType().length() > 0 )
		customerAcquisitionEntity.setBillingType(customerAcquisitionDTO.getBillingType());
		
		if(customerAcquisitionDTO.getCreatedBy() != 0 && customerAcquisitionDTO.getCreatedBy() != 0 )
		customerAcquisitionEntity.setCreatedBy(customerAcquisitionDTO.getCreatedBy());
		if(customerAcquisitionDTO.getPaymentBy() != 0 && customerAcquisitionDTO.getPaymentBy() != 0 )
		customerAcquisitionEntity.setPaymentBy(customerAcquisitionDTO.getPaymentBy());
		LOGGER.info("Out CustomerAcquisition Updated for "+customerAcquisitionEntity.getId()); 
		return customerAcquisitionEntity.getId();
	}


	private void historiseCustomerAcq(CustomerAcquisition customerAcquisitionEntity) {
		
		CustomerAcquisitionHistory customerAcquisitionHistory = new CustomerAcquisitionHistory();
		
		customerAcquisitionHistory.setId(customerAcquisitionEntity.getId());
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
		customerAcquisitionHistory.setCafNo(customerAcquisitionEntity.getCafNo());
		customerAcquisitionHistory.setBillingType(customerAcquisitionEntity.getBillingType());
		//customerAcquisitionHistory.setHistoryCreatedOn(new Timestamp(new Date().getTime()));
		customerAcquisitionHistory.setCreatedBy(customerAcquisitionEntity.getCreatedBy());
		customerAcquisitionHistory.setPaymentBy(customerAcquisitionEntity.getPaymentBy());
		customerAcquisitionHistoryRepository.save(customerAcquisitionHistory);
		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CustomerAcquisition> CustomerAcquisitionById(Long id) {
		
		List<CustomerAcquisition> customerAcquisition= new ArrayList<>();
		customerAcquisitionRepository.getAllCustomerAcquisitionByid(id).forEach(customerAcquisition::add);
		return customerAcquisition;
	}


	
}
