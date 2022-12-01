package com.omc.sales.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.AbhTargetDTO;
import com.omc.sales.dto.AbhTargetListResponseDTO;
import com.omc.sales.dto.AbhTargetResponseDTO;
import com.omc.sales.dto.SalesHeadTargetDTO;
import com.omc.sales.dto.SalesHeadTargetListResponseDTO;
import com.omc.sales.dto.SalesHeadTargetResponseDTO;
import com.omc.sales.entity.AbhTarget;
import com.omc.sales.entity.SalesHeadTarget;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.SalesHeadTargetService;

@RestController
public class SalesHeadTargetController {
	
	private static final Logger LOGGER = LogManager.getLogger(SalesHeadTargetController.class);
	
	@Autowired
	private SalesHeadTargetService salesHeadTargetService;
	
	@RequestMapping(value = "/addSalesHeadTarget", method = RequestMethod.POST)
	public ResponseEntity<SalesHeadTargetResponseDTO> addAbhTarget(@RequestBody SalesHeadTargetDTO salesHeadTargetDTO) {

		ResponseEntity<SalesHeadTargetResponseDTO> responseEntity;
		SalesHeadTargetResponseDTO salesHeadTargetResponseDTO = new SalesHeadTargetResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for addSalesTarget Request");
			Long salesHeadId = salesHeadTargetService.createsalesTarget(salesHeadTargetDTO);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			salesHeadTargetResponseDTO.setSalesHeadId(salesHeadId);
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			salesHeadTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			salesHeadTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addSalesTarget", exception);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addSalesTarget", exception);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}

	@RequestMapping(value = "/updateSalesHeadTarget", method = RequestMethod.PUT)
	public ResponseEntity<SalesHeadTargetResponseDTO> updateAbhTarget(@RequestBody SalesHeadTargetDTO salesHeadTargetDTO) {

		ResponseEntity<SalesHeadTargetResponseDTO> responseEntity;
		SalesHeadTargetResponseDTO salesHeadTargetResponseDTO = new SalesHeadTargetResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for addSalesTarget Request");
			Long salesHeadId = salesHeadTargetService.updateSaleHeadTarget(salesHeadTargetDTO);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.CREATED.value());
			salesHeadTargetResponseDTO.setSalesHeadId(salesHeadId);
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			salesHeadTargetResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			salesHeadTargetResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating addSalesTarget", exception);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating addSalesTarget", exception);
			salesHeadTargetResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getSalesHeadTargetBy/{userId}", method = RequestMethod.GET)
	public ResponseEntity<SalesHeadTargetListResponseDTO> getSalesHeadTargetByUserId(@PathVariable String userId) {

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for find SalesHeadTarget by userId Request");	
			list = salesHeadTargetService.getSalesHeadTargetByUserId(userId);
			salesHeadTargetListResponseDTO.setList(list);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/SalesHeadTarget/{salesHeadId}", method = RequestMethod.GET)
	public ResponseEntity<SalesHeadTargetListResponseDTO> salesHeadTargetBySalesHeadId(@PathVariable Long salesHeadId) {

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for find SalesHeadTarget by salesHeadId Request");	
			list = salesHeadTargetService.getSalesHeadTargetBySalesHeadId1(salesHeadId);
			salesHeadTargetListResponseDTO.setList(list);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/findSalesHeadTarget/{addedBy}", method = RequestMethod.GET)
	public ResponseEntity<SalesHeadTargetListResponseDTO> findSalesHeadTargetByAddedBy(@PathVariable int addedBy) {

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for find SalesHeadTarget by addedBy Request");	
			list = salesHeadTargetService.findSalesHeadTargetByAddedBy(addedBy);
			salesHeadTargetListResponseDTO.setList(list);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getSalesHeadTargetList", method = RequestMethod.GET)
	public ResponseEntity<SalesHeadTargetListResponseDTO> getSalesHeadTargetList() {

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for listAll SalesHeadTarget Request");	
			list = salesHeadTargetService.getSalesHeadTargetList();
			salesHeadTargetListResponseDTO.setList(list);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getSalesHeadTargetByDateRange", method = RequestMethod.GET)
	public ResponseEntity<SalesHeadTargetListResponseDTO> getSalesHeadTargetByDateRanges(	
			@RequestParam Timestamp startDate,
			@RequestParam Timestamp endDate ){

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for list of SalesHeadTarget By DateRange Request");	
			list = salesHeadTargetService.getSalesHeadTargetByDateRange(startDate ,endDate);
			salesHeadTargetListResponseDTO.setList(list);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/deleteSalesHeadTarget/{salesHeadId}", method = RequestMethod.DELETE)
	public ResponseEntity<SalesHeadTargetListResponseDTO> deletesalesHeadTargetBySalesHeadId(@PathVariable Long salesHeadId) {

		ResponseEntity<SalesHeadTargetListResponseDTO> responseEntity;
		List<SalesHeadTarget> list = new ArrayList<>();
		SalesHeadTargetListResponseDTO salesHeadTargetListResponseDTO = new SalesHeadTargetListResponseDTO();
		try{
			LOGGER.info("In SalesHeadTargetController for find SalesHeadTarget by salesHeadId Request");	
			salesHeadTargetService.deletesalesHeadTargetBySalesHeadId(salesHeadId);
			salesHeadTargetListResponseDTO.setErrorMessage("Record deleted successfully");
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while deleting SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(Exception exception){
			LOGGER.warn("Error occurred while deleting SalesHeadTarget", exception);
			salesHeadTargetListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			salesHeadTargetListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(salesHeadTargetListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			salesHeadTargetListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	

	
	
	
}
