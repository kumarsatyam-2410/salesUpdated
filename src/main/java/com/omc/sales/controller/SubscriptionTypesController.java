package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.*;
import com.omc.sales.entity.AbhTarget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.entity.SalesHeadTarget;
import com.omc.sales.entity.SubscriptionTypes;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.SubscriptionTypesService;

@RestController
public class SubscriptionTypesController {
	
    private static final Logger LOGGER = LogManager.getLogger(SubscriptionTypesController.class);
    
    @Autowired
    private SubscriptionTypesService subscriptionTypesService;

	@RequestMapping(value = "/addSubscription", method = RequestMethod.POST)
	public ResponseEntity<SubscriptionTypesResponseDTO> addSubscription(@RequestBody SubscriptionTypesDTO subscriptionTypesDTO) {

		ResponseEntity<SubscriptionTypesResponseDTO> responseEntity;
		SubscriptionTypesResponseDTO subscriptionTypesResponseDTO = new SubscriptionTypesResponseDTO();
		try{
			LOGGER.info("In SubscriptionTypesController for addSubscriptionTarget Request");
			Long subId = subscriptionTypesService.createSubscription(subscriptionTypesDTO);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.CREATED.value());
			subscriptionTypesResponseDTO.setSubId(subId);
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			subscriptionTypesResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			subscriptionTypesResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addSubscriptionTarget", exception);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addSubscriptionTarget", exception);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/updateSubscription", method = RequestMethod.PUT)
	public ResponseEntity<SubscriptionTypesResponseDTO> updateSubscription(@RequestBody SubscriptionTypesDTO subscriptionTypesDTO) {

		ResponseEntity<SubscriptionTypesResponseDTO> responseEntity;
		SubscriptionTypesResponseDTO subscriptionTypesResponseDTO = new SubscriptionTypesResponseDTO();
		try{
			LOGGER.info("In SubscriptionTypesController for update SubscriptionTarget Request");
			Long subId = subscriptionTypesService.updateSubscription(subscriptionTypesDTO);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.CREATED.value());
			subscriptionTypesResponseDTO.setSubId(subId);
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			subscriptionTypesResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			subscriptionTypesResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addSubscriptionTarget", exception);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addSubscriptionTarget", exception);
			subscriptionTypesResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/SubscriptionTypesList", method = RequestMethod.GET)
	public ResponseEntity<SubscriptionTypesListResponseDTO> getAbhTargetByserId() {

		ResponseEntity<SubscriptionTypesListResponseDTO> responseEntity;
		List<SubscriptionTypes> list = new ArrayList<>();
		SubscriptionTypesListResponseDTO subscriptionTypesListResponseDTO = new SubscriptionTypesListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = subscriptionTypesService.getListSubscriptionTypes();
			subscriptionTypesListResponseDTO.setList(list);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/deleteSubscriptionTypes/{subId}", method = RequestMethod.DELETE)
	public ResponseEntity<SubscriptionTypesListResponseDTO> deleteSubscriptionTypes(@PathVariable Long subId) {

		ResponseEntity<SubscriptionTypesListResponseDTO> responseEntity;
		List<SubscriptionTypes> list = new ArrayList<>();
		SubscriptionTypesListResponseDTO subscriptionTypesListResponseDTO = new SubscriptionTypesListResponseDTO();
		try{
			LOGGER.info("In SubscriptionTypesController to delete SubscriptionTypes Request");
			subscriptionTypesService.deleteSubscriptionTypes(subId);
			subscriptionTypesListResponseDTO.setErrorMessage("Record deleted successfully");
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while deleting SubscriptionTypes", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while deleting SubscriptionTypes", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	@RequestMapping(value = "/subscriptionTypes/{subId}", method = RequestMethod.GET)
	public ResponseEntity<SubscriptionTypesListResponseDTO> getSubscriptionTypesBySubId(@PathVariable Long subId) {

		ResponseEntity<SubscriptionTypesListResponseDTO> responseEntity;
		List<SubscriptionTypes> list = new ArrayList<>();
		SubscriptionTypesListResponseDTO subscriptionTypesListResponseDTO = new SubscriptionTypesListResponseDTO();
		try{
			LOGGER.info("In SubscriptionType controller to list subscriptionType");
			list = subscriptionTypesService.getSubscriptionTypeBySubId(subId);
			subscriptionTypesListResponseDTO.setList(list);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing subscriptionTypes", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);

		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing subscriptionTypes", exception);
			subscriptionTypesListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			subscriptionTypesListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(subscriptionTypesListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			subscriptionTypesListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}






}
