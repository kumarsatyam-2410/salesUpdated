package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.RevenueCollectionTarget;


public interface RevenueCollectionTargetRepository extends JpaRepository<RevenueCollectionTarget,Long>{

	public RevenueCollectionTarget findRevenueCollectionTargetByUserId(String userId);

}
