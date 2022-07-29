package com.omc.sales.repository;

import java.util.List;

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

}
