package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;


import com.omc.sales.dto.*;
import com.omc.sales.entity.*;
import com.omc.sales.repository.SllChannelRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
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

	@Autowired
	private SllChannelRepository sllChannelRepository;


	/**
	 * The Constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);

	@RequestMapping(value = "/poll", method = RequestMethod.POST)
	public ResponseEntity<Object> addPoll(@RequestParam String plantId, @RequestParam String pollNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try {
			LOGGER.info("In PlantPollSllCustomerController for addPoll Request");
			Long id = plantPollSllCustomerService.createPoll(plantId, pollNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
		} catch (BaseException exception) {
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred during runtime adding poll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while adding poll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	@RequestMapping(value = "/updatePoll", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePoll(@RequestParam Long ppId, @RequestParam String plantId, @RequestParam String pollNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

		try{
			LOGGER.info("In PlantPollSllCustomerController for update poll Request");
			Long id = plantPollSllCustomerService.updatePoll(ppId,plantId,pollNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.BAD_REQUEST);

		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime updating poll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating poll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}


	@RequestMapping(value = "/sll", method = RequestMethod.POST)
	public ResponseEntity<Object> addSll(@RequestParam String pollId, @RequestParam String sllNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try {
			LOGGER.info("In PlantPollSllCustomerController for addSll Request");
			Long id = plantPollSllCustomerService.createSll(pollId, sllNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
		} catch (BaseException exception) {
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred during runtime adding sll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while adding sll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}@RequestMapping(value = "/updateSll", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSll(@RequestParam Long psId,@RequestParam String pollId, @RequestParam String sllNumber) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

		try{
			LOGGER.info("In PlantPollSllCustomerController for update sll Request");
			Long id = plantPollSllCustomerService.updateSll(psId,pollId,sllNumber);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(customerResponseDTO,HttpStatus.BAD_REQUEST);

		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime updating sll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating sll", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}


	@RequestMapping(value = "/sllCustomer", method = RequestMethod.POST)
	public ResponseEntity<Object> addSllCustomer(@RequestParam String sllId, @RequestParam String customerId, @RequestParam String channelNo) {

		ResponseEntity<Object> responseEntity;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try {
			LOGGER.info("In PlantPollSllCustomerController for addSllCustomer Request");
			Long id = plantPollSllCustomerService.createSllCustomer(sllId, customerId,channelNo);
			customerResponseDTO.setStatus(HttpStatus.CREATED.value());
			customerResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
		} catch (BaseException exception) {
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			customerResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			customerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.BAD_REQUEST);
			customerResponseDTO.setErrorMessage(exception.getErrorMsg());
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred during runtime adding  SllCustomer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while adding  SLLCustomer", exception);
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/getPollNo", method = RequestMethod.GET)
	public List<PlantPoll> getAllPollNo(@RequestParam String plantId) {

		List<PlantPoll> list = new ArrayList<PlantPoll>();


		list.addAll(plantPollSllCustomerService.getPollNo(plantRepository.findById(Long.valueOf(plantId)).get()));


		return list;
	}


	@RequestMapping(value = "/allPollSll/{plantPoll}", method = RequestMethod.GET)
	public ResponseEntity<PlantPollSllCustomerListDTO> listAllPollSll(@PathVariable PlantPoll plantPoll) {

		ResponseEntity<PlantPollSllCustomerListDTO> responseEntity;
		List<PollSll> list = new ArrayList<>();
		PlantPollSllCustomerListDTO plantPollSllCustomerListDTO = new PlantPollSllCustomerListDTO();
		try {
			LOGGER.info("In PlantPollSllCustomerController for listAll POLL SLL Request");
			list = plantPollSllCustomerService.listAllPollSll(plantPoll);
			plantPollSllCustomerListDTO.setList(list);
			plantPollSllCustomerListDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(plantPollSllCustomerListDTO, HttpStatus.OK);
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred while listing POLL SLL", exception);
			plantPollSllCustomerListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantPollSllCustomerListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantPollSllCustomerListDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(plantPollSllCustomerListDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception exception) {
			LOGGER.warn("Error occurred while listing POLL SLL", exception);
			plantPollSllCustomerListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantPollSllCustomerListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantPollSllCustomerListDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(plantPollSllCustomerListDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	@RequestMapping(value = "/allChannel/{sllId}", method = RequestMethod.GET)
	public ResponseEntity<SllChannelListDTO> listAllChannels(@PathVariable Integer sllId) {

		ResponseEntity<SllChannelListDTO> responseEntity;
		List<SllChannel> list = new ArrayList<>();
		SllChannelListDTO sllChannelListDTO = new SllChannelListDTO();
		try {
			LOGGER.info("In PlantPoll");
			list = plantPollSllCustomerService.listAllChannel(sllId);
			sllChannelListDTO.setList(list);
			sllChannelListDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(sllChannelListDTO, HttpStatus.OK);
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred while listing poll", exception);
			sllChannelListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			sllChannelListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			sllChannelListDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(sllChannelListDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception exception) {
			LOGGER.warn("Error occurred while listing poll", exception);
			sllChannelListDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			sllChannelListDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			sllChannelListDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(sllChannelListDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	@DeleteMapping("/deletePoll/{ppId}")
	public ResponseEntity<CustomerResponseDTO> deletePoll(@PathVariable Long ppId) {
		ResponseEntity<CustomerResponseDTO> response;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try {
			LOGGER.info("In PlantPollSll Controller for deleting POLL Request");
			Long id =plantPollSllCustomerService.deletePoll(ppId);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			customerResponseDTO.setPpId(ppId);
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting poll", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting poll", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
	@DeleteMapping("/deleteSll/{psId}")
	public ResponseEntity<CustomerResponseDTO> deleteSll(@PathVariable Long psId) {
		ResponseEntity<CustomerResponseDTO> response;
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		try {
			LOGGER.info("In PlantPollSll Controller for deleting SLL Request");
			Long id =plantPollSllCustomerService.deleteSll(psId);
			customerResponseDTO.setStatus(HttpStatus.OK.value());
			customerResponseDTO.setPpId(psId);
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting SLL", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting SLL", e);
			customerResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			customerResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(customerResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
	@GetMapping("/getPoll/{ppId}")
	public List<PlantPoll> listAllByPpId(@PathVariable Long ppId) {

		ResponseEntity<PollResponseDT0> responseEntity;
		List<PlantPoll> list = new ArrayList();
		PollResponseDT0 pollResponseDTO = new PollResponseDT0();
		try {
			LOGGER.info("In Plant Controller for list PlantId Request");
			list = plantPollSllCustomerService.listAllByPpId(ppId);
			pollResponseDTO.setList(list);
			pollResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(pollResponseDTO, HttpStatus.OK);

		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			pollResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			pollResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(pollResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			pollResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			pollResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			pollResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(pollResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			pollResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return list;

	}
	@GetMapping("/getSll/{psId}")
	public List<PollSll> listAllByPsId(@PathVariable Long psId) {

		ResponseEntity<SllResponseDTO> responseEntity;
		List<PollSll> list = new ArrayList();
		SllResponseDTO sllResponseDTO = new SllResponseDTO();
		try {
			LOGGER.info("In Plant Controller for list PlantId Request");
			list = plantPollSllCustomerService.listAllByPsId(psId);
			sllResponseDTO.setList(list);
			sllResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(sllResponseDTO, HttpStatus.OK);

		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			sllResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			sllResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(sllResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			sllResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			sllResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			sllResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(sllResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			sllResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return list;

	}
}

