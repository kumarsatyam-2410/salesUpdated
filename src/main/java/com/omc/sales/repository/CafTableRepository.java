package com.omc.sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.CafTable;

public interface CafTableRepository extends JpaRepository<CafTable,Long> {
	
	

	public CafTable findByPlantIdAndBillingType(int plantId, String billingType);

	public CafTable findCafTableById(Long id);

}
