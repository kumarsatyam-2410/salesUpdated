package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.AbhTargetDTO;
import com.omc.sales.entity.AbhTarget;
import com.omc.sales.entity.ChurnCustomer;
import com.omc.sales.repository.AbhTargetRepository;


@Service
public class AbhTargetService {
	
	private static final Logger LOGGER = LogManager.getLogger(AbhTargetService.class);
	
	@Autowired
	private AbhTargetRepository abhTargetRepository;

	@Transactional(propagation=Propagation.REQUIRED)
	public Long createAbhTarget(AbhTargetDTO abhTargetDTO) {
		
		LOGGER.info("Request Received for createAddAbhTarget with parameters");
		AbhTarget abhTarget=new AbhTarget();
		abhTarget.setAbhId(abhTargetDTO.getAbhId());
		abhTarget.setUserId(abhTargetDTO.getUserId());
		abhTarget.setRevenueTargetAmount(abhTargetDTO.getRevenueTargetAmount());
		abhTarget.setComment(abhTargetDTO.getComment());
		abhTarget.setNoCustomerAcqTarget(abhTargetDTO.getNoCustomerAcqTarget());
		abhTarget.setTargetType(abhTargetDTO.getTargetType());
		abhTarget.setTargetStartDate(abhTargetDTO.getTargetStartDate());
		abhTarget.setTargetEndDate(abhTargetDTO.getTargetEndDate());
		abhTarget.setAddedBy(abhTargetDTO.getAddedBy());
		abhTargetRepository.save(abhTarget);
		LOGGER.info("Out createAbhTarget service with return Value Churncusto"+abhTarget.getAbhId()); 
		return abhTarget.getAbhId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long updateAbhTarget(AbhTargetDTO abhTargetDTO) {
	
		LOGGER.info("Request Received for updateAddAbhTarget with parameters");
		
		AbhTarget abhTarget=new AbhTarget();
		abhTarget.setAbhId(abhTargetDTO.getAbhId());
		abhTarget.setUserId(abhTargetDTO.getUserId());
		abhTarget.setRevenueTargetAmount(abhTargetDTO.getRevenueTargetAmount());
		abhTarget.setComment(abhTargetDTO.getComment());
		abhTarget.setNoCustomerAcqTarget(abhTargetDTO.getNoCustomerAcqTarget());
		abhTarget.setTargetType(abhTargetDTO.getTargetType());
		abhTarget.setTargetStartDate(abhTargetDTO.getTargetStartDate());
		abhTarget.setTargetEndDate(abhTargetDTO.getTargetEndDate());
		abhTarget.setAddedBy(abhTargetDTO.getAddedBy());
		abhTargetRepository.save(abhTarget);
		LOGGER.info("Out updateAbhTarget service with return Value Churncusto"+abhTarget.getAbhId()); 
		return abhTarget.getAbhId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<AbhTarget> getAbhTargetByserId(String userId) {

		 return abhTargetRepository.findAbhTargetByUserId(userId);
	
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<AbhTarget> getListAbhTarget() {
	
		return abhTargetRepository.findAllByOrderByAbhIdDesc();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<AbhTarget> getAbhTargetByAddedBy(int addedBy) {
		
		return abhTargetRepository.getAbhTargetByAddedBy(addedBy);
		
	}
	
	

}
