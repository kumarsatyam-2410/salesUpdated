package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.omc.sales.dto.AbhTargetDTO;
import com.omc.sales.dto.AbhTargetListResponseDTO;
import com.omc.sales.dto.AbhTargetResponseDTO;
import com.omc.sales.dto.ChurnCustomerDTO;
import com.omc.sales.dto.ChurnCustomerResponseDTO;
import com.omc.sales.dto.RevenueCollectionTargetListResponseDTO;
import com.omc.sales.entity.AbhTarget;
import com.omc.sales.entity.RevenueCollectionTarget;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.AbhTargetService;

@RestController
public class AbhTargetController {
	
	private static final Logger LOGGER = LogManager.getLogger(AbhTargetController.class);
	
	@Autowired
	private AbhTargetService abhTargetService;
	
	@RequestMapping(value = "/AbhTargetController", method = RequestMethod.POST)
	public ResponseEntity<AbhTargetResponseDTO> addAbhTarget(@RequestBody AbhTargetDTO abhTargetDTO) {

		ResponseEntity<AbhTargetResponseDTO> responseEntity;
		AbhTargetResponseDTO abhTargetResponseDTO = new AbhTargetResponseDTO();
		try{
			LOGGER.info("In AbhTargetController for addAbhTarget Request");
			Long abhId = abhTargetService.createAbhTarget(abhTargetDTO);
			abhTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			abhTargetResponseDTO.setAbhId(abhId);
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			abhTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			abhTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			abhTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/updateTargetController", method = RequestMethod.PUT)
	public ResponseEntity<AbhTargetResponseDTO> updateAbhTarget(@RequestBody AbhTargetDTO abhTargetDTO) {

		ResponseEntity<AbhTargetResponseDTO> responseEntity;
		AbhTargetResponseDTO abhTargetResponseDTO = new AbhTargetResponseDTO();
		try{
			LOGGER.info("In AbhTargetController for addAbhTarget Request");
			Long abhId = abhTargetService.updateAbhTarget(abhTargetDTO);
			abhTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			abhTargetResponseDTO.setAbhId(abhId);
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			abhTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			abhTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			abhTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/abhTarget/{userId}", method = RequestMethod.GET)
	public ResponseEntity<AbhTargetListResponseDTO> getAbhTargetByserId(@PathVariable String userId) {

		ResponseEntity<AbhTargetListResponseDTO> responseEntity;
		List<AbhTarget> list = new ArrayList<>();
		AbhTargetListResponseDTO abhTargetListResponseDTO = new AbhTargetListResponseDTO();
		try{
			LOGGER.info("In CustomerAcquisitionController for listAll CustomerAcquisitions Request");	
			list = abhTargetService.getAbhTargetByserId(userId);
			abhTargetListResponseDTO.setList(list);
			abhTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing customerAcquisition", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	



}
