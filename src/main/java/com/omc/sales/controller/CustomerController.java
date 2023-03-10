package com.omc.sales.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.omc.sales.dto.PlantListResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.dto.CustomerListResponseDTO;
import com.omc.sales.dto.CustomerResponseDTO;
import com.omc.sales.entity.Customer;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.CustomerService;

/**
 * The Class CustomerController.
 */
@CrossOrigin
@RestController
@RequestMapping("sales")
public class CustomerController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void testUser() 
	{
		LOGGER.info("Test successfull");
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {

		ResponseEntity<CustomerResponseDTO> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try{
			LOGGER.info("In CustomerController for addCustomer Request");
			Long id = customerService.createCustomer(customerDTO);
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


	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> listAll() {

		ResponseEntity<CustomerListResponseDTO> responseEntity;
		List<Customer> list = new ArrayList<>();
		CustomerListResponseDTO customerResponseDTO = new CustomerListResponseDTO();
		try{
			LOGGER.info("In CustomerController for listAll Customers Request");	
			list = customerService.listAllCustomers();
			customerResponseDTO.setList(list);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}


	@RequestMapping(value = { "/customer" }, method = RequestMethod.PUT)
	public ResponseEntity<CustomerResponseDTO>  updateCustomer(@RequestBody CustomerDTO customerDTO) {
		ResponseEntity<CustomerResponseDTO> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try{
			LOGGER.info("In CustomerController for updateCustomer Request");
			Long customerId = customerService.updateCustomer(customerDTO);
			System.out.println("id="+customerId);
			customerResponseDTO.setId(customerId);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
		}  catch(RuntimeException exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;

	}
	
	
	@GetMapping("/getcustomer/{id}")
	public List<Customer> getCustomerById(@PathVariable Long id) {

		ResponseEntity<CustomerListResponseDTO> responseEntity;
		List<Customer> list = new ArrayList<>();
		CustomerListResponseDTO customerResponseDTO = new CustomerListResponseDTO();
		try{
			LOGGER.info("In CustomerController for listAll Customers Request");	
			list = customerService.getCustomerById(id);
			customerResponseDTO.setList(list);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	
	@GetMapping("/getcustomers/{sll}")
	public List<Customer> getCustomerBySll(@PathVariable String sll) {

		ResponseEntity<CustomerListResponseDTO> responseEntity;
		List<Customer> list = new ArrayList<>();
		CustomerListResponseDTO customerResponseDTO = new CustomerListResponseDTO();
		try{
			LOGGER.info("In CustomerController for listAll Customers Request");	
			list = customerService.getCustomerBySll(sll);
			customerResponseDTO.setList(list);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	

	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<CustomerResponseDTO> deletePlant(@PathVariable Long id)
	{
		ResponseEntity<CustomerResponseDTO> response;
		CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
		try
		{
			LOGGER.info("In CUSTOMER Controller for deleting CUSTOMER Request");
			Long plantId=customerService.deleteCustomer(id);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			customerResponseDTO.setId(id);
			response=new ResponseEntity<>(customerResponseDTO,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			LOGGER.warn("Error occured while deleting customer", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response=new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		catch(Exception e)
		{
			LOGGER.warn("Error occurred while deleting customer", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response=new ResponseEntity<>(customerResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
	@GetMapping("/getCustomerByDateRangeStatusPlantIdAndSalesExecutiveId")
	public List<Customer> getCustomerByDateRangeAndStatus(

			@RequestParam(required = false, value="startDate") Timestamp startDate,
			@RequestParam(required = false, value="endDate") Timestamp endDate ,
			@RequestParam(required = false, value="customerStatus") String customerStatus ,
			@RequestParam(required = false, value="plantId") Long[] plantId,
			@RequestParam(required = false, value="salesExecutiveId") Long[] salesExecutiveId
	) {
System.out.println("satyam"+Arrays.toString(salesExecutiveId));
		ResponseEntity<CustomerListResponseDTO> responseEntity;
		List<Customer> list = new ArrayList<>();
		CustomerListResponseDTO customerResponseDTO = new CustomerListResponseDTO();
		try {
			System.out.println("In CustomerController for listAll Customers Request by DateRange");
			list = customerService.getCustomerByDateRangeAndStatus(startDate, endDate, customerStatus, plantId, salesExecutiveId);
			System.out.println("satyam22222"+Arrays.toString(list.toArray()));
			customerResponseDTO.setList(list);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
		} catch (RuntimeException exception) {
			System.out.println("Error occurred while listing customer"+ exception.getMessage());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			System.out.println("Error occurred while listing customer"+ exception.getMessage());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
}
