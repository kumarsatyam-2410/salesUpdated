package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.entity.AbhTarget;
import com.omc.sales.entity.RevenueCollectionTarget;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.AbhTargetService;

@CrossOrigin
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
			LOGGER.info("In AbhTargetController for UpdateAbhTarget Request");
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
			LOGGER.warn("Error occurred during runtime updating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating addAbhTarget", exception);
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/abhTarget/{userId}", method = RequestMethod.GET)
	public ResponseEntity<AbhTargetListResponseDTO> getAbhTargetByUserId(@PathVariable String userId) {

		ResponseEntity<AbhTargetListResponseDTO> responseEntity;
		List<AbhTarget> list = new ArrayList<>();
		AbhTargetListResponseDTO abhTargetListResponseDTO = new AbhTargetListResponseDTO();
		try{
			LOGGER.info("In ABHTargetController for listAll ABHTarget Request");
			list = abhTargetService.getAbhTargetByUserId(userId);
			abhTargetListResponseDTO.setList(list);
			abhTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getListAbhTarget", method = RequestMethod.GET)
	public ResponseEntity<AbhTargetListResponseDTO> getListAbhTarget() {

		ResponseEntity<AbhTargetListResponseDTO> responseEntity;
		List<AbhTarget> list = new ArrayList<>();
		AbhTargetListResponseDTO abhTargetListResponseDTO = new AbhTargetListResponseDTO();
		try{
			LOGGER.info("In ANHTargetController for listAll CustomerAcquisitions Request");
			list = abhTargetService.getListAbhTarget();
			abhTargetListResponseDTO.setList(list);
			abhTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	

	@RequestMapping(value = "/getAbhTargetByAddedBy/{addedBy}", method = RequestMethod.GET)
	public ResponseEntity<AbhTargetListResponseDTO> getAbhTargetByAddedBy(@PathVariable int addedBy) {

		ResponseEntity<AbhTargetListResponseDTO> responseEntity;
		List<AbhTarget> list = new ArrayList<>();
		AbhTargetListResponseDTO abhTargetListResponseDTO = new AbhTargetListResponseDTO();
		try{
			LOGGER.info("In ABHTargetController for listAll ABHTarget Request");
			list = abhTargetService.getAbhTargetByAddedBy(addedBy);
			abhTargetListResponseDTO.setList(list);
			abhTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	

	@RequestMapping(value = "/getabhTarget/{abhId}", method = RequestMethod.GET)
	public ResponseEntity<AbhTargetListResponseDTO> getAbhTargetById(@PathVariable Long abhId) {

		ResponseEntity<AbhTargetListResponseDTO> responseEntity;
		List<AbhTarget> list = new ArrayList<>();
		AbhTargetListResponseDTO abhTargetListResponseDTO = new AbhTargetListResponseDTO();
		try{
			LOGGER.info("In ABHTargetController for listAll ABH Target Request");
			list = abhTargetService.getAbhTargetById(abhId);
			abhTargetListResponseDTO.setList(list);
			abhTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing ABHTarget", exception);
			abhTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			abhTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(abhTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	@DeleteMapping("/deleteabhtarget/{abhId}")
	public ResponseEntity<AbhTargetResponseDTO> deleteAbhTarget(@PathVariable Long abhId) {
		ResponseEntity<AbhTargetResponseDTO> response;
		AbhTargetResponseDTO abhTargetResponseDTO = new AbhTargetResponseDTO();
		try {
			LOGGER.info("In Abh Controller for deleting Abh Request");
			Long id =abhTargetService.deleteAbhTarget(abhId);
			abhTargetResponseDTO.setStatus(HttpStatus.OK.value());
			abhTargetResponseDTO.setAbhId(abhId);
			response = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting ABH TARGET", e);
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting ABH Target", e);
			abhTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			abhTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(abhTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			abhTargetResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}

}
