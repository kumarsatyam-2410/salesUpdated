package com.omc.sales.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.CustomerAcquisition;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerAcquisitionRepository extends JpaRepository<CustomerAcquisition, Long> {

	public CustomerAcquisition findByCustomerName(String customerName);
	public CustomerAcquisition findAllById(Long id);
	public List<CustomerAcquisition> getAllCustomerAcquisitionByid(Long id);
	
//	public Minigrid findTopByOmcIdOrderByEventTimeStampDesc(int omcId);
//
//	List<User> findTop10ByLastname(String lastname, Pageable pageable);

	//public CustomerAcquisition findTopOrderByPlantIdDesc();

	
	public List<CustomerAcquisition> findByIsActiveAndAcquisitionStatusAndSalesExecutiveId(Boolean isActive, String acquisition_status, String salesId);
	//public List<CustomerAcquisition> findByAcquisitionStatus(Boolean isActive, String acquisition_status);
	
	
//	@Query("SELECT SUM(totalSolarGenKw) AS total_solar_gen_kw_hh , SUBSTRING(eventTimeStamp,1,13) AS eventTimestamp_hh, omcId, plantId FROM Solar where omcId =:omcId and eventTimeStamp>=:statTime and eventTimeStamp<:endTime GROUP BY  eventTimestamp_hh, omcId ,plantId ORDER BY omcId,eventTimestamp_hh")
//	public List<Object[]> getTotalSolarGenKwByOmcId(@Param("omcId") Integer omcId, @Param("statTime") Timestamp statTime, @Param("endTime") Timestamp endTime );


}
