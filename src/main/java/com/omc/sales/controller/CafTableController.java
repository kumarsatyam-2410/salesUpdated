package com.omc.sales.controller;
import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.PlantListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.dto.CafTableDTO;
import com.omc.sales.dto.CafTableListResponseDTO;
import com.omc.sales.dto.CafTableResponseDTO;
import com.omc.sales.entity.CafTable;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.CafTableService;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@CrossOrigin
@RestController
public class CafTableController {
	
	@Autowired
	private CafTableService cafTableService;
	
	@RequestMapping(value = "/update-caf", method = RequestMethod.PUT)
	public ResponseEntity<CafTableResponseDTO> updateCafTable(@RequestBody CafTableDTO cafTableDTO) {

		ResponseEntity<CafTableResponseDTO> responseEntity;
		CafTableResponseDTO cafTableResponseDTO = new CafTableResponseDTO();
		try{
			String cafNo= cafTableService.createCafNo(cafTableDTO);
			 cafTableResponseDTO.setStatus(HttpStatus.CREATED.value());
			 cafTableResponseDTO.setCafNo(cafNo);
			responseEntity = new ResponseEntity<>(cafTableResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			cafTableResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			cafTableResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO,HttpStatus.BAD_REQUEST);
			cafTableResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			cafTableResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			cafTableResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/get_caf_number", method = RequestMethod.GET)
	public ResponseEntity<CafTableListResponseDTO> getCafNumber(@RequestParam int plantId,@RequestParam String billingType) {

		ResponseEntity<CafTableListResponseDTO> responseEntity;
		List<CafTable> list=new ArrayList<>();
		CafTableListResponseDTO cafTableListResponseDTO = new CafTableListResponseDTO();
		try{
			list =cafTableService.getCafTable(plantId,billingType);
			cafTableListResponseDTO.setStatus(HttpStatus.CREATED.value());
			cafTableListResponseDTO.setList(list);
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			cafTableListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			cafTableListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			cafTableListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			cafTableListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getListcafNumber", method = RequestMethod.GET)
	public ResponseEntity<CafTableListResponseDTO> getListCafNumber() {

		ResponseEntity<CafTableListResponseDTO> responseEntity;
		List<CafTable> list=new ArrayList<>();
		CafTableListResponseDTO cafTableListResponseDTO = new CafTableListResponseDTO();
		try{
			list =cafTableService.getListCafNumber();
			cafTableListResponseDTO.setStatus(HttpStatus.CREATED.value());
			cafTableListResponseDTO.setList(list);
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			cafTableListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			cafTableListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			cafTableListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			cafTableListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/createCafNumber", method = RequestMethod.POST)
	public ResponseEntity<CafTableResponseDTO> createCafTables(@RequestBody CafTableDTO cafTableDTO) {

		ResponseEntity<CafTableResponseDTO> responseEntity;
		CafTableResponseDTO cafTableResponseDTO = new CafTableResponseDTO();
		try{
			String cafNo= cafTableService.createCafTables(cafTableDTO);
			 cafTableResponseDTO.setStatus(HttpStatus.CREATED.value());
			 cafTableResponseDTO.setCafNo(cafNo);
			responseEntity = new ResponseEntity<>(cafTableResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			cafTableResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			cafTableResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO,HttpStatus.BAD_REQUEST);
			cafTableResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			cafTableResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			cafTableResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(cafTableResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/getCafNumberById", method = RequestMethod.GET)
	public ResponseEntity<CafTableListResponseDTO> getCafNumber(@RequestParam Long id) {

		ResponseEntity<CafTableListResponseDTO> responseEntity;
		List<CafTable> list=new ArrayList<>();
		CafTableListResponseDTO cafTableListResponseDTO = new CafTableListResponseDTO();
		try{
			list =cafTableService.getCafTable(id);
			cafTableListResponseDTO.setStatus(HttpStatus.CREATED.value());
			cafTableListResponseDTO.setList(list);
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			cafTableListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			cafTableListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			cafTableListResponseDTO.setErrorMessage(exception.getErrorMsg());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO,HttpStatus.BAD_REQUEST);
			
		}
		catch(RuntimeException exception){
			cafTableListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cafTableListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);	
		} catch(Exception exception){
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			cafTableListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return responseEntity;
	}
	@DeleteMapping("/deleteCafTable/{id}")
	public ResponseEntity<CafTableListResponseDTO> deleteCafTable(@PathVariable Long id
	) {
		ResponseEntity<CafTableListResponseDTO> response;
		CafTableListResponseDTO cafTableListResponseDTO = new CafTableListResponseDTO();
		try {
			LOGGER.info("In CafTable  Controller for deleting CafTable Request");
			Long aid = cafTableService.deleteCafTable(id);
			cafTableListResponseDTO.setStatus(HttpStatus.OK.value());
			cafTableListResponseDTO.setId(id);
			response = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting CafTable", e);
			cafTableListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			cafTableListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableListResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting plant", e);
			cafTableListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			cafTableListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(cafTableListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			cafTableListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
	
}
