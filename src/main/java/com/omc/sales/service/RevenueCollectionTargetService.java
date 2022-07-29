package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omc.sales.dto.ChurnUserListResponseDTO;
import com.omc.sales.dto.RevenueCollectionTargetDTO;
import com.omc.sales.entity.ChurnCustomer;
import com.omc.sales.entity.RevenueCollectionTarget;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.repository.RevenueCollectionTargetRepository;

@Service
public class RevenueCollectionTargetService {

	private static final Logger LOGGER = LogManager.getLogger(RevenueCollectionTargetService.class);
	
	@Autowired
	private RevenueCollectionTargetRepository revenueCollectionTargetRepository;

	@Transactional(propagation=Propagation.REQUIRED)
	public Long createRevenueCollectionTarget(RevenueCollectionTargetDTO revenueCollectionTargetDTO) {
		
		LOGGER.info("Request Received for createRevenueCollectionTarget with parameters");
		RevenueCollectionTarget revenueCollectionTarget=new RevenueCollectionTarget();
		revenueCollectionTarget.setRctId(revenueCollectionTargetDTO.getRctId());
		revenueCollectionTarget.setUserId(revenueCollectionTargetDTO.getUserId());
		revenueCollectionTarget.setRevenueTargetAmount(revenueCollectionTargetDTO.getRevenueTargetAmount());
		revenueCollectionTarget.setTargetType(revenueCollectionTargetDTO.getTargetType());
		revenueCollectionTarget.setComment(revenueCollectionTargetDTO.getComment());
		revenueCollectionTarget.setTargetStartDate(revenueCollectionTargetDTO.getTargetStartDate());
		revenueCollectionTarget.setTargetEndDate(revenueCollectionTargetDTO.getTargetEndDate());
		revenueCollectionTarget.setAddedBy(revenueCollectionTargetDTO.getAddedBy());
		 revenueCollectionTargetRepository.save(revenueCollectionTarget); 
		 LOGGER.info("Out createAbhTarget service with return Value Churncusto"+revenueCollectionTarget.getRctId());
		return revenueCollectionTarget.getRctId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long updateRevenueCollectionTarget(RevenueCollectionTargetDTO revenueCollectionTargetDTO) {
		
		LOGGER.info("Request Received for updateRevenueCollectionTarget ");
		RevenueCollectionTarget revenueCollectionTarget=new RevenueCollectionTarget();
		revenueCollectionTarget.setRctId(revenueCollectionTargetDTO.getRctId());
		revenueCollectionTarget.setUserId(revenueCollectionTargetDTO.getUserId());
		revenueCollectionTarget.setRevenueTargetAmount(revenueCollectionTargetDTO.getRevenueTargetAmount());
		revenueCollectionTarget.setTargetType(revenueCollectionTargetDTO.getTargetType());
		revenueCollectionTarget.setComment(revenueCollectionTargetDTO.getComment());
		revenueCollectionTarget.setTargetStartDate(revenueCollectionTargetDTO.getTargetStartDate());
		revenueCollectionTarget.setTargetEndDate(revenueCollectionTargetDTO.getTargetEndDate());
		revenueCollectionTarget.setAddedBy(revenueCollectionTargetDTO.getAddedBy());
		 revenueCollectionTargetRepository.save(revenueCollectionTarget); 
		 LOGGER.info("Out updateAbhTarget service with return Value rctId"+revenueCollectionTarget.getRctId());
		return revenueCollectionTarget.getRctId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<RevenueCollectionTarget> getRevenueCollectionTargetByserId(String userId) {
	
		
		return revenueCollectionTargetRepository.findRevenueCollectionTargetByUserId(userId); 
	 
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<RevenueCollectionTarget> getListrevenueCollectionTarget() {
		
		return revenueCollectionTargetRepository.findTop10ByOrderByRctIdDesc();
	}

	public List<RevenueCollectionTarget> getRevenueCollectionTargetByAddedBy(int addedBy) {
		
		return revenueCollectionTargetRepository.getListRevenueCollectionTargetByAddedBy(addedBy);
	}

	

	
	}
