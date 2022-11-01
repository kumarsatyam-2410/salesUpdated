package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.dto.PlantDTO;
import com.omc.sales.entity.*;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.apache.logging.log4j.LogManager;


import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


@Service
public class PlantService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Autowired
	private PlantUsersRepository plantUsersRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DistrictRepository districtRepository;




	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Plant> listAllPlants(Integer countryId,Integer stateId,Integer districtId) {

		List<Plant> subscrptionEntity = null;

		if(!StringUtils.isEmpty(countryId)&& !StringUtils.isEmpty(stateId)&& !StringUtils.isEmpty(districtId)){
			subscrptionEntity = plantRepository.findByCountryIdAndStateIdAndDistrictId(countryId,stateId,districtId);
		}else if(!StringUtils.isEmpty(stateId)&& !StringUtils.isEmpty(districtId)){
			subscrptionEntity = plantRepository.findByStateIdAndDistrictId(stateId,districtId);
		}else if(!StringUtils.isEmpty(countryId)&& !StringUtils.isEmpty(districtId)){
			subscrptionEntity = plantRepository.findByCountryIdAndDistrictId(countryId,districtId);
		}else if(!StringUtils.isEmpty(countryId)&& !StringUtils.isEmpty(stateId)){
			subscrptionEntity = plantRepository.findByCountryIdAndStateId(countryId,stateId);
		}else if(!StringUtils.isEmpty(countryId)){
			subscrptionEntity = plantRepository.findByCountryId(countryId);
		}else if(!StringUtils.isEmpty(stateId)){
			subscrptionEntity = plantRepository.findByStateId(stateId);
		}else if(!StringUtils.isEmpty(districtId)){
			subscrptionEntity = plantRepository.findByDistrictId(districtId);
		}else{
			subscrptionEntity = plantRepository.findAll();
		}
		return subscrptionEntity;

	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<Plant> getPlantListUser(Long userId) {

		return plantUsersRepository.findPlantByUser(userId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long createPlant(Integer omcId,String name,String country,String state,String district,String type,String remark) throws SSNSQLException {

		Plant plantEntity = new Plant();



		plantEntity.setOmcId(Integer.valueOf(omcId));
		plantEntity.setName(String.valueOf(name));
		plantEntity.setCountry(countryRepository.findById(Integer.valueOf(country)).get());
		plantEntity.setState(stateRepository.findById(Integer.valueOf(state)).get());
		plantEntity.setDistrict(districtRepository.findById(Integer.valueOf(district)).get());
		plantEntity.setType(String.valueOf(type));
		plantEntity.setRemark(String.valueOf(remark));
		plantEntity.setAddedOn(new Timestamp(new Date().getTime()));
		plantEntity.setUpdatedOn(new Timestamp(new Date().getTime()));
		plantRepository.save(plantEntity);


		LOGGER.info("Out createCustomer service with return Value customerId:" + plantEntity.getPlantId());
		return plantEntity.getPlantId();
	}

		@Transactional(propagation=Propagation.REQUIRED)
	public Long deletePlant(Long plantId) {
		LOGGER.info("In deleteSalesInventory  Service"+plantRepository.deleteByPlantId(plantId));
		Long id=plantRepository.deleteByPlantId(plantId);
		return id;

	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Plant> listAllByOmcId(Integer omcId) {

		List<Plant> list=new ArrayList<>();
		Plant plant=plantRepository.findByOmcId(omcId);
		list.add(plant);
		return list;
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updatePlant(Long plantId,Integer omcId,String name,String country,String state,String district,String type,String remark) {
		LOGGER.info("In updatePlant  Service");
		Plant plantEntity = plantRepository.findByPlantId(Long.valueOf(plantId));
		plantEntity.setPlantId(Long.valueOf(plantId));
		plantEntity.setOmcId(Integer.valueOf(omcId));
		plantEntity.setName(String.valueOf(name));
		plantEntity.setCountry(countryRepository.findById(Integer.valueOf(country)).get());
		plantEntity.setDistrict(districtRepository.findById(Integer.valueOf(district)).get());
		plantEntity.setState(stateRepository.findById(Integer.valueOf(state)).get());
		plantEntity.setType(String.valueOf(type));
		plantEntity.setRemark(String.valueOf(remark));
		plantEntity.setAddedOn(new Timestamp(new Date().getTime()));
		plantEntity.setUpdatedOn(new Timestamp(new Date().getTime()));
		plantRepository.save(plantEntity);
		LOGGER.info("Out createCustomer service with return Value customerId:" + plantEntity.getPlantId());
		return plantEntity.getPlantId();

	}








}

