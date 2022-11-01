package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.PlantSalesInventory;
import com.omc.sales.entity.User;
@Repository
public interface PlantSalesInventoryRepository extends JpaRepository<PlantSalesInventory,Long>{

	//public PlantSalesInventory findByUserId(Long inventoryId);
	public Long deleteByInventoryId(Long inventoryId);
	public PlantSalesInventory findByPlantId(int plantId);
	public PlantSalesInventory findByInventoryId(Long inventoryId);
	
	
	@Query(value = "SELECT * FROM plant_sales_inventory WHERE created_by=:userId", nativeQuery = true)
	public List<PlantSalesInventory> findJoinQuery(@Param("userId") int userId);
	public List<PlantSalesInventory> findAllByOrderByInventoryIdDesc();
	

}
