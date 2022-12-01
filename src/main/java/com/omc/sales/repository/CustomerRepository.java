package com.omc.sales.repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
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
	



	  


	@Query(value="SELECT  * FROM `customers` WHERE customer_status =:customerStatus  plant_id :plantId  sales_executive_id :salesExecutiveId " ,nativeQuery = true)
	public List<Customer> findCustomerStatus(@Param("customerStatus") String customerStatus , @Param("plantId") Integer[] plantId , @Param("salesExecutiveId")  Integer[] salesExecutiveId);

	@Query(value = "from Customer t where subscription_start_date BETWEEN :startDate AND :endDate")
	public List<Customer> getAllBetweenDates1(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);


	@Query(value="SELECT  * FROM `customers` WHERE customer_status =:customerStatus AND (subscription_start_date BETWEEN :startDate AND :endDate) AND plant_id :plantId AND sales_executive_id IN (:salesExecutiveId) " ,nativeQuery = true)
	public List<Customer> findSubscriptionStartDateBetweenAndAcquisitionStatus(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("customerStatus") String customerStatus ,@Param("plantId") Long[] plantId,@Param("salesExecutiveId")  Long[] salesExecutiveId);

	@Query(value="SELECT  * FROM `customers` WHERE plant_id =:plantId  sales_executive_id=:salesExecutiveId " ,nativeQuery = true)
	public List<Customer> findCustomerByPlantAndSalesExecId(@Param("plantId") Integer[] plantId,@Param("salesExecutiveId") Integer[] salesExecutiveId);



	//public List<Customer> findCustomerByPlantId(Integer[] plantId);
	//public List<Customer> findCustomerByCustomerStatus(String customerStatus);









	//@Query("select u From Customer u WHERE u.plantId =:n ")
	//public List<Customer> findCustomerByPlantId(@Param("n") Integer[] plantId);


	@Query(value = "SELECT * FROM customers WHERE plant_id IN(:plantId))",nativeQuery = true)
	public List<Customer> findCustomerByPlantId(@Param("plantId") Integer[] plantId);

	@Query (value="SELECT * from customers ud where ud.plant_id in ?1", nativeQuery=true)
	public List<Customer> getCustomerByPlantId(Long[] plantId);
	@Query (value="SELECT * from customers ud where ud.customer_status=?1 AND ud.sales_executive_id in ?2", nativeQuery=true)
	public  List<Customer> findByCustomerStatusAndSalesExecutiveId(@Param("customerStatus")String customerStatus,@Param("salesExecutiveId")Long[] salesExecutiveId);


	@Query (value="SELECT * from customers ud where ud.customer_status=?1", nativeQuery=true)
	public List<Customer> findCustomerByCustomerStatus(@Param("customerStatus")String customerStatus);

	//@Query ("SELECT c FROM Customer c WHERE c.salesExecutiveId=:sales_executive_id")
	//List<Customer> findCustomerBySalesExecutiveId(@Param("salesExecutiveId")Integer[] salesExecutiveId);
	//@Query("SELECT ud from Customer ud where ud.salesExecutiveId=?1" )
	@Query (value="SELECT * from customers ud where ud.sales_executive_id in ?1", nativeQuery=true)
	public List<Customer> findCustomerBySalesExecutiveId(@Param("saleExecutiveId") Long[] salesExecutiveId);

	@Query (value="SELECT * from customers ud where ud.customer_status=?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<Customer> findByCustomerStatusAndPlantId(@Param("customerStatus")String customerStatus,@Param("plantId")Long[] plantId);

	@Query(value = "from Customer t where last_success_subscription_date BETWEEN :startDate AND :endDate")
	public List<Customer> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);



	@Query(value = "select customers.*, rms_plant.name from customers inner join rms_plant on customers.plant_id=rms_plant.plant_id ",nativeQuery = true)
	List<Customer> getAllCustomer();

	@Query(value="SELECT  * FROM `customers` WHERE customer_status =:customerStatus AND (last_success_subscription_date BETWEEN :startDate AND :endDate)" ,nativeQuery = true)
	public List<Customer> findSubscriptionStartDateBetweenAndAcquisitionStatus(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("customerStatus") String customerStatus );


	@Query(value="SELECT * FROM customers WHERE sales_executive_id IN (:salesExecutiveId) AND last_success_subscription_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<Customer> findCustomerByDateRangeAndId(
			@Param("salesExecutiveId") Long[] salesExecutiveId,
			@Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate );

	@Query (value="SELECT * from customers ud where ud.sales_executive_id in ?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<Customer> findByPlantIdAndSalesExecutiveId(@Param("saleExecutiveId")Long[] salesExecutiveId,@Param("plantId")Long[] plantId);

	@Query (value="SELECT * from customers ud where ud.sales_executive_id in ?1 AND ud.plant_id in ?2 AND ud.customer_status=?3", nativeQuery=true)
	List<Customer> findByIdAndStatus(@Param("saleExecutiveId")Long[] salesExecutiveId,@Param("plantId")Long[] plantId,@Param("customerStatus")String customerStatus);


	@Query(value="SELECT * FROM customers WHERE plant_id IN (:plantId) AND last_success_subscription_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<Customer> findCustomerByDateRangeAndPlantId(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("plantId") Long[] plantId );

	@Query(value="SELECT * FROM customers WHERE plant_id IN (:plantId) AND sales_executive_id IN (:salesExecutiveId) AND last_success_subscription_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<Customer> findCustomerByDateRangeAndAllId(
			@Param("plantId") Long[] plantId,
			@Param("salesExecutiveId") Long[] salesExecutiveId, @Param("startDate") Timestamp startDate,@Param("endDate")Timestamp endDate);




	@Query(value="SELECT * FROM customers WHERE plant_id IN (:plantId) AND sales_executive_id IN (:salesExecutiveId) AND customer_status =:customerStatus  AND last_success_subscription_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<Customer> findCustomerByAllFilters(
			@Param("plantId") Long[] plantId,
			@Param("salesExecutiveId") Long[] salesExecutiveId, @Param("startDate") Timestamp startDate,@Param("endDate")Timestamp endDate,@Param("customerStatus") String customerStatus);












	@Query(value="SELECT  * FROM `customers`  limit :limits  offset :offsets " ,nativeQuery = true)
	  public List<Customer> findCustomerByLimitsAndOffSets(@Param("offsets") Integer offsets,@Param("limits") Integer limits);
	  
	

	
	
	

}
