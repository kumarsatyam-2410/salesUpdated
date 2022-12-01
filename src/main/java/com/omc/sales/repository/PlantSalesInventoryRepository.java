package com.omc.sales.repository;

import java.sql.Timestamp;
import java.util.List;

import com.omc.sales.entity.CustomerPaymentDetails;
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


	@Query(value="SELECT * FROM plant_sales_inventory WHERE plant_id IN (:plantId) AND created_by IN (:createBy) AND   updated_on BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<PlantSalesInventory> findPlantSalesInventoryByAllFilters(
			@Param("plantId") Long[] plantId,
			@Param("createBy") Long[] createBy, @Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate);


	@Query (value="SELECT * from plant_sales_inventory ud where ud.created_by in ?1", nativeQuery=true)
	public List<PlantSalesInventory> findPlantSalesInventoryByCreateBy(@Param("createBy") Long[] createBy);


	@Query (value="SELECT * from plant_sales_inventory ud where ud.plant_id in ?1", nativeQuery=true)
	public List<PlantSalesInventory> getPlantSalesInventoryByPlantId(Long[] plantId);


	@Query(value = "from PlantSalesInventory t where updated_on BETWEEN :startDate AND :endDate")
	public List<PlantSalesInventory> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);



	@Query (value="SELECT * from plant_sales_inventory ud where ud.created_by in ?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<PlantSalesInventory> findByPlantIdAndCreateBy(@Param("createBy")Long[] createBy,@Param("plantId")Long[] plantId);


	@Query(value="SELECT * FROM plant_sales_inventory WHERE created_by IN (:createBy) AND updated_on BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<PlantSalesInventory> findPlantSalesInventoryByDateRangeAndCreateBy(
			@Param("createBy") Long[] createBy,
			@Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate );

	@Query(value="SELECT * FROM plant_sales_inventory WHERE plant_id IN (:plantId) AND updated_on BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<PlantSalesInventory> findPlantSalesInventoryByDateRangeAndPlantId(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("plantId") Long[] plantId );



}
