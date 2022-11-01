package com.omc.sales.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.AbhTargetResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.omc.sales.dto.CustomerAcquisitionDTO;
import com.omc.sales.dto.CustomerAcquisitionResponseDTO;
import com.omc.sales.dto.CustomerAcquitionListResponseDTO;
import com.omc.sales.entity.CustomerAcquisition;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.CustomerAcquisitionService;



/**
 * The Class CustomerAcquisitionController.
 */
@CrossOrigin
@RestController
@RequestMapping("sales")
public class CustomerAcquisitionController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerAcquisitionController.class);

	@Autowired
	private CustomerAcquisitionService customerAcquisitionService;
	
	/*
	 * @RequestMapping(value="/test", method = RequestMethod.GET) public void
	 * testUser() { LOGGER.info("Test successfull"); }
	 */

	@RequestMapping(value = "/customerAcquisition", method = RequestMethod.POST)
	public ResponseEntity<CustomerAcquisitionResponseDTO> addCustomerAcquisition(@RequestBody CustomerAcquisitionDTO customerAcquisitionDTO) {

		ResponseEntity<CustomerAcquisitionResponseDTO> responseEntity;
		CustomerAcquisitionResponseDTO customerAcquisitionResponseDTO = new CustomerAcquisitionResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for addCustomerAcquisition Request");
			Long id = customerAcquisitionService.createCustomerAcquisition(customerAcquisitionDTO);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerAcquisitionResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerAcquisitionResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerAcquisitionResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.BAD_REQUEST);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/customerAcquisitions", method = RequestMethod.GET)
	public List<CustomerAcquisition> listAll() {

		ResponseEntity<CustomerAcquitionListResponseDTO> responseEntity;
		List<CustomerAcquisition> list = new ArrayList<>();
		CustomerAcquitionListResponseDTO customerAcquisitionResponseDTO = new CustomerAcquitionListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = customerAcquisitionService.listAllCustomerAcquisitions();
			customerAcquisitionResponseDTO.setList(list);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}


	@RequestMapping(value = { "/customerAcquisition"}, method = RequestMethod.PUT)
	public ResponseEntity<CustomerAcquisitionResponseDTO>  updateCustomerAcquisition(@RequestBody CustomerAcquisitionDTO customerAcquisitionDTO) {
		ResponseEntity<CustomerAcquisitionResponseDTO> responseEntity;
		CustomerAcquisitionResponseDTO customerAcquisitionResponseDTO = new CustomerAcquisitionResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for updateCustomerAcquisition Request");
			Long customerAcquisitionId = customerAcquisitionService.updateCustomerAcquisition(customerAcquisitionDTO);
			customerAcquisitionResponseDTO.setId(customerAcquisitionId);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.OK);
		}  catch(RuntimeException exception){
			LOGGER.warn("Error occurred while updating ", exception);
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating ", exception);
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;

	}
	
	@GetMapping("/getcustomerAcquisition/{id}")
	public List<CustomerAcquisition> getcustomerAcquisitionById(@PathVariable Long id) {

		ResponseEntity<CustomerAcquitionListResponseDTO> responseEntity;
		List<CustomerAcquisition> list = new ArrayList<>();
		CustomerAcquitionListResponseDTO customerAcquisitionResponseDTO = new CustomerAcquitionListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = customerAcquisitionService.CustomerAcquisitionById(id);
			customerAcquisitionResponseDTO.setList(list);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	
	// customerStatus with the help of time
	
	@GetMapping("/getcustomerAcquisitionByTimeAndStatus")
	public List<CustomerAcquisition> getcustomerAcquisitionById(
			@RequestParam(required = false, value="startDate") Timestamp startDate,
			@RequestParam(required = false, value="endDate") Timestamp endDate ,
			@RequestParam(required = false, value="acquisitionStatus") String acquisitionStatus ,
			@RequestParam(required = false, value="offsets") Integer offsets,
			@RequestParam(required = false, value="limits") Integer limits
			) {

		ResponseEntity<CustomerAcquitionListResponseDTO> responseEntity;
		List<CustomerAcquisition> list = new ArrayList<>();
		CustomerAcquitionListResponseDTO customerAcquisitionResponseDTO = new CustomerAcquitionListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = customerAcquisitionService.getcustomerAcquisitionByTimeAndStatus(startDate , endDate , acquisitionStatus ,offsets,limits ) ;
			customerAcquisitionResponseDTO.setList(list);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerAcquisitionResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	@DeleteMapping("/deletecustomeracquisition/{id}")
	public ResponseEntity<CustomerAcquisitionResponseDTO> deleteCustAcq(@PathVariable Long id) {
		ResponseEntity<CustomerAcquisitionResponseDTO> response;
		CustomerAcquisitionResponseDTO customerAcquisitionResponseDTO = new CustomerAcquisitionResponseDTO();
		try {
			LOGGER.info("In custAcq Controller for deleting CustAcq Request");
			Long Id =customerAcquisitionService.deleteCustAcq(id);
			customerAcquisitionResponseDTO.setStatus(HttpStatus.OK.value());
			customerAcquisitionResponseDTO.setId(id);
			response = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting CustAcq", e);
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting CustAcq", e);
			customerAcquisitionResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerAcquisitionResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerAcquisitionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerAcquisitionResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
}
