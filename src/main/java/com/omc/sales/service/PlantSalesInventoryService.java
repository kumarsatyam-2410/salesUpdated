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
import com.omc.sales.entity.CustomerAcquisition;
import com.omc.sales.entity.PlantSalesInventory;
import com.omc.sales.entity.PlantSalesInventoryHistory;
import com.omc.sales.entity.User;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.PlantSalesInventoryHistoryRepository;
import com.omc.sales.repository.PlantSalesInventoryRepository;
import com.omc.sales.repository.PlantUsersRepository;

@Service
public class PlantSalesInventoryService {
	
	/** The Constant logger. */
	private static final Logger LOGGER=LogManager.getLogger(PlantSalesInventoryService.class);
	
	@Autowired
	private PlantSalesInventoryRepository plantSalesInventoryRepository;
	
	@Autowired
	private PlantSalesInventoryHistoryRepository plantSalesInventoryHistoryRepository;
	
	@Autowired
	private PlantUsersRepository plantUsersRepository;
/*
 * add sales inventory
 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Long addInventory(PlantSalesInventoryDTO plantSalesInventoryDTO)throws SSNSQLException {
		
		LOGGER.info("Request Received for createSalesInventory with parameters:"+ "customername: " + plantSalesInventoryDTO.getInventoryId());

		
		PlantSalesInventory existingInventory=plantSalesInventoryRepository.findByPlantId(plantSalesInventoryDTO.getPlantId());
		if(existingInventory !=null)
		{
			throw new SSNSQLException("not unique inventory",ErrorCodes.NOT_UNIQUE_Plan);
		}
		
		PlantSalesInventory  plantSalesInventory=new  PlantSalesInventory();
		
		 plantSalesInventory.setInventoryId(plantSalesInventoryDTO.getInventoryId());
		 plantSalesInventory.setPlantId(plantSalesInventoryDTO.getPlantId());
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
		 
		 LOGGER.info("Out createSalesInventory service with return Value customerId:"+plantSalesInventory.getInventoryId()); 
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
		
		historisePlantSalesInventory(salesInventory);
		
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
		LOGGER.info("Out SalesInventory Updated for "+salesInventory.getInventoryId());
		return salesInventory.getInventoryId();
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteInventory(Long inventoryId) {
		LOGGER.info("In deleteSalesInventory  Service"+plantSalesInventoryRepository.deleteByInventoryId(inventoryId));
		 Long id=plantSalesInventoryRepository.deleteByInventoryId(inventoryId);
		return id;
		
	}

//	@Transactional(propagation=Propagation.REQUIRED)
//	public List<PlantSalesInventory> listAllByInventoryId(Long inventoryId) {
//		
//		List<PlantSalesInventory> list=new ArrayList<>();
//		PlantSalesInventory plantSalesInventory=plantSalesInventoryRepository.findByInventoryId(inventoryId);
//		list.add(plantSalesInventory);
//		return list;
//	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<PlantSalesInventory> listAllSalesInventoryByUserId(int userId) {
	
		return plantSalesInventoryRepository.findJoinQuery(userId);
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	private void historisePlantSalesInventory(PlantSalesInventory salesInventory)
	{
		LOGGER.info("In updateinventoryHistory  Service");
		PlantSalesInventoryHistory plantSalesInventoryHistory=new PlantSalesInventoryHistory();
		plantSalesInventoryHistory.setInventoryId(salesInventory.getInventoryId());
		plantSalesInventoryHistory.setTotalNoPolls(salesInventory.getTotalNoPolls());
		plantSalesInventoryHistory.setUsedNoPolls(salesInventory.getUsedNoPolls());
		plantSalesInventoryHistory.setFreeNoPolls(salesInventory.getFreeNoPolls());
		plantSalesInventoryHistory.setTotalNoSll(salesInventory.getTotalNoSll());
		plantSalesInventoryHistory.setUsedNoSll(salesInventory.getUsedNoSll());
		plantSalesInventoryHistory.setFreeNoSll(salesInventory.getFreeNoSll());
		plantSalesInventoryHistory.setTotalWireMeter(salesInventory.getTotalWireMeter());
		plantSalesInventoryHistory.setUsedWireMeter(salesInventory.getUsedWireMeter());
		plantSalesInventoryHistory.setFreeWireMeter(salesInventory.getFreeWireMeter());
		plantSalesInventoryHistory.setTotalNoBoard(salesInventory.getTotalNoBoard());
		plantSalesInventoryHistory.setFreeNoBoard(salesInventory.getFreeNoBoard());
		plantSalesInventoryHistory.setUsedNoBoard(salesInventory.getUsedNoBoard());
		plantSalesInventoryHistory.setTotalNoRccs(salesInventory.getTotalNoRccs());
		plantSalesInventoryHistory.setUsedNoRccs(salesInventory.getUsedNoRccs());
		plantSalesInventoryHistory.setFreeNoRccs(salesInventory.getFreeNoRccs());
		plantSalesInventoryHistory.setTotalNoGift(salesInventory.getTotalNoGift());
		plantSalesInventoryHistory.setUsedNoGift(salesInventory.getUsedNoGift());
		plantSalesInventoryHistory.setFreeNoGift(salesInventory.getFreeNoGift());
		plantSalesInventoryHistory.setActive(salesInventory.isActive());
		plantSalesInventoryHistory.setCreateOn(salesInventory.getCreateOn());
		plantSalesInventoryHistory.setCreateBy(salesInventory.getCreateBy());
		plantSalesInventoryHistory.setUpdatedOn(salesInventory.getUpdatedOn());
		plantSalesInventoryHistory.setUpdatedBy(salesInventory.getUpdatedBy());
		plantSalesInventoryHistoryRepository.save(plantSalesInventoryHistory);
	
	}
  

	
}
