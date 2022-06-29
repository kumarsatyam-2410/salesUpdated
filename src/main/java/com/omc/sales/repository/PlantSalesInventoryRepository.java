package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.PlantSalesInventory;
@Repository
public interface PlantSalesInventoryRepository extends JpaRepository<PlantSalesInventory,Long>{

	public PlantSalesInventory findByUserId(Long userID);
	public Long deleteByUserId(Long userId);
	public PlantSalesInventory findByPlantId(int plantId);
	
	

}
