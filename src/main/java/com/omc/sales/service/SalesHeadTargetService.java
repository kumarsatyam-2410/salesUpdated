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

import com.omc.sales.dto.SalesHeadTargetDTO;
import com.omc.sales.entity.SalesHeadTarget;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.SalesHeadTargetRepository;

@Service
public class SalesHeadTargetService {
	
	  private static final Logger LOGGER = LogManager.getLogger(SalesHeadTargetService.class);
	
	  @Autowired
      private SalesHeadTargetRepository salesHeadTargetRepository;

	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long createsalesTarget(SalesHeadTargetDTO salesHeadTargetDTO) {
		
		LOGGER.info("In SalesHeadTargetService for addSalesHeadTarget received");
		
		SalesHeadTarget salesHeadTarget=new SalesHeadTarget();
		salesHeadTarget.setSalesHeadId(salesHeadTargetDTO.getSalesHeadId());
		salesHeadTarget.setUserId(salesHeadTargetDTO.getUserId());
		salesHeadTarget.setTargetType(salesHeadTargetDTO.getTargetType());
		salesHeadTarget.setTargetStartDate(salesHeadTargetDTO.getTargetStartDate());
		salesHeadTarget.setTargetEndDate(salesHeadTargetDTO.getTargetEndDate());
		salesHeadTarget.setNoCustomerAcqTarget(salesHeadTargetDTO.getNoCustomerAcqTarget());
		salesHeadTarget.setRevenueTargetAmount(salesHeadTargetDTO.getRevenueTargetAmount());
		salesHeadTarget.setComment(salesHeadTargetDTO.getComment());
		salesHeadTarget.setAddedBy(salesHeadTargetDTO.getAddedBy());
		salesHeadTargetRepository.save(salesHeadTarget);
		LOGGER.info("out from SalesHeadTargetService : " + salesHeadTarget.getSalesHeadId());
		return salesHeadTarget.getSalesHeadId();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updateSaleHeadTarget(SalesHeadTargetDTO salesHeadTargetDTO) {
	
		LOGGER.info("In SalesHeadTargetService for updateSalesHeadTarget received");
		SalesHeadTarget salesHeadTarget=salesHeadTargetRepository.findBySalesHeadId(salesHeadTargetDTO.getSalesHeadId());
		
		if(salesHeadTarget ==null) {
			throw new SSNSQLException("salesHeadId is not found", ErrorCodes.Sales_head_not_found);
		}else {
			salesHeadTarget.setUserId(salesHeadTargetDTO.getUserId());
			salesHeadTarget.setTargetType(salesHeadTargetDTO.getTargetType());
			salesHeadTarget.setTargetStartDate(salesHeadTargetDTO.getTargetStartDate());
			salesHeadTarget.setTargetEndDate(salesHeadTargetDTO.getTargetEndDate());
			salesHeadTarget.setNoCustomerAcqTarget(salesHeadTargetDTO.getNoCustomerAcqTarget());
			salesHeadTarget.setRevenueTargetAmount(salesHeadTargetDTO.getRevenueTargetAmount());
			salesHeadTarget.setComment(salesHeadTargetDTO.getComment());
			salesHeadTarget.setAddedBy(salesHeadTargetDTO.getAddedBy());
			salesHeadTargetRepository.save(salesHeadTarget);
			LOGGER.info("out from SalesHeadTargetService : " + salesHeadTarget.getSalesHeadId());
			return salesHeadTarget.getSalesHeadId();
		}
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SalesHeadTarget> getSalesHeadTargetByUserId(String userId) {
		
		LOGGER.info("In SalesHeadTargetService for get SalesHeadTarget by userId");
		List<SalesHeadTarget> list = new ArrayList<>();
		
		SalesHeadTarget salesHeadTarget=salesHeadTargetRepository.findSalesHeadTargetByUserId(userId);
		list.add(salesHeadTarget);
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SalesHeadTarget> getSalesHeadTargetBySalesHeadId(Long salesHeadId) {
		
		LOGGER.info("In SalesHeadTargetService for get SalesHeadTarget by salesHeadId");
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTarget salesHeadTarget=salesHeadTargetRepository.findBySalesHeadId(salesHeadId);
		list.add(salesHeadTarget);
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SalesHeadTarget> findSalesHeadTargetByAddedBy(int addedBy) {
		
		LOGGER.info("In SalesHeadTargetService for get SalesHeadTarget by addedBy");
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTarget salesHeadTarget=salesHeadTargetRepository.findSalesHeadTargetByAddedBy(addedBy);
		list.add(salesHeadTarget);
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SalesHeadTarget> getSalesHeadTargetList() {
		
		LOGGER.info("In SalesHeadTargetService for get SalesHeadTarget List");
		return salesHeadTargetRepository.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<SalesHeadTarget> getSalesHeadTargetByDateRange(Timestamp startDate, Timestamp endDate) {
		
		LOGGER.info("In SalesHeadTargetService for get SalesHeadTarget by DateRange");
		return salesHeadTargetRepository.getAllBetweenDates(startDate ,endDate);
	}

	public void deletesalesHeadTargetBySalesHeadId(Long salesHeadId) {
		
		LOGGER.info("In SalesHeadTargetService for delete SalesHeadTarget by salesHeadId");
		salesHeadTargetRepository.deleteById(salesHeadId);
	}
	

}
