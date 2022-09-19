package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.AbhTargetDTO;
import com.omc.sales.dto.AbhTargetResponseDTO;
import com.omc.sales.dto.ChurnCustomerDTO;
import com.omc.sales.dto.ChurnCustomerResponseDTO;
import com.omc.sales.dto.ChurnUserListResponseDTO;
import com.omc.sales.dto.RevenueCollectionTargetDTO;
import com.omc.sales.dto.RevenueCollectionTargetListResponseDTO;
import com.omc.sales.dto.RevenueCollectionTargetResponseDTO;
import com.omc.sales.entity.ChurnCustomer;
import com.omc.sales.entity.RevenueCollectionTarget;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.AbhTargetService;
import com.omc.sales.service.RevenueCollectionTargetService;

@CrossOrigin
@RestController
public class RevenueCollectionTargetController {
	
private static final Logger LOGGER = LogManager.getLogger(RevenueCollectionTargetController.class);
	
        @Autowired
       private RevenueCollectionTargetService revenueCollectionTargetService;
	
	
	@RequestMapping(value = "/revenueCollectionTargeCreation", method = RequestMethod.POST)
	public ResponseEntity<RevenueCollectionTargetResponseDTO> addRevenueCollectionTarge(@RequestBody RevenueCollectionTargetDTO revenueCollectionTargetDTO) {

		ResponseEntity<RevenueCollectionTargetResponseDTO> responseEntity;
		RevenueCollectionTargetResponseDTO revenueCollectionTargetResponseDTO = new RevenueCollectionTargetResponseDTO();
		try{
			LOGGER.info("In AbhTargetController for addAbhTarget Request");
			Long rctId = revenueCollectionTargetService.createRevenueCollectionTarget(revenueCollectionTargetDTO);
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			revenueCollectionTargetResponseDTO.setRctId(rctId);
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			revenueCollectionTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addAbhTarget", exception);
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addAbhTarget", exception);
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/updateRevenueCollectionTarget", method = RequestMethod.PUT)
	public ResponseEntity<RevenueCollectionTargetResponseDTO> updateChurnCustomer(@RequestBody RevenueCollectionTargetDTO revenueCollectionTargetDTO) {

		ResponseEntity<RevenueCollectionTargetResponseDTO> responseEntity;
		RevenueCollectionTargetResponseDTO revenueCollectionTargetResponseDTO = new RevenueCollectionTargetResponseDTO();
		try{
			LOGGER.info("In AbhTargetController for updateAbhTarget Request");
		Long rctId= revenueCollectionTargetService.updateRevenueCollectionTarget(revenueCollectionTargetDTO);
		revenueCollectionTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
		revenueCollectionTargetResponseDTO.setRctId(rctId);
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			revenueCollectionTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating updateAbhTarget", exception);
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating updateAbhTarget", exception);
			revenueCollectionTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/revenueCollectionTarget/{userId}", method = RequestMethod.GET)
	public ResponseEntity<RevenueCollectionTargetListResponseDTO> getRevenueCollectionTargetByserId(@PathVariable int userId) {

		ResponseEntity<RevenueCollectionTargetListResponseDTO> responseEntity;
		List<RevenueCollectionTarget> list = new ArrayList<>();
		RevenueCollectionTargetListResponseDTO revenueCollectionTargetListResponseDTO = new RevenueCollectionTargetListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = revenueCollectionTargetService.getRevenueCollectionTargetByserId(userId);
			revenueCollectionTargetListResponseDTO.setList(list);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getListrevenueCollectionTarget/", method = RequestMethod.GET)
	public ResponseEntity<RevenueCollectionTargetListResponseDTO> getListrevenueCollectionTarget() {

		ResponseEntity<RevenueCollectionTargetListResponseDTO> responseEntity;
		List<RevenueCollectionTarget> list = new ArrayList<>();
		RevenueCollectionTargetListResponseDTO revenueCollectionTargetListResponseDTO = new RevenueCollectionTargetListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = revenueCollectionTargetService.getListrevenueCollectionTarget();
			revenueCollectionTargetListResponseDTO.setList(list);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	

	@RequestMapping(value = "/listRevenueCollectionTarget/{addedBy}", method = RequestMethod.GET)
	public ResponseEntity<RevenueCollectionTargetListResponseDTO> getRevenueCollectionTargetByAddedBy(@PathVariable int addedBy) {

		ResponseEntity<RevenueCollectionTargetListResponseDTO> responseEntity;
		List<RevenueCollectionTarget> list = new ArrayList<>();
		RevenueCollectionTargetListResponseDTO revenueCollectionTargetListResponseDTO = new RevenueCollectionTargetListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = revenueCollectionTargetService.getRevenueCollectionTargetByAddedBy(addedBy);
			revenueCollectionTargetListResponseDTO.setList(list);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getRevenueCollectionTarget/{rctId}", method = RequestMethod.GET)
	public ResponseEntity<RevenueCollectionTargetListResponseDTO> getRevenueCollectionTargetByserId(@PathVariable Long rctId) {

		ResponseEntity<RevenueCollectionTargetListResponseDTO> responseEntity;
		List<RevenueCollectionTarget> list = new ArrayList<>();
		RevenueCollectionTargetListResponseDTO revenueCollectionTargetListResponseDTO = new RevenueCollectionTargetListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = revenueCollectionTargetService.getRevenueCollectionTargetByserId(rctId);
			revenueCollectionTargetListResponseDTO.setList(list);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			revenueCollectionTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			revenueCollectionTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(revenueCollectionTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			revenueCollectionTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
}
