package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.omc.sales.dto.*;
import com.omc.sales.entity.*;
import com.omc.sales.exception.BaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.repository.PlantUsersRepository;
import com.omc.sales.service.PlantService;
import com.omc.sales.service.UserService;



/**
 * The Class UserController.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/rms")
public class PlantController {

	/**
	 * The Constant logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(PlantController.class);

	@Autowired
	private PlantService plantService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/plants", method = RequestMethod.GET)
	public ResponseEntity<PlantListResponseDTO> listAllPlants(@RequestParam(required = false, value="countryId") Integer countryId,
															  @RequestParam(required = false, value="stateId") Integer stateId,
															  @RequestParam(required = false, value="districtId") Integer districtId,
															  @RequestParam(required = false, value="userId") String userId)
	{


		ResponseEntity<PlantListResponseDTO> responseEntity;
		List<Plant> list = new ArrayList<>();
		PlantListResponseDTO planResponseDTO = new PlantListResponseDTO();
		try{
			LOGGER.info("In PlantController for listAll plants ");
			if(userId !=null ) {
				Set<PlantUsers>  plantsUsers= userService.getUserById(userId).getPlants();
				for (PlantUsers plantUser : plantsUsers) {
					list.add(plantUser.getPlant());
				}
			}else {
				list = plantService.listAllPlants(countryId,stateId,districtId);
			}
			planResponseDTO.setList(list);
			responseEntity = new ResponseEntity<>(planResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing plants", exception);
			responseEntity = new ResponseEntity<>(planResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing plants", exception);
			responseEntity = new ResponseEntity<>(planResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@RequestMapping(value = "/plantList/{userId}", method = RequestMethod.GET)
	public ResponseEntity<PlantListResponseDTO> getplantListById(@PathVariable Long userId) {

		ResponseEntity<PlantListResponseDTO> responseEntity;
		List<Plant> list = new ArrayList<>();
		PlantListResponseDTO plantListResponseDTO = new PlantListResponseDTO();
		try{
			LOGGER.info("In PlantController for listAll plant Request");
			list = plantService.getPlantListUser(userId);
			plantListResponseDTO.setList(list);
			plantListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(plantListResponseDTO,HttpStatus.OK);
		}  catch(RuntimeException exception) {
			LOGGER.warn("Error occurred while listing plants", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
			responseEntity = new ResponseEntity<>(plantListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);

		} catch(Exception exception){
			LOGGER.warn("Error occurred while listing plants", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;
	}



	@DeleteMapping("/deleteplant/{plantId}")
	public ResponseEntity<PlantListResponseDTO> deletePlant(@PathVariable Long plantId) {
		ResponseEntity<PlantListResponseDTO> response;
		PlantListResponseDTO plantListResponseDTO = new PlantListResponseDTO();
		try {
			LOGGER.info("In Plant Controller for deleting Plant Request");
			Long id = plantService.deletePlant(plantId);
			plantListResponseDTO.setStatus(HttpStatus.OK.value());
			plantListResponseDTO.setPlantId(plantId);
			response = new ResponseEntity<>(plantListResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while deleting plant", e);
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while deleting plant", e);
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return response;

	}

	@GetMapping("/getplantId/{omcId}")
	public List<Plant> listAllByOmcId(@PathVariable Integer omcId) {

		ResponseEntity<PlantListResponseDTO> responseEntity;
		List<Plant> list = new ArrayList();
		PlantListResponseDTO plantListResponseDTO = new PlantListResponseDTO();
		try {
			LOGGER.info("In Plant Controller for list PlantId Request");
			list = plantService.listAllByOmcId(omcId);
			plantListResponseDTO.setList(list);
			plantListResponseDTO.setStatus(HttpStatus.OK.value());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.OK);

		} catch (RuntimeException e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(e.getCause().getMessage());
		} catch (Exception e) {
			LOGGER.warn("Error occurred while listing Plant", e);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(e.getCause().getMessage());
		}
		return list;

	}

	@RequestMapping(value = "/addplants", method = RequestMethod.POST)
	public ResponseEntity<Object> addPlant( @RequestParam Integer omcId, @RequestParam String name, @RequestParam String countryId, @RequestParam String stateId,
										 @RequestParam String districtId, @RequestParam String type, @RequestParam String remark) {

		ResponseEntity<Object> responseEntity;
		PlantListResponseDTO plantListResponseDTO = new PlantListResponseDTO();
		try {
			LOGGER.info("In PlantController for addCustomer Request");
			Long id = plantService.createPlant( omcId, name, countryId, stateId, districtId, type, remark);
			plantListResponseDTO.setStatus(HttpStatus.CREATED.value());
			plantListResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.CREATED);
		} catch (BaseException exception) {
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			plantListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			plantListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.BAD_REQUEST);
			plantListResponseDTO.setErrorMessage(exception.getErrorMsg());
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred during runtime creating plant", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while creating plant", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;


	}

	@RequestMapping(value = { "/updateplant" }, method = RequestMethod.PUT)
	public ResponseEntity<PlantListResponseDTO>  updatePlant(@RequestParam Long plantId,@RequestParam Integer omcId, @RequestParam String name, @RequestParam String country, @RequestParam String state,
															 @RequestParam String district, @RequestParam String type, @RequestParam String remark) {
		ResponseEntity<PlantListResponseDTO> responseEntity;
		PlantListResponseDTO plantListResponseDTO = new PlantListResponseDTO();
		try{
			LOGGER.info("In PlantController for update Request");
			Long id = plantService.updatePlant( plantId,omcId, name, country, state, district, type, remark);
			System.out.println("id="+plantId);
			plantListResponseDTO.setStatus(HttpStatus.CREATED.value());
			plantListResponseDTO.setId(id);
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.CREATED);
		} catch (BaseException exception) {
			LOGGER.warn("Exception occur during = " + exception.getMessage());
			plantListResponseDTO.setErrorCode(exception.getErrorCode().getCode());
			plantListResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.BAD_REQUEST);
			plantListResponseDTO.setErrorMessage(exception.getErrorMsg());
		} catch (RuntimeException exception) {
			LOGGER.warn("Error occurred during runtime updating plant", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		} catch (Exception exception) {
			LOGGER.warn("Error occurred while updating plant", exception);
			plantListResponseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			plantListResponseDTO.setErrorCode(ErrorCodes.GENERAL_ERROR.getCode());
			responseEntity = new ResponseEntity<>(plantListResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			plantListResponseDTO.setErrorMessage(exception.getCause().getMessage());
		}
		return responseEntity;


	}

}
