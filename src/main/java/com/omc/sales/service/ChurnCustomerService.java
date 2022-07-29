package com.omc.sales.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.ChurnCustomerDTO;
import com.omc.sales.entity.ChurnCustomer;
import com.omc.sales.repository.ChurnCustomerRepository;

@Service
public class ChurnCustomerService {
	
	private static final Logger LOGGER = LogManager.getLogger(ChurnCustomerService.class);
	
	@Autowired
	private ChurnCustomerRepository churnCustomerRepository;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long createChurnUser(ChurnCustomerDTO churnCustomerDTO) {
		
		LOGGER.info("Request Received for createChurnCustomer with parameters:"+ "customerName: " + churnCustomerDTO.getCustomerName());
		ChurnCustomer churnCustomer=new ChurnCustomer();
		churnCustomer.setId(churnCustomerDTO.getId());
		churnCustomer.setCustomerId(churnCustomerDTO.getCustomerId());
		churnCustomer.setCustomerName(churnCustomerDTO.getCustomerName());
		churnCustomer.setGender(churnCustomerDTO.getGender());
		churnCustomer.setAddress(churnCustomerDTO.getAddress());
		churnCustomer.setZipcode(churnCustomerDTO.getZipcode());
		churnCustomer.setMobile(churnCustomerDTO.getMobile());
		churnCustomer.setAdharNumber(churnCustomerDTO.getAdharNumber());
		churnCustomer.setPackageType(churnCustomerDTO.getPackageType());
		churnCustomer.setSubscriptionType(churnCustomerDTO.getSubscriptionType());
		churnCustomer.setCustomerPic(churnCustomerDTO.getCustomerPic());
		churnCustomer.setLongitude(churnCustomerDTO.getLongitude());
		churnCustomer.setLatitude(churnCustomerDTO.getLatitude());
		churnCustomer.setSubscriptionStartDate(churnCustomerDTO.getSubscriptionStartDate());
		churnCustomer.setSubscriptionEndDate(churnCustomerDTO.getSubscriptionEndDate());
		churnCustomer.setLastSuccessSubscriptionDate(churnCustomerDTO.getLastSuccessSubscriptionDate());
		churnCustomer.setAddedOn(churnCustomerDTO.getAddedOn());   //////////////
		churnCustomer.setActive(true);
		churnCustomer.setCustomerStatus(churnCustomerDTO.getCustomerStatus());
		churnCustomer.setSalesExecutiveId(churnCustomerDTO.getSalesExecutiveId());
		churnCustomer.setCustAcqId(churnCustomerDTO.getCustAcqId());
		churnCustomer.setPlantId(churnCustomerDTO.getPlantId());
		churnCustomer.setOmcId(churnCustomerDTO.getOmcId());
		churnCustomer.setCustomerUid(churnCustomerDTO.getCustomerUid());
		churnCustomer.setLed(churnCustomerDTO.getLed());
		churnCustomer.setSmallBoard(churnCustomerDTO.getSmallBoard());
		churnCustomer.setBigBoard(churnCustomerDTO.getBigBoard());
		churnCustomer.setWireMeter(churnCustomerDTO.getWireMeter());
		churnCustomer.setPollNo(churnCustomerDTO.getPollNo());
		churnCustomer.setFatherHusbandName(churnCustomerDTO.getFatherHusbandName());
		churnCustomer.setDeviceConnected(churnCustomerDTO.getDeviceConnected());
		churnCustomer.setSpiCategory(churnCustomerDTO.getSpiCategory());
		churnCustomer.setLiveDate(churnCustomerDTO.getLiveDate());
		churnCustomer.setCustomerType(churnCustomerDTO.getCustomerType());
		churnCustomer.setSubscriptionPackageAmount(churnCustomerDTO.getSubscriptionPackageAmount());
		churnCustomer.setSubscriptionPackageId(churnCustomerDTO.getSubscriptionPackageId());
		churnCustomer.setType(churnCustomerDTO.getType());
		churnCustomer.setDateCancellHoldUnhold(churnCustomerDTO.getDateCancellHoldUnhold());
		churnCustomer.setRemarks(churnCustomerDTO.getRemarks());
		churnCustomer.setTypeOfEstablishment(churnCustomerDTO.getTypeOfEstablishment());
		churnCustomer.setCurrentPackageId(churnCustomerDTO.getCurrentPackageId());
		churnCustomer.setCafNo(churnCustomerDTO.getCafNo());
		churnCustomer.setSll(churnCustomerDTO.getSll());
		churnCustomer.setNoOfRcb(churnCustomerDTO.getNoOfRcb());
		churnCustomer.setBillingType(churnCustomerDTO.getBillingType());
		churnCustomer.setCreatedBy(churnCustomerDTO.getCreatedBy());
		churnCustomer.setActivatedBy(churnCustomerDTO.getActivatedBy());
		churnCustomer.setPaymentBy(churnCustomerDTO.getPaymentBy());
		churnCustomer.setCurrentPackageAmount(churnCustomerDTO.getCurrentPackageAmount());
		churnCustomer.setTypeOfBoard(churnCustomerDTO.getTypeOfBoard());
		churnCustomer.setInstallationCertificate(churnCustomerDTO.getInstallationCertificate());
		churnCustomerRepository.save(churnCustomer);
		LOGGER.info("Out createChurnCustomer service with return Value ChurncustomerId:"+churnCustomerDTO.getId()); 
		 return churnCustomer.getId();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<ChurnCustomer> listAllChurnCustomer() {
		
		return churnCustomerRepository.findAllByOrderByIdDesc();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateChurnCustomer(ChurnCustomerDTO churnCustomerDTO) {
		
		LOGGER.info("In updateChurnCustomer  Service");
		ChurnCustomer churnCustomer=new ChurnCustomer();
		if(churnCustomerDTO.getId() != null && churnCustomerDTO.getId() >= 0)
		churnCustomer.setId(churnCustomerDTO.getId());
		
		churnCustomer.setCustomerId(churnCustomerDTO.getCustomerId());
		churnCustomer.setCustomerName(churnCustomerDTO.getCustomerName());
		churnCustomer.setGender(churnCustomerDTO.getGender());
		churnCustomer.setAddress(churnCustomerDTO.getAddress());
		churnCustomer.setZipcode(churnCustomerDTO.getZipcode());
		churnCustomer.setMobile(churnCustomerDTO.getMobile());
		churnCustomer.setAdharNumber(churnCustomerDTO.getAdharNumber());
		churnCustomer.setPackageType(churnCustomerDTO.getPackageType());
		churnCustomer.setSubscriptionType(churnCustomerDTO.getSubscriptionType());
		churnCustomer.setCustomerPic(churnCustomerDTO.getCustomerPic());
		churnCustomer.setLongitude(churnCustomerDTO.getLongitude());
		churnCustomer.setLatitude(churnCustomerDTO.getLatitude());
		churnCustomer.setSubscriptionStartDate(churnCustomerDTO.getSubscriptionStartDate());
		churnCustomer.setSubscriptionEndDate(churnCustomerDTO.getSubscriptionEndDate());
		churnCustomer.setLastSuccessSubscriptionDate(churnCustomerDTO.getLastSuccessSubscriptionDate());
		churnCustomer.setAddedOn(churnCustomerDTO.getAddedOn());   
		churnCustomer.setActive(true);
		churnCustomer.setCustomerStatus(churnCustomerDTO.getCustomerStatus());
		churnCustomer.setSalesExecutiveId(churnCustomerDTO.getSalesExecutiveId());
		churnCustomer.setCustAcqId(churnCustomerDTO.getCustAcqId());
		churnCustomer.setPlantId(churnCustomerDTO.getPlantId());
		churnCustomer.setOmcId(churnCustomerDTO.getOmcId());
		churnCustomer.setCustomerUid(churnCustomerDTO.getCustomerUid());
		churnCustomer.setLed(churnCustomerDTO.getLed());
		churnCustomer.setSmallBoard(churnCustomerDTO.getSmallBoard());
		churnCustomer.setBigBoard(churnCustomerDTO.getBigBoard());
		churnCustomer.setWireMeter(churnCustomerDTO.getWireMeter());
		churnCustomer.setPollNo(churnCustomerDTO.getPollNo());
		churnCustomer.setFatherHusbandName(churnCustomerDTO.getFatherHusbandName());
		churnCustomer.setDeviceConnected(churnCustomerDTO.getDeviceConnected());
		churnCustomer.setSpiCategory(churnCustomerDTO.getSpiCategory());
		churnCustomer.setLiveDate(churnCustomerDTO.getLiveDate());
		churnCustomer.setCustomerType(churnCustomerDTO.getCustomerType());
		churnCustomer.setSubscriptionPackageAmount(churnCustomerDTO.getSubscriptionPackageAmount());
		churnCustomer.setSubscriptionPackageId(churnCustomerDTO.getSubscriptionPackageId());
		churnCustomer.setType(churnCustomerDTO.getType());
		churnCustomer.setDateCancellHoldUnhold(churnCustomerDTO.getDateCancellHoldUnhold());
		churnCustomer.setRemarks(churnCustomerDTO.getRemarks());
		churnCustomer.setTypeOfEstablishment(churnCustomerDTO.getTypeOfEstablishment());
		churnCustomer.setCurrentPackageId(churnCustomerDTO.getCurrentPackageId());
		churnCustomer.setCafNo(churnCustomerDTO.getCafNo());
		churnCustomer.setSll(churnCustomerDTO.getSll());
		churnCustomer.setNoOfRcb(churnCustomerDTO.getNoOfRcb());
		churnCustomer.setBillingType(churnCustomerDTO.getBillingType());
		churnCustomer.setCreatedBy(churnCustomerDTO.getCreatedBy());
		churnCustomer.setActivatedBy(churnCustomerDTO.getActivatedBy());
		churnCustomer.setPaymentBy(churnCustomerDTO.getPaymentBy());
		churnCustomer.setCurrentPackageAmount(churnCustomerDTO.getCurrentPackageAmount());
		churnCustomer.setTypeOfBoard(churnCustomerDTO.getTypeOfBoard());
		churnCustomer.setInstallationCertificate(churnCustomerDTO.getInstallationCertificate());
		churnCustomerRepository.save(churnCustomer);
		LOGGER.info("Out ChurnCustomer Updated for "+churnCustomer.getId());
		 return churnCustomer.getId();
	}
	
	

}
