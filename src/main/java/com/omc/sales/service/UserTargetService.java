package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.controller.UserTargetController;
import com.omc.sales.dto.UserTargetDTO;
import com.omc.sales.entity.UserTarget;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.UserTargetRepository;

@Service
public class UserTargetService {
	
	/** The Constant logger. */
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserTargetService.class);

	
	@Autowired
	private UserTargetRepository userTargetRepository;

	@Transactional(propagation=Propagation.REQUIRED)
	public Long addUserTarget(UserTargetDTO userTargetDTO)throws SSNSQLException {
		
		LOGGER.info("Request Received for createUserTarget with parameters:"+ "targetId: " + userTargetDTO.getTargetId());
		// UserTarget existingUserTarget=userTargetRepository.findById(userTargetDTO.getTargetId()).get();
		/*
		 * if(existingUserTarget !=null) { throw new
		 * SSNSQLException("not unique inventory",ErrorCodes.NOT_UNIQUE_Plan); }
		 */
		UserTarget userTarget=new UserTarget();
		userTarget.setTargetId(userTargetDTO.getTargetId());
		userTarget.setUserId(userTargetDTO.getUserId());
		userTarget.setTargetType(userTargetDTO.getTargetType());
		userTarget.setYear(userTargetDTO.getYear());
		userTarget.setMonth(userTargetDTO.getMonth());
		userTarget.setNoCustomerAcqTarget(userTargetDTO.getNoCustomerAcqTarget());
		userTarget.setRevenueTargetAmount(userTargetDTO.getRevenueTargetAmount());
		userTarget.setComment(userTargetDTO.getComment());
		userTarget.setAddedBy(userTargetDTO.getAddedBy());
		userTargetRepository.save(userTarget);
		 LOGGER.info("Out createSalesInventory service with return Value customerId:"+userTarget.getTargetId()); 
		return userTarget.getTargetId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<UserTarget> listAll() {
		LOGGER.info("In listAllOfUserTarget  Service");
		List<UserTarget> userTarget=new ArrayList();
		userTargetRepository.findTop10ByOrderByTargetIdDesc().forEach(userTarget::add);
		return userTarget;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long updateUserTarget(UserTargetDTO userTargetDTO) {
		LOGGER.info("In updateUserTarget  Service");
		UserTarget userTarget=userTargetRepository.findById(userTargetDTO.getTargetId()).get();
		
		userTarget.setUserId(userTargetDTO.getUserId());
		userTarget.setTargetType(userTargetDTO.getTargetType());
		userTarget.setYear(userTargetDTO.getYear());
		userTarget.setMonth(userTargetDTO.getMonth());
		userTarget.setNoCustomerAcqTarget(userTargetDTO.getNoCustomerAcqTarget());
		userTarget.setRevenueTargetAmount(userTargetDTO.getRevenueTargetAmount());
		userTarget.setComment(userTargetDTO.getComment());
		userTarget.setAddedBy(userTargetDTO.getAddedBy());
		
		userTargetRepository.save(userTarget);
		System.out.println(userTarget.getNoCustomerAcqTarget());
		
		LOGGER.info("Out UserTarget Updated for "+userTarget.getTargetId());
		return userTarget.getTargetId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteUserTarget(Long targetId) {
		LOGGER.info("In deleteSalesInventory  Service");
        userTargetRepository.deleteById(targetId);
		return targetId;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<UserTarget> listAllByUserId(Integer userId) {
		
		return userTargetRepository.findListByUserId(userId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<UserTarget> listAllByAddedBy(int addedBy) {
		
		return userTargetRepository.getListByAddedBy(addedBy);
	}

	public List<UserTarget> listAllByUserId(Long targetId) {
		
		List<UserTarget> list=new ArrayList();
		UserTarget userTarget =	userTargetRepository.findListByTargetId(targetId);
	 	list.add(userTarget);
		 return list;
	}

}
