package com.omc.sales.service;

import java.util.List;

import com.omc.sales.entity.AbhTarget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.SubscriptionTypesDTO;
import com.omc.sales.entity.SubscriptionTypes;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.SubscriptionTypesRepository;

@Service
public class SubscriptionTypesService {
	
	private static final Logger LOGGER = LogManager.getLogger(SubscriptionTypesService.class);
	
	@Autowired
	private SubscriptionTypesRepository subscriptionTypesRepository;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long createSubscription(SubscriptionTypesDTO subscriptionTypesDTO) {
		
		LOGGER.info("In SubscriptionTypesService for addSubscriptionTarget received ");
		SubscriptionTypes subscriptionTypes=new SubscriptionTypes();
		subscriptionTypes.setSubId(subscriptionTypesDTO.getSubId());
		subscriptionTypes.setSubscriptionType(subscriptionTypesDTO.getSubscriptionType());
		subscriptionTypes.setSubStatus(subscriptionTypesDTO.getSubStatus());
		subscriptionTypesRepository.save(subscriptionTypes);
		LOGGER.info(" out from SubscriptionTypesService with  SubId :" + subscriptionTypes.getSubId());
		return subscriptionTypes.getSubId();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateSubscription(SubscriptionTypesDTO subscriptionTypesDTO) {
		SubscriptionTypes subscriptionTypes=subscriptionTypesRepository.findBySubId(subscriptionTypesDTO.getSubId());
		if(subscriptionTypes == null) {
			throw new SSNSQLException("subscription id is not found", ErrorCodes.Subscription_id_not_found);
		}else {
			LOGGER.info("In SubscriptionTypesService for update Subscription received ");
			
			if(subscriptionTypesDTO.getSubscriptionType() != null && subscriptionTypesDTO.getSubscriptionType().length() > 0 )
			subscriptionTypes.setSubscriptionType(subscriptionTypesDTO.getSubscriptionType());
			
			if(subscriptionTypesDTO.getSubStatus() != 0 && subscriptionTypesDTO.getSubStatus() > 0)
			subscriptionTypes.setSubStatus(subscriptionTypesDTO.getSubStatus());
			
	//		subscriptionTypesRepository.save(subscriptionTypes);
			LOGGER.info(" out from SubscriptionTypesService with  SubId :" + subscriptionTypes.getSubId());
			return subscriptionTypes.getSubId();
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SubscriptionTypes> getListSubscriptionTypes() {
		LOGGER.info("In SubscriptionTypesService for get list of  Subscription received ");
		return subscriptionTypesRepository.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void deleteSubscriptionTypes(Long subId) {
		
		subscriptionTypesRepository.deleteById(subId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<SubscriptionTypes> getSubscriptionTypeBySubId(Long subId) {

		return subscriptionTypesRepository.findSubscriptionTypeBySubId(subId);

	}


}
