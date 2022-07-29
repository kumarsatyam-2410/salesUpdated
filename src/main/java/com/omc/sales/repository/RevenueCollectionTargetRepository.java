package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.RevenueCollectionTarget;


public interface RevenueCollectionTargetRepository extends JpaRepository<RevenueCollectionTarget,Long>{

	public List<RevenueCollectionTarget> findRevenueCollectionTargetByUserId(String userId);

	public List<RevenueCollectionTarget> getListRevenueCollectionTargetByAddedBy(int addedBy);

	public List<RevenueCollectionTarget> findTop10ByOrderByRctIdDesc();

}
