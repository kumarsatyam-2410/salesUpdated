package com.omc.sales.repository;
import java.sql.Timestamp;
import java.util.List;

import com.omc.sales.entity.AbhTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.omc.sales.entity.SalesHeadTarget;

public interface SalesHeadTargetRepository extends JpaRepository<SalesHeadTarget ,Long> {

         public	SalesHeadTarget findBySalesHeadId(Long salesHeadId);

	public  List<SalesHeadTarget> findSalesHeadTargetBySalesHeadId(Long salesHeadId);

		public List<SalesHeadTarget> findSalesHeadTargetByUserId(String userId);

		public List<SalesHeadTarget> findSalesHeadTargetByAddedBy(int addedBy);
		
		@Query(value = "from SalesHeadTarget t where targetStartDate BETWEEN :startDate AND :endDate")
		public List<SalesHeadTarget> getAllBetweenDates(@Param("startDate")Timestamp startDate,@Param("endDate")Timestamp endDate);

	
}
