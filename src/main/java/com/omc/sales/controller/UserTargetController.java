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
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.PlantSalesInventoryResponseDTO;
import com.omc.sales.dto.UserTargetDTO;
import com.omc.sales.dto.UserTargetResponseDTO;
import com.omc.sales.dto.UserTargetResponseListDTO;
import com.omc.sales.entity.UserTarget;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.UserTargetService;

@RestController
public class UserTargetController {
	
	/** The Constant logger. */
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(UserTargetController.class);
	
	@Autowired
	private UserTargetService userTargetService;
	
    @PostMapping("/addusertarget")
	public ResponseEntity<UserTargetResponseDTO> createUserTarget(@RequestBody UserTargetDTO userTargetDTO)
	{
		ResponseEntity<UserTargetResponseDTO> response;
		UserTargetResponseDTO userTargetResponseDTO=new UserTargetResponseDTO();
		try
		{
			LOGGER.info("In UserTargetController for addusertarget Request");
			Long id=userTargetService.addUserTarget(userTargetDTO);
			userTargetResponseDTO.setTargetId(id);
			userTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.CREATED);
			
		}
		catch(BaseException e)
		{
			LOGGER.warn("Exception occur during = " + e.getMessage());

			userTargetResponseDTO.setErrorCode(e.getErrorCode().getCode());
			userTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			userTargetResponseDTO.setErrorMessage(e.getMessage());
			response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.CREATED);
		}
		catch(RuntimeException e)
		{
			LOGGER.warn("Error occurred during runtime creating customer", e);

			userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
			response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			LOGGER.warn("Error occurred while creating customer", e);
			userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
			response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.CREATED);
		}
		return response;
	}
	
    @GetMapping("/getallusertarget")
	public List<UserTarget> listAll()
	{
    	ResponseEntity<UserTargetResponseListDTO> response;
		List<UserTarget> list=new ArrayList();
		UserTargetResponseListDTO userTargetResponseListDTO=new UserTargetResponseListDTO();
         try
         {
 			LOGGER.info("In UserTargetController for listAll usertarget Request");	
        	 list=userTargetService.listAll();
        	 userTargetResponseListDTO.setList(list);
        	 userTargetResponseListDTO.setStatus(HttpStatus.OK.value());
        	 response=new ResponseEntity<>(userTargetResponseListDTO,HttpStatus.OK);
        	 
         }
         catch(RuntimeException e)
         {
 			LOGGER.warn("Error occurred while listing UserTarget", e);
        	 userTargetResponseListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        	 userTargetResponseListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
        	 userTargetResponseListDTO.setErrorMessage(e.getCause().getMessage());
        	 response=new ResponseEntity<>(userTargetResponseListDTO,HttpStatus.INTERNAL_SERVER_ERROR);
         }
         catch(Exception e)
         {
 			LOGGER.warn("Error occurred while listing UserTarget", e);
        	 userTargetResponseListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        	 userTargetResponseListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
        	 userTargetResponseListDTO.setErrorMessage(e.getCause().getMessage());
        	 response=new ResponseEntity<>(userTargetResponseListDTO,HttpStatus.INTERNAL_SERVER_ERROR);

         }
		return list;
	}

    
   @PutMapping("/updateusertarget")
   public ResponseEntity<UserTargetResponseDTO> updateUserTarget(@RequestBody UserTargetDTO userTargetDTO)
   {
	   ResponseEntity<UserTargetResponseDTO> response;
	   UserTargetResponseDTO userTargetResponseDTO=new UserTargetResponseDTO();
	   try
	   {
   		LOGGER.info("In UserTargetController for updateUserTarget Request");
		   Long id=userTargetService.updateUserTarget(userTargetDTO);
		   userTargetResponseDTO.setTargetId(id);
		   userTargetResponseDTO.setStatus(HttpStatus.OK.value());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.OK);
	   }
	   catch(RuntimeException e)
	   {
   		LOGGER.warn("Error occurred while updating CPOC URL", e);
		   userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
		   userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		   userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   catch(Exception e)
	   {    		  
		    LOGGER.warn("Error occurred while updating CPOC URL", e);
		   userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
		   userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		   userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR); 
	   }
	return response;
	   
   }
   
   @DeleteMapping("/deleteusertarget/{targetId}")
   public ResponseEntity<UserTargetResponseDTO> deleteUserTarget(@PathVariable Long targetId)
   {
	   ResponseEntity<UserTargetResponseDTO> response;
	   UserTargetResponseDTO userTargetResponseDTO=new UserTargetResponseDTO();
	   try
	   {
		   LOGGER.info("In UserTargetController for deleteUserTarget Request");
		   Long id=userTargetService.deleteUserTarget(targetId);
		   userTargetResponseDTO.setTargetId(targetId);
		   userTargetResponseDTO.setStatus(HttpStatus.OK.value());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.OK);
	   }
	   catch(RuntimeException e)
	   {
	   		LOGGER.warn("Error occurred while deleting CPOC URL", e);
		   userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		   userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
		   userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   catch(Exception e)
	   {
		    LOGGER.warn("Error occurred while deleting CPOC URL", e);
		   userTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		   userTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
		   userTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		   response=new ResponseEntity<>(userTargetResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	return response;
   }
}
