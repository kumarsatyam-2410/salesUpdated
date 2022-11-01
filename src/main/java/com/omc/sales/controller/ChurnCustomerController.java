package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.CafTableDTO;
import com.omc.sales.dto.CafTableResponseDTO;
import com.omc.sales.dto.ChurnCustomerDTO;
import com.omc.sales.dto.ChurnCustomerResponseDTO;
import com.omc.sales.dto.ChurnUserListResponseDTO;
import com.omc.sales.dto.CustomerAcquitionListResponseDTO;
import com.omc.sales.entity.ChurnCustomer;
import com.omc.sales.entity.CustomerAcquisition;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.ChurnCustomerService;


@CrossOrigin
@RestController
public class ChurnCustomerController {
	
	private static final Logger LOGGER = LogManager.getLogger(ChurnCustomerController.class);
	
	@Autowired
	private ChurnCustomerService churnCustomerService;
	
	@RequestMapping(value = "/churnUserCreation", method = RequestMethod.POST)
	public ResponseEntity<ChurnCustomerResponseDTO> addCustomer(@RequestBody ChurnCustomerDTO churnCustomerDTO) {

		ResponseEntity<ChurnCustomerResponseDTO> responseEntity;
		ChurnCustomerResponseDTO churnCustomerResponseDTO = new ChurnCustomerResponseDTO();
		try{
			LOGGER.info("In ChurnCustomerController for addChrunCustomer Request");
			Long id = churnCustomerService.createChurnUser(churnCustomerDTO);
			churnCustomerResponseDTO.setStatus(HttpStatus.CREATED.value());
			churnCustomerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			churnCustomerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			churnCustomerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			churnCustomerResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating ChrunCustomer", exception);
			churnCustomerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnCustomerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			churnCustomerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating ChrunCustomer", exception);
			churnCustomerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnCustomerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			churnCustomerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/churnCustomer", method = RequestMethod.GET)
	public ResponseEntity<ChurnUserListResponseDTO> listAll() {

		ResponseEntity<ChurnUserListResponseDTO> responseEntity;
		List<ChurnCustomer> list = new ArrayList<>();
		ChurnUserListResponseDTO churnUserListResponseDTO = new ChurnUserListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll ChurnCustomer Request");
			list = churnCustomerService.listAllChurnCustomer();
			churnUserListResponseDTO.setList(list);
			churnUserListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(churnUserListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing ChurnCustomer", exception);
			churnUserListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnUserListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(churnUserListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			churnUserListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing ChurnCustomer", exception);
			churnUserListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnUserListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(churnUserListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			churnUserListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/churnCustomerUpdate", method = RequestMethod.PUT)
	public ResponseEntity<ChurnCustomerResponseDTO> updateChurnCustomer(@RequestBody ChurnCustomerDTO churnCustomerDTO) {

		ResponseEntity<ChurnCustomerResponseDTO> responseEntity;
		ChurnCustomerResponseDTO churnCustomerResponseDTO = new ChurnCustomerResponseDTO();
		try{
		Long id= churnCustomerService.updateChurnCustomer(churnCustomerDTO);
			churnCustomerResponseDTO.setStatus(HttpStatus.CREATED.value());
			churnCustomerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			churnCustomerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			churnCustomerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			churnCustomerResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			churnCustomerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnCustomerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			churnCustomerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			churnCustomerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			churnCustomerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			churnCustomerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(churnCustomerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	

}
