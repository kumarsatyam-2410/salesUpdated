package com.omc.sales.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omc.sales.dto.PlantListResponseDTO;
import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantUsers;
import com.omc.sales.service.PlantService;
import com.omc.sales.service.UserService;



/**
 * The Class UserController.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/rms")
public class PlantController {

	/** The Constant logger. */
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



}
