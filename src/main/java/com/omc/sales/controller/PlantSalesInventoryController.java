package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.PlantSalesInventoryDTO;
import com.omc.sales.dto.PlantSalesInventoryListResponseDTO;
import com.omc.sales.dto.PlantSalesInventoryResponseDTO;
import com.omc.sales.entity.PlantSalesInventory;
import com.omc.sales.entity.User;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.PlantSalesInventoryService;

@RestController
public class PlantSalesInventoryController {
	
	/** The Constant logger. */
	private static final org.apache.logging.log4j.Logger LOGGER=LogManager.getLogger(PlantSalesInventoryController.class);
	
	@Autowired
	private PlantSalesInventoryService plantSalesInventoryService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void testSalesInventory() 
	{
		LOGGER.info("Test successfull");
	}
	/*
	 * add user in database
	 */
	@PostMapping("/addsalesinventory")
    public ResponseEntity<PlantSalesInventoryResponseDTO> createInventory(@RequestBody PlantSalesInventoryDTO plantSalesInventoryDTO)
    {
    	ResponseEntity<PlantSalesInventoryResponseDTO> responseInventory;
    	PlantSalesInventoryResponseDTO plantSalesInventoryResponseDTO=new PlantSalesInventoryResponseDTO();
    	
    	try
    	{
    		LOGGER.info("In SalesInventoryController for addSalesInventory Request");
    		Long id=plantSalesInventoryService.addInventory(plantSalesInventoryDTO);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.CREATED.value());
    		plantSalesInventoryResponseDTO.setInventoryId(id);
    		plantSalesInventoryResponseDTO.setErrorMessage("success");
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.CREATED);
    	}
    	catch(BaseException e)
    	{
    		LOGGER.warn("Exception occur during = " + e.getMessage());
    		plantSalesInventoryResponseDTO.setErrorCode(e.getErrorCode().getCode());
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
    		plantSalesInventoryResponseDTO.setErrorMessage(e.getErrorMsg());
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.BAD_REQUEST);
    		
    	}
    	catch(RuntimeException exception)
    	{
    		LOGGER.warn("Error occurred during runtime creating salesInventory", exception);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		plantSalesInventoryResponseDTO.setErrorMessage(exception.getCause().getMessage());
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    		plantSalesInventoryResponseDTO.setErrorMessage(exception.getCause().getMessage());
    	}
    	catch(Exception exception)
    	{
    		LOGGER.warn("Error occurred while creating salesInventory", exception);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    		plantSalesInventoryResponseDTO.setErrorMessage(exception.getCause().getMessage());
    	}
    	
		return responseInventory;
    	
    }
	
	/*
	 *  get data from database
	 */
	@GetMapping("/getallsalesinventory")
	public List<PlantSalesInventory> listAll()
	{
		
		ResponseEntity<PlantSalesInventoryListResponseDTO> responseEntity;
		List<PlantSalesInventory> list=new ArrayList();
		PlantSalesInventoryListResponseDTO plantSalesInventoryListResponseDTO=new PlantSalesInventoryListResponseDTO();
		try 
		{
			LOGGER.info("In PlantSalesInventoryController for listAll SalesInventoryt Request");	
			list=plantSalesInventoryService.listAll();
			plantSalesInventoryListResponseDTO.setList(list);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.OK);
			
		}
		catch(RuntimeException e)
		{
			LOGGER.warn("Error occurred while listing PlantSalesInventory", e);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		catch(Exception e)
		{
			LOGGER.warn("Error occurred while listing customer", e);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return list;
		
	}
	
	/*
	 *  update the sales inventory
	 */
	@PutMapping("/updatesalesinventory")
	public  ResponseEntity<PlantSalesInventoryResponseDTO> updateSalesInventory(@RequestBody PlantSalesInventoryDTO plantSalesInventoryDTO)
	{
		ResponseEntity<PlantSalesInventoryResponseDTO> responseInventory;
    	PlantSalesInventoryResponseDTO plantSalesInventoryResponseDTO=new PlantSalesInventoryResponseDTO();
    	try
    	{
    		LOGGER.info("In SalesInventoryController for updateCustomer Request");
    		Long id=plantSalesInventoryService.updateSalesInventory(plantSalesInventoryDTO);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.OK.value());
    		plantSalesInventoryResponseDTO.setInventoryId(id);
    		plantSalesInventoryResponseDTO.setErrorMessage("all done");
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.OK);
    	}
    	catch(RuntimeException e)
    	{
    		LOGGER.warn("Error occurred while updating CPOC URL", e);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    		plantSalesInventoryResponseDTO.setErrorMessage(e.getCause().getMessage());
    	}
    	catch(Exception e)
    	{
    		LOGGER.warn("Error occurred while updating CPOC URL", e);
    		plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		responseInventory=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    		plantSalesInventoryResponseDTO.setErrorMessage(e.getCause().getMessage());
    	}
		return responseInventory;
		
	}
	
	/*
	 *  delete the sales inventory
	 */
	
	@DeleteMapping("/deletesalesinventory/{inventoryId}")
	public ResponseEntity<PlantSalesInventoryResponseDTO> deleteSalesInventory(@PathVariable Long inventoryId)
	{
		ResponseEntity<PlantSalesInventoryResponseDTO> response;
		PlantSalesInventoryResponseDTO plantSalesInventoryResponseDTO=new PlantSalesInventoryResponseDTO();
		try
		{
			LOGGER.info("In SalesInventoryController for deletingsalesInventory Request");
			Long id=plantSalesInventoryService.deleteInventory(inventoryId);
			plantSalesInventoryResponseDTO.setStatus(HttpStatus.OK.value());
			plantSalesInventoryResponseDTO.setInventoryId(inventoryId);
			response=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			LOGGER.warn("Error occurred while updating CPOC URL", e);
			plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		catch(Exception e)
		{
			LOGGER.warn("Error occurred while updating CPOC URL", e);
			plantSalesInventoryResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantSalesInventoryResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response=new ResponseEntity<>(plantSalesInventoryResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;
	
	}
	
//	@GetMapping("/getallsalesinventory/{inventoryId}")
//	public List<PlantSalesInventory> listAllByInventoryId(@PathVariable Long inventoryId)
//	{
//		
//		ResponseEntity<PlantSalesInventoryListResponseDTO> responseEntity;
//		List<PlantSalesInventory> list=new ArrayList();
//		PlantSalesInventoryListResponseDTO plantSalesInventoryListResponseDTO=new PlantSalesInventoryListResponseDTO();
//		try 
//		{
//			LOGGER.info("In PlantSalesInventoryController for listAll SalesInventoryt Request");	
//			list=plantSalesInventoryService.listAllByInventoryId(inventoryId);
//			plantSalesInventoryListResponseDTO.setList(list);
//			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.OK.value());
//			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.OK);
//			
//		}
//		catch(RuntimeException e)
//		{
//			LOGGER.warn("Error occurred while listing PlantSalesInventory", e);
//			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
//			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
//			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
//		}
//		catch(Exception e)
//		{
//			LOGGER.warn("Error occurred while listing customer", e);
//			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
//			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
//			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
//		}
//		return list;
//		
//	}
//	
	
	//////////////////////////
	@GetMapping("/getallsalesinventory/{userId}")
	public ResponseEntity<PlantSalesInventoryListResponseDTO> listAllSalesInventoryByUserId(@PathVariable int userId)
	{
		
		ResponseEntity<PlantSalesInventoryListResponseDTO> responseEntity;
		List<PlantSalesInventory> list=new ArrayList();
		PlantSalesInventoryListResponseDTO plantSalesInventoryListResponseDTO=new PlantSalesInventoryListResponseDTO();
		try 
		{
			LOGGER.info("In PlantSalesInventoryController for listAll SalesInventoryt Request");	
			list=plantSalesInventoryService.listAllSalesInventoryByUserId(userId);
			plantSalesInventoryListResponseDTO.setList(list);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.OK);
			
		}
		catch(RuntimeException e)
		{
			LOGGER.warn("Error occurred while listing PlantSalesInventory", e);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		catch(Exception e)
		{
			LOGGER.warn("Error occurred while listing customer", e);
			plantSalesInventoryListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantSalesInventoryListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity=new ResponseEntity<>(plantSalesInventoryListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantSalesInventoryListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return responseEntity;
		
	}
}
