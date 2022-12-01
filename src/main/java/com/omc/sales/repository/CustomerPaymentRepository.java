package com.omc.sales.repository;

import java.sql.Timestamp;
import java.util.List;

import com.omc.sales.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.CustomerPaymentDetails;


/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPaymentDetails, Long> {

	public CustomerPaymentDetails findByCustomerId(Long customerId);
	
	//@Query("SELECT SUM(totalBattChgPowerKw) AS total_batt_chg_power_kw_hh ,SUM(totalBattDischgChgPowerKw) AS total_batt_dischg_chg_power_kw_hh , SUBSTRING(eventTimeStamp,1,13) AS eventTimestamp_hh, omcId,plantId FROM Battery where omcId =:omcId and eventTimeStamp>=:statTime and eventTimeStamp<:endTime GROUP BY  eventTimestamp_hh, omcId ,plantId ORDER BY omcId, eventTimestamp_hh")
	@Query("SELECT SUM(paymentAmount) AS total_revenue FROM CustomerPaymentDetails WHERE paymentReceivedUserId =:paymentReceivedUserId")
	public List<Object[]> getTotalRevenue(@Param("paymentReceivedUserId") Integer paymentReceivedUserId);

	@Query("SELECT SUM(paymentAmount) AS mtd_revenue FROM CustomerPaymentDetails WHERE paymentReceivedUserId= :userId AND MONTH(paymentDate)= MONTH(CURDATE()) AND YEAR(paymentDate) = YEAR(CURDATE())")
	public List<Object[]> getMTDRevenue(@Param("userId") Integer userId);

	public List<CustomerPaymentDetails> findAllByOrderByCpIdDesc();
	
	
	//SELECT SUM(payment_amount) AS total_revenue FROM CustomerPaymentDetails WHERE payment_received_user_id=1;
	//   SELECT SUM(payment_amount) AS mtd_revenue FROM `customer_payment_details` WHERE payment_received_user_id=1 AND MONTH(payment_date)= MONTH(CURDATE()) AND YEAR(payment_date) = YEAR(CURDATE());
	//   SELECT revenue_target_amount FROM user_target WHERE user_id=1 AND  CURDATE() >= DATE(target_start_date)  AND CURDATE() <= DATE(target_end_date)


	@Query(value="SELECT * FROM customer_payment_details WHERE plant_id IN (:plantId) AND payment_received_user_id IN (:paymentReceivedUserId) AND payment_mode =:paymentMode  AND payment_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerPaymentDetails> findCustomerByAllFilters(
			@Param("plantId") Long[] plantId,
			@Param("paymentReceivedUserId") Long[] paymentReceivedUserId, @Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate, @Param("paymentMode") String paymentMode);
	@Query(value="SELECT * FROM customer_payment_details WHERE plant_id IN (:plantId) AND payment_received_user_id IN (:paymentReceivedUserId) AND payment_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerPaymentDetails> findCustomerByDateRangeAndAllId(
			@Param("plantId") Long[] plantId,
			@Param("paymentReceivedUserId") Long[] paymentReceivedUserId, @Param("startDate") Timestamp startDate,@Param("endDate")Timestamp endDate);

	@Query(value="SELECT * FROM customer_payment_details WHERE plant_id IN (:plantId) AND payment_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerPaymentDetails> findCustomerByDateRangeAndPlantId(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("plantId") Long[] plantId );


	@Query(value="SELECT * FROM customer_payment_details WHERE payment_received_user_id IN (:paymentReceivedUserId) AND payment_date BETWEEN :startDate AND :endDate" ,nativeQuery = true)
	public List<CustomerPaymentDetails> findCustomerByDateRangeAndId(
			@Param("paymentReceivedUserId") Long[] paymentReceivedUserId,
			@Param("startDate") Timestamp startDate, @Param("endDate")Timestamp endDate );

	@Query(value="SELECT  * FROM customer_payment_details WHERE payment_mode =:paymentMode AND (payment_date BETWEEN :startDate AND :endDate)" ,nativeQuery = true)
	public List<CustomerPaymentDetails> findCustomerPaymentDetailByDateAndPaymentMode(
			@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("paymentMode") String paymentMode );

	@Query (value="SELECT * from customer_payment_details ud where ud.payment_received_user_id in ?1 AND ud.plant_id in ?2 AND ud.payment_mode=?3", nativeQuery=true)
	List<CustomerPaymentDetails> findByIdAndMode(@Param("paymentReceivedUserId")Long[] paymentReceivedUserId,@Param("plantId")Long[] plantId,@Param("paymentMode")String paymentMode);

	@Query (value="SELECT * from customer_payment_details ud where ud.payment_received_user_id in ?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<CustomerPaymentDetails> findByPlantIdAndPaymentRecievedUserId(@Param("paymentReceivedUserId")Long[] paymentReceivedUserId,@Param("plantId")Long[] plantId);

	@Query (value="SELECT * from customer_payment_details ud where ud.payment_mode=?1 AND ud.plant_id in ?2", nativeQuery=true)
	public  List<CustomerPaymentDetails> findByPaymentModeAndPlantId(@Param("paymentMode")String paymentMode,@Param("plantId")Long[] plantId);


	@Query (value="SELECT * from customer_payment_details ud where ud.payment_mode=?1 AND ud.payment_received_user_id in ?2", nativeQuery=true)
	public  List<CustomerPaymentDetails> findByPaymentModeAndId(@Param("paymentMode")String paymentMode,@Param("paymentReceivedUserId")Long[] paymentReceivedUserId);

	@Query(value = "from CustomerPaymentDetails t where payment_date BETWEEN :startDate AND :endDate")
	public List<CustomerPaymentDetails> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);


	@Query (value="SELECT * from customer_payment_details ud where ud.plant_id in ?1", nativeQuery=true)
	public List<CustomerPaymentDetails> getCustomerByPlantId(Long[] plantId);

	@Query (value="SELECT * from customer_payment_details ud where ud.payment_received_user_id in ?1", nativeQuery=true)
	public List<CustomerPaymentDetails> findCustomerByPaymentReceivedUserId(@Param("paymentReceivedUserId") Long[] paymentReceivedUserId);

	@Query (value="SELECT * from customer_payment_details ud where ud.payment_mode=?1", nativeQuery=true)
	public List<CustomerPaymentDetails> findCustomerByPaymentMode(@Param("paymentMode")String paymentMode);
}
