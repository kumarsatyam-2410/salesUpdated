package com.omc.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.omc.sales.entity.Plant;
import com.omc.sales.entity.User;
import com.omc.sales.repository.PlantRepository;
import com.omc.sales.repository.PlantUsersRepository;


@Service
public class PlantService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Autowired
	private PlantUsersRepository plantUsersRepository;
	
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
}
