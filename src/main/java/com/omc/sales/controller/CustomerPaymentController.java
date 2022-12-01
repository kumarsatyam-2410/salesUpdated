package com.omc.sales.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.omc.sales.dto.*;
import com.omc.sales.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.omc.sales.entity.CustomerPaymentDetails;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.CustomerPaymentService;

/**
 * The Class CustomerController.
 */
@CrossOrigin
@RestController
@RequestMapping("sales")
public class CustomerPaymentController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(CustomerPaymentController.class);

	@Autowired
	private CustomerPaymentService customerPaymentService;
	
	@RequestMapping(value="/test1", method = RequestMethod.GET)
	public String testUser() 
	{
		LOGGER.info("Test successfull");
		return "Test successfull";
	}
	
	@PostMapping("/addcustomerpayment")
    public ResponseEntity<CustomerPaymentResponseDTO> createCustomerPayment(@RequestBody CustomerPaymentDTO customerPaymentDTO)
    {
    	ResponseEntity<CustomerPaymentResponseDTO> responseEntity;
    	CustomerPaymentResponseDTO customerPaymentResponseDTO = new CustomerPaymentResponseDTO();
    	try
    	{
    		LOGGER.info("In CustomerPaymentController for addCustomer Request");
    		Long id=customerPaymentService.addCustomerPayment(customerPaymentDTO);
    		customerPaymentResponseDTO.setId(id);
    		customerPaymentResponseDTO.setStatus(HttpStatus.CREATED.value());
    		responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.CREATED);
    		
    	}
    	catch(BaseException e)
    	{
    		LOGGER.warn("Exception occur during = " + e.getMessage());
    		customerPaymentResponseDTO.setErrorCode(e.getErrorCode().getCode());
    		customerPaymentResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
    		customerPaymentResponseDTO.setErrorMessage(e.getErrorMsg());
    		responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.BAD_REQUEST);
    	}
    	catch(RuntimeException e)
    	{
    		customerPaymentResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		customerPaymentResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		customerPaymentResponseDTO.setErrorMessage(e.getCause().getMessage());
    		responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	catch(Exception e)
    	{
    		customerPaymentResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		customerPaymentResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
    		customerPaymentResponseDTO.setErrorMessage(e.getCause().getMessage());
    		responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    
		return responseEntity;
    	
    }
	
	/*
	 * @PostMapping("/addcustomerpayment")
	 * ResponseEntity<CustomerPaymentResponseDTO> addCustomerPayment(@RequestBody
	 * CustomerPaymentDTO customerPaymentDTO) {
	 * 
	 * ResponseEntity<CustomerPaymentResponseDTO> responseEntity;
	 * CustomerPaymentResponseDTO customerPaymentResponseDTO = new
	 * CustomerPaymentResponseDTO(); try{
	 * LOGGER.info("In CustomerController for addCustomer Request");
	 * 
	 * try { Long id= CustomerPaymentService.createCustomer(customerPaymentDTO); }
	 * catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * customerPaymentResponseDTO.setStatus(HttpStatus.CREATED.value());
	 * customerPaymentResponseDTO.setId(null); responseEntity = new
	 * ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.CREATED);
	 * }catch(BaseException exception){ LOGGER.warn("Exception occur during = " +
	 * exception.getMessage());
	 * customerPaymentResponseDTO.setErrorCode(exception.getErrorCode().getCode());
	 * customerPaymentResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
	 * responseEntity = new
	 * ResponseEntity<>(customerPaymentResponseDTO,HttpStatus.BAD_REQUEST);
	 * customerPaymentResponseDTO.setErrorMessage(exception.getErrorMsg()); }
	 * catch(RuntimeException exception){
	 * LOGGER.warn("Error occurred during runtime creating customer", exception);
	 * customerPaymentResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()
	 * );
	 * customerPaymentResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
	 * responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,
	 * HttpStatus.INTERNAL_SERVER_ERROR);
	 * customerPaymentResponseDTO.setErrorMessage(exception.getCause().getMessage())
	 * ; } catch(Exception exception){
	 * LOGGER.warn("Error occurred while creating customer", exception);
	 * customerPaymentResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()
	 * );
	 * customerPaymentResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
	 * responseEntity = new ResponseEntity<>(customerPaymentResponseDTO,
	 * HttpStatus.INTERNAL_SERVER_ERROR);
	 * customerPaymentResponseDTO.setErrorMessage(exception.getCause().getMessage())
	 * ; } return responseEntity; }
	 * 
	 */
	@RequestMapping(value = "/allCustomerPayment", method = RequestMethod.GET)
	public List<CustomerPaymentDetails> listAll() {

		ResponseEntity<CustomerPaymentListResponseDTO> responseEntity;
		List<CustomerPaymentDetails> list = new ArrayList<>();
		CustomerPaymentListResponseDTO customerPaymentListResponseDTO = new CustomerPaymentListResponseDTO();
		try{
			LOGGER.info("In CustomerPaymentController for listAll Customers Request");
			list = customerPaymentService.listAllCustomers();
		    customerPaymentListResponseDTO.setList(list);
			customerPaymentListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customer", exception);
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customer", exception);
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	@RequestMapping(value = "/updateCustomerPayment", method = RequestMethod.PUT)
	public ResponseEntity<CustomerPaymentListResponseDTO> updateCustomerPayment(@RequestBody CustomerPaymentDTO customerPaymentDTO) {

		ResponseEntity<CustomerPaymentListResponseDTO> responseEntity;
		CustomerPaymentListResponseDTO customerPaymentListResponseDTO= new CustomerPaymentListResponseDTO();
		try{
			LOGGER.info("In CustomerPaymentController for UpdateCustomerPayment Request");
			Long cpId = customerPaymentService.updateCustomerPayment(customerPaymentDTO);
			customerPaymentListResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerPaymentDTO.setCpId(cpId);
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerPaymentListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerPaymentListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			customerPaymentListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO,HttpStatus.BAD_REQUEST);

		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime updating customerPaymentDetails", exception);
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating customerPaymentDetails", exception);
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	@GetMapping("/getCustomerPaymentDetailsByFilters")
	public List<CustomerPaymentDetails> getCustomerPaymentByFilters(

			@RequestParam(required = false, value="startDate") Timestamp startDate,
			@RequestParam(required = false, value="endDate") Timestamp endDate ,
			@RequestParam(required = false, value="paymentMode") String paymentMode ,
			@RequestParam(required = false, value="plantId") Long[] plantId,
			@RequestParam(required = false, value="paymentReceivedUserId") Long[] paymentReceivedUserId
	) {
		System.out.println("satyam"+ Arrays.toString(paymentReceivedUserId));
		ResponseEntity<CustomerPaymentListResponseDTO> responseEntity;
		List<CustomerPaymentDetails> list = new ArrayList<>();
		CustomerPaymentListResponseDTO  customerPaymentListResponseDTO = new CustomerPaymentListResponseDTO();
		try {
			System.out.println("In CustomerController for listAll Customers Request by DateRange");
			list = customerPaymentService.getCustomerPaymentByFilter(startDate, endDate, paymentMode, plantId, paymentReceivedUserId);
			System.out.println("satyam22222"+Arrays.toString(list.toArray()));
			customerPaymentListResponseDTO.setList(list);
			customerPaymentListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO, HttpStatus.OK);
		} catch (RuntimeException exception) {
			System.out.println("Error occurred while listing customer Payment"+ exception.getMessage());
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			System.out.println("Error occurred while listing customer"+ exception.getMessage());
			customerPaymentListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerPaymentListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerPaymentListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerPaymentListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}


}
