package com.omc.sales.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

	
	  @Query(value="SELECT  * FROM `customers_acquisition` WHERE acquisition_status =:acquisitionStatus AND (subscription_start_date BETWEEN :startDate AND :endDate)  limit :limits  offset :offsets " ,nativeQuery = true)
	public List<CustomerAcquisition> findSubscriptionStartDateBetweenAndAcquisitionStatus(
            @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate, @Param("acquisitionStatus") String acquisitionStatus ,@Param("offsets") Integer offsets,@Param("limits")  Integer limits);

	
			 
		
	  
	
	public List<CustomerAcquisition> findByIsActiveAndAcquisitionStatusAndSalesExecutiveId(Boolean isActive, String acquisition_status, String salesId);
	//public List<CustomerAcquisition> findByAcquisitionStatus(Boolean isActive, String acquisition_status);
	
	

	

	
//	public List<CustomerAcquisition> findAllByAcquisitionStatusAndSubscriptionStartDateAndSubscriptionEndDate(
//			String acquisitionStatus, Timestamp subscriptionStartDate, Timestamp subscriptionEndDate);
	
	
//	@Query("SELECT SUM(totalSolarGenKw) AS total_solar_gen_kw_hh , SUBSTRING(eventTimeStamp,1,13) AS eventTimestamp_hh, omcId, plantId FROM Solar where omcId =:omcId and eventTimeStamp>=:statTime and eventTimeStamp<:endTime GROUP BY  eventTimestamp_hh, omcId ,plantId ORDER BY omcId,eventTimestamp_hh")
//	public List<Object[]> getTotalSolarGenKwByOmcId(@Param("omcId") Integer omcId, @Param("statTime") Timestamp statTime, @Param("endTime") Timestamp endTime );


}
