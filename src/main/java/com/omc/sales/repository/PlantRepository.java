package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Plant;




/**
 * The Interface UsersRepository.
 */
@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {


	public List<Plant> findByCountryId(Integer countryId);

	public Long deleteByPlantId(Long plantId);

	public List<Plant> findByStateId(Integer stateId);

	public List<Plant> findByDistrictId(Integer districtId);


	public List<Plant> findByCountryIdAndStateIdAndDistrictId(Integer countryId,Integer stateId,Integer districtId);

	public List<Plant> findByStateIdAndDistrictId(Integer stateId,Integer districtId);

	public List<Plant> findByCountryIdAndDistrictId(Integer countryId,Integer districtId);
	
	public List<Plant> findByCountryIdAndStateId(Integer countryId,Integer stateId);

	public Plant findByOmcId(Integer omcId);

	public Plant findByPlantId(Long plantId);



}
