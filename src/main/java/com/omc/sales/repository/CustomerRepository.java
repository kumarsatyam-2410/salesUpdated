package com.omc.sales.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Customer;
import com.omc.sales.entity.CustomerAcquisition;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findAllById(Long id);
	public Customer findByCustomerName(String customerName);
	public List<Customer> getCustomerById(Long id);
	public List<Customer> findAllCustomerBySll(String sll);
	
	public List<Customer> findAllByOrderByIdDesc();
	
	 @Query(value="SELECT  * FROM `customers` WHERE customer_status =:customerStatus  limit :limits  offset :offsets " ,nativeQuery = true)
	public List<Customer> findCustomerStatus(@Param("customerStatus") String customerStatus , @Param("offsets") Integer offsets , @Param("limits")  Integer limits);
	  
	  @Query(value = "from Customer t where subscription_start_date BETWEEN :startDate AND :endDate")
    public List<Customer> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);

	
	   @Query(value="SELECT  * FROM `customers` WHERE customer_status =:customerStatus AND (subscription_start_date BETWEEN :startDate AND :endDate)  limit :limits  offset :offsets " ,nativeQuery = true)
	    public List<Customer> findSubscriptionStartDateBetweenAndAcquisitionStatus(
            @Param("startDate") Timestamp startDate,
            @Param("endDate") Timestamp endDate, @Param("customerStatus") String customerStatus ,@Param("offsets") Integer offsets,@Param("limits")  Integer limits);
	  
	  @Query(value="SELECT  * FROM `customers`  limit :limits  offset :offsets " ,nativeQuery = true)
	  public List<Customer> findCustomerByLimitsAndOffSets(@Param("offsets") Integer offsets,@Param("limits") Integer limits);
	  
	

	
	
	

}
