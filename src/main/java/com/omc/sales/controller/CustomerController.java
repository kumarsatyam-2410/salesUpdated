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
}
