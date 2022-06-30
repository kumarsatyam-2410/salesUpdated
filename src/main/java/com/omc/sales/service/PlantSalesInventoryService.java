package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.PlantSalesInventoryDTO;
import com.omc.sales.entity.PlantSalesInventory;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.PlantSalesInventoryRepository;

@Service
public class PlantSalesInventoryService {
	
	/** The Constant logger. */
	private static final Logger LOGGER=LogManager.getLogger(PlantSalesInventoryService.class);
	
	@Autowired
	private PlantSalesInventoryRepository plantSalesInventoryRepository;
/*
 * add sales inventory
 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long addInventory(PlantSalesInventoryDTO plantSalesInventoryDTO)throws SSNSQLException {
		
		LOGGER.info("Request Received for createSalesInventory with parameters:"+ "customername: " + plantSalesInventoryDTO.getUserId());

		
		PlantSalesInventory existingInventory=plantSalesInventoryRepository.findByPlantId(plantSalesInventoryDTO.getPlantId());
		if(existingInventory !=null)
		{
			throw new SSNSQLException("not unique inventory",ErrorCodes.NOT_UNIQUE_Plan);
		}
		
		PlantSalesInventory  plantSalesInventory=new  PlantSalesInventory();
		
		 plantSalesInventory.setInventoryId(plantSalesInventoryDTO.getInventoryId());
		 plantSalesInventory.setPlantId(plantSalesInventoryDTO.getPlantId());
		 plantSalesInventory.setUserId(plantSalesInventoryDTO.getUserId());
		 plantSalesInventory.setTotalNoPolls(plantSalesInventoryDTO.getTotalNoPolls());
		 plantSalesInventory.setUsedNoPolls(plantSalesInventoryDTO.getUsedNoPolls());
		 plantSalesInventory.setFreeNoPolls(plantSalesInventoryDTO.getFreeNoPolls());
		 plantSalesInventory.setTotalNoSll(plantSalesInventoryDTO.getTotalNoSsl());
		 plantSalesInventory.setUsedNoSll(plantSalesInventoryDTO.getUsedNoSsl());
		 plantSalesInventory.setFreeNoSll(plantSalesInventoryDTO.getFreeNoSsl());
		 plantSalesInventory.setTotalWireMeter(plantSalesInventoryDTO.getTotalWireMeter());
		 plantSalesInventory.setUsedWireMeter(plantSalesInventoryDTO.getUsedWireMeter());
		 plantSalesInventory.setFreeWireMeter(plantSalesInventoryDTO.getFreeWireMeter());
		 plantSalesInventory.setTotalNoBoard(plantSalesInventoryDTO.getTotalNoBoard());
		 plantSalesInventory.setFreeNoBoard(plantSalesInventoryDTO.getFreeNoBoard());
		 plantSalesInventory.setUsedNoBoard(plantSalesInventoryDTO.getUsedNoBoard());
		 plantSalesInventory.setTotalNoRccs(plantSalesInventoryDTO.getTotalNoRccs());
		 plantSalesInventory.setUsedNoRccs(plantSalesInventoryDTO.getUsedNoRccs());
		 plantSalesInventory.setFreeNoRccs(plantSalesInventoryDTO.getFreeNoRccs());
		 plantSalesInventory.setTotalNoGift(plantSalesInventoryDTO.getTotalNoGift());
		 plantSalesInventory.setUsedNoGift(plantSalesInventoryDTO.getUsedNoGift());
		 plantSalesInventory.setFreeNoGift(plantSalesInventoryDTO.getFreeNoGift());
		 plantSalesInventory.setActive(plantSalesInventoryDTO.isActive());
		 plantSalesInventory.setCreateOn(plantSalesInventoryDTO.getCreateOn());
		 plantSalesInventory.setCreateBy(plantSalesInventoryDTO.getCreateBy());
		 plantSalesInventory.setUpdatedOn(plantSalesInventoryDTO.getUpdateOn());
		 plantSalesInventory.setUpdatedBy(plantSalesInventoryDTO.getUpdateBy());
		 
		 plantSalesInventoryRepository.save(plantSalesInventory);
		 
		 LOGGER.info("Out createSalesInventory service with return Value customerId:"+plantSalesInventory.getUserId()); 
		 return plantSalesInventory.getInventoryId();
		
    }
	
	/*
	 * get list of all sales inventory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<PlantSalesInventory> listAll() {
		LOGGER.info("In listAllSalesInventory  Service");
		List<PlantSalesInventory> salesInventory=new ArrayList();
		plantSalesInventoryRepository.findAll().forEach(salesInventory::add);
		return salesInventory;
	}

	/*
	 * uodate the sales inventory
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long updateSalesInventory(PlantSalesInventoryDTO plantSalesInventoryDTO) {
		
		LOGGER.info("In updateSalesInventory  Service");
	
		PlantSalesInventory salesInventory=plantSalesInventoryRepository.findByInventoryId(plantSalesInventoryDTO.getInventoryId());
		salesInventory.setInventoryId(plantSalesInventoryDTO.getInventoryId());
		salesInventory.setTotalNoPolls(plantSalesInventoryDTO.getTotalNoPolls());
		salesInventory.setUsedNoPolls(plantSalesInventoryDTO.getUsedNoPolls());
		salesInventory.setFreeNoPolls(plantSalesInventoryDTO.getFreeNoPolls());
		salesInventory.setTotalNoSll(plantSalesInventoryDTO.getTotalNoSsl());
		salesInventory.setUsedNoSll(plantSalesInventoryDTO.getUsedNoSsl());
		salesInventory.setFreeNoSll(plantSalesInventoryDTO.getFreeNoSsl());
		salesInventory.setTotalWireMeter(plantSalesInventoryDTO.getTotalWireMeter());
		salesInventory.setUsedWireMeter(plantSalesInventoryDTO.getUsedWireMeter());
		salesInventory.setFreeWireMeter(plantSalesInventoryDTO.getFreeWireMeter());
		salesInventory.setTotalNoBoard(plantSalesInventoryDTO.getTotalNoBoard());
		salesInventory.setFreeNoBoard(plantSalesInventoryDTO.getFreeNoBoard());
		salesInventory.setUsedNoBoard(plantSalesInventoryDTO.getUsedNoBoard());
		salesInventory.setTotalNoRccs(plantSalesInventoryDTO.getTotalNoRccs());
		salesInventory.setUsedNoRccs(plantSalesInventoryDTO.getUsedNoRccs());
		salesInventory.setFreeNoRccs(plantSalesInventoryDTO.getFreeNoRccs());
		salesInventory.setTotalNoGift(plantSalesInventoryDTO.getTotalNoGift());
		salesInventory.setUsedNoGift(plantSalesInventoryDTO.getUsedNoGift());
		salesInventory.setFreeNoGift(plantSalesInventoryDTO.getFreeNoGift());
		salesInventory.setActive(plantSalesInventoryDTO.isActive());
		salesInventory.setCreateOn(plantSalesInventoryDTO.getCreateOn());
		salesInventory.setCreateBy(plantSalesInventoryDTO.getCreateBy());
		salesInventory.setUpdatedOn(plantSalesInventoryDTO.getUpdateOn());
		salesInventory.setUpdatedBy(plantSalesInventoryDTO.getUpdateBy());
		LOGGER.info("Out SalesInventory Updated for "+salesInventory.getUserId());
		return salesInventory.getInventoryId();
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteInventory(Long userId) {
		LOGGER.info("In deleteSalesInventory  Service"+plantSalesInventoryRepository.deleteByUserId(userId));
		 Long id=plantSalesInventoryRepository.deleteByUserId(userId);
		return id;
		
	}

	

	
  

	
}
