package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.CustomerResponseDTO;
import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PlantUsers;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.repository.PlantRepository;
import com.omc.sales.service.PlantPollSllCustomerService;
import com.omc.sales.service.PlantService;
import com.omc.sales.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("sales")
public class PlantPollSllCustomerController {

	@Autowired
	private PlantPollSllCustomerService plantPollSllCustomerService;

	@Autowired 
	private UserService userService;
	
	@Autowired 
	private PlantRepository plantRepository;


	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);

	@RequestMapping(value = "/poll", method = RequestMethod.POST)
	public ResponseEntity<Object> addPoll(@RequestParam String plantId, @RequestParam String pollNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try{
			LOGGER.info("In CustomerController for addCustomer Request");
			Long id = plantPollSllCustomerService.createPoll(plantId,pollNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/sll", method = RequestMethod.POST)
	public ResponseEntity<Object> addSll(@RequestParam String pollId, @RequestParam String sllNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try{
			LOGGER.info("In CustomerController for addCustomer Request");
			Long id = plantPollSllCustomerService.createSll(pollId,sllNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/sllCustomer", method = RequestMethod.POST)
	public ResponseEntity<Object> addSllCustomer(@RequestParam String sllId, @RequestParam String customerId) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try{
			LOGGER.info("In CustomerController for addCustomer Request");
			Long id = plantPollSllCustomerService.createSllCustomer(sllId,customerId);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/getPollSll", method = RequestMethod.GET)
	public List<PlantPoll> getAllRelatedPollSLL(@RequestParam String plantId) {

		List<PlantPoll> list = new ArrayList<PlantPoll>();
		//Set<PlantUsers>  plantsUsers= userService.getUserById(userId).getPlants();
		//for (PlantUsers plantUser : plantsUsers) {
		list.addAll(plantPollSllCustomerService.getPollSll(plantRepository.findById(Long.valueOf(plantId)).get()));
		//}

		return list;
	}
}
