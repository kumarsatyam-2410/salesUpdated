package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;

import com.omc.sales.dto.CafTableListResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.dto.PackageDTO;
import com.omc.sales.dto.PackageListResponseDTO;
import com.omc.sales.dto.PackageResponseDTO;
import com.omc.sales.entity.Package;
import com.omc.sales.exception.BaseException;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.service.PackageService;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

/**
 * The Class PackageController.
 */
@CrossOrigin
@RestController
@RequestMapping("sales")
public class PackageController {

	/** The Constant logger. */
	private static final Logger LOGGER = LogManager.getLogger(PackageController.class);

	@Autowired
	private PackageService packageService;
	

	@RequestMapping(value = "/package", method = RequestMethod.POST)
	public ResponseEntity<PackageResponseDTO> addPackage(@RequestBody PackageDTO packageDTO) {

		ResponseEntity<PackageResponseDTO> responseEntity;
		PackageResponseDTO packageResponseDTO = new PackageResponseDTO();
		try{
			LOGGER.info("In PackageController for addPackage Request");
			Long id = packageService.createPackage(packageDTO);
			packageResponseDTO.setStatus(HttpStatus.CREATED.value());
			packageResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.CREATED);
		}catch(BaseException exception){
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			packageResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			packageResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.BAD_REQUEST);
			packageResponseDTO.setErrorMessage(exception.getErrorMsg());
		}
		catch(RuntimeException exception){
			LOGGER.warn("Error occurred during runtime creating package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while creating package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}


	@RequestMapping(value = "/packages", method = RequestMethod.GET)
	public List<Package> listAll(@RequestParam String packageType,@RequestParam String billingType ,@RequestParam int closedPackage) {

		ResponseEntity<PackageListResponseDTO> responseEntity;
		List<Package> list = new ArrayList<>();
		PackageListResponseDTO packageResponseDTO = new PackageListResponseDTO();
		try{
			LOGGER.info("In PackageController for listAll Packages Request");	
			list = packageService.listAllPackages(packageType,billingType,closedPackage);
			packageResponseDTO.setList(list);
			packageResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}


	@RequestMapping(value = { "/package" }, method = RequestMethod.PUT)
	public ResponseEntity<PackageResponseDTO>  updatePackage(@RequestBody PackageDTO packageDTO) {
		ResponseEntity<PackageResponseDTO> responseEntity;
		PackageResponseDTO packageResponseDTO = new PackageResponseDTO();
		try{
			LOGGER.info("In PackageController for updatePackage Request");
			Long packageId = packageService.updatePackage(packageDTO);
			packageResponseDTO.setId(packageId);
			packageResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO, HttpStatus.OK);
		}  catch(RuntimeException exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while updating CPOC URL", exception);
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;

	}
	
	@GetMapping("/getpackage/{id}")
	public List<Package> getPackageById(@PathVariable Long id) {

		ResponseEntity<PackageListResponseDTO> responseEntity;
		List<Package> list = new ArrayList<>();
		PackageListResponseDTO packageResponseDTO = new PackageListResponseDTO();
		try{
			LOGGER.info("In PackageController for listAll Packages Request");	
			list = packageService.listAllPackage(id);
			packageResponseDTO.setList(list);
			packageResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return list;
	}
	
	@RequestMapping(value = "/listOfPackages", method = RequestMethod.GET)
	public ResponseEntity<PackageListResponseDTO> listOfPackage() {

		ResponseEntity<PackageListResponseDTO> responseEntity;
		List<Package> list = new ArrayList<>();
		PackageListResponseDTO packageResponseDTO = new PackageListResponseDTO();
		try{
			LOGGER.info("In PackageController for listAll Packages Request");	
			list = packageService.listAllPackages();
			packageResponseDTO.setList(list);
			packageResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing package", exception);
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(packageResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}
	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<PackageResponseDTO> deletePackage(@PathVariable Long id
	) {
		ResponseEntity<PackageResponseDTO> response;
		PackageResponseDTO packageResponseDTO = new PackageResponseDTO();
		try {
			LOGGER.info("In Package  Controller for deleting Package Request");
			Long aid = packageService.deletePackage(id);
			packageResponseDTO.setStatus(HttpStatus.OK.value());
			packageResponseDTO.setId(id);
			response = new ResponseEntity<>(packageResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting Package", e);
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting Package", e);
			packageResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			packageResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(packageResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			packageResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}
}
