package com.omc.sales.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.omc.sales.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.CustomerAcquisition;

import antlr.ASdebug.TokenOffsetInfo;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerAcquisitionRepository extends JpaRepository<CustomerAcquisition, Long> {

	Object offset = null;
	Object limit = null;


	public CustomerAcquisition findByCustomerName(String customerName);
	public CustomerAcquisition findAllById(Long id);
	public List<CustomerAcquisition> getAllCustomerAcquisitionByid(Long id);
	
	public List<CustomerAcquisition> findAllByOrderByIdDesc();
	
	//@Query("SELECT AVG(avgBattChgPowerKw) AS avgBattChgPowerKw,SUBSTRING(eventTimeStamp,1,13) AS eventTimestamp_hh, omcId, plantId FROM Dg WHERE omcId =:omcId AND eventTimeStamp>=:statTime and eventTimeStamp<=:endTime GROUP BY  eventTimestamp_hh,  omcId ,plantId ORDER BY omcId,eventTimestamp_hh")
	//public List<CustomerAcquisition> findAllByOmcIdAndAcquisitionStatusAndStatTimeAndAndEndTime(@Param("acquisitionStatus") String acquisitionStatus, @Param("statTime") Timestamp statTime, @Param("endTime") Timestamp endTime );
	
//	public Minigrid findTopByOmcIdOrderByEventTimeStampDesc(int omcId);
//
//	List<User> findTop10ByLastname(String lastname, Pageable pageable);

	//public CustomerAcquisition findTopOrderByPlantIdDesc();
	
	@Query(value = "from CustomerAcquisition t where subscription_start_date BETWEEN :startDate AND :endDate")
	public List<CustomerAcquisition> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);

	@Query (value="SELECT * from customers_acquisition ud where ud.plant_id in ?1", nativeQuery=true)
	public List<CustomerAcquisition> getCustomerByPlantId(Long[] plantId);

	@Query (value="SELECT * from customers_acquisition ud where ud.sales_executive_id in ?1", nativeQuery=true)
	public List<CustomerAcquisition> findCustomerBySalesExecutiveId(@Param("saleExecutiveId") Long[] salesExecutiveId);

	
	  @Query(value="SELECT  * FROM `customers_acquisition` WHERE acquisition_status =:acquisitionStatus AND (subscription_start_date BETWEEN :startDate AND :endDate)" ,nativeQuery = true)
	public List<CustomerAcquisition> findSubscriptionStartDateBetweenAndAcquisitionStatus(
            @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate, @Param("acquisitionStatus") String acquisitionStatus);

	public List<CustomerAcquisition> findByAcquisitionStatus(String acquisitionStatus);

	@Query(value="SELECT * FROM customers_acquisition WHERE plant_id IN (:plantId) AND sales_executive_id IN (:salesExecutiveId) AND acquisition_status =:acquisitionStatus  AND subscription_start_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerAcquisition> findCustomerByAllFilters(
			@Param("plantId") Long[] plantId,
			@Param("salesExecutiveId") Long[] salesExecutiveId, @Param("startDate") Timestamp startDate,@Param("endDate")Timestamp endDate,@Param("acquisitionStatus") String acquisitionStatus);

	@Query(value="SELECT * FROM customers_acquisition WHERE plant_id IN (:plantId) AND sales_executive_id IN (:salesExecutiveId) AND subscription_start_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerAcquisition> findCustomerByDateRangeAndAllId(
			@Param("plantId") Long[] plantId,
			@Param("salesExecutiveId") Long[] salesExecutiveId, @Param("startDate") Timestamp startDate,@Param("endDate")Timestamp endDate);

	@Query(value="SELECT * FROM customers_acquisition WHERE plant_id IN (:plantId) AND subscription_start_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerAcquisition> findCustomerByDateRangeAndPlantId(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("plantId") Long[] plantId );



	@Query(value="SELECT * FROM customers_acquisition WHERE sales_executive_id IN (:salesExecutiveId) AND subscription_start_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerAcquisition> findCustomerByDateRangeANDId(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("salesExecutiveId") Long[] salesExecutiveId );
	@Query (value="SELECT * from customers_acquisition ud where ud.sales_executive_id in ?1 AND ud.plant_id in ?2 AND ud.acquisition_status=?3", nativeQuery=true)
	List<CustomerAcquisition> findByIdAndStatus(@Param("saleExecutiveId")Long[] salesExecutiveId,@Param("plantId")Long[] plantId,@Param("acquisitionStatus")String acquisitionStatus);
	@Query (value="SELECT * from customers_acquisition ud where ud.sales_executive_id in ?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<CustomerAcquisition> findByPlantIdAndSalesExecutiveId(@Param("saleExecutiveId")Long[] salesExecutiveId,@Param("plantId")Long[] plantId);

	@Query (value="SELECT * from customers_acquisition ud where ud.acquisition_status=?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<CustomerAcquisition> findByCustomerStatusAndPlantId(@Param("customerStatus")String customerStatus,@Param("plantId")Long[] plantId);


	@Query (value="SELECT * from customers_acquisition ud where ud.acquisition_status=?1 AND ud.sales_executive_id in ?2", nativeQuery=true)
	public  List<CustomerAcquisition> findByCustomerStatusAndSalesExecutiveId(@Param("acquisitionStatus")String acquisitionStatus,@Param("salesExecutiveId")Long[] salesExecutiveId);





	public List<CustomerAcquisition> findByIsActiveAndAcquisitionStatusAndSalesExecutiveId(Boolean isActive, String acquisition_status, String salesId);
	//public List<CustomerAcquisition> findByAcquisitionStatus(Boolean isActive, String acquisition_status);
	
	

	

	
//	public List<CustomerAcquisition> findAllByAcquisitionStatusAndSubscriptionStartDateAndSubscriptionEndDate(
//			String acquisitionStatus, Timestamp subscriptionStartDate, Timestamp subscriptionEndDate);
	
	
//	@Query("SELECT SUM(totalSolarGenKw) AS total_solar_gen_kw_hh , SUBSTRING(eventTimeStamp,1,13) AS eventTimestamp_hh, omcId, plantId FROM Solar where omcId =:omcId and eventTimeStamp>=:statTime and eventTimeStamp<:endTime GROUP BY  eventTimestamp_hh, omcId ,plantId ORDER BY omcId,eventTimestamp_hh")
//	public List<Object[]> getTotalSolarGenKwByOmcId(@Param("omcId") Integer omcId, @Param("statTime") Timestamp statTime, @Param("endTime") Timestamp endTime );

	public Long deleteByid(Long Id);



}
