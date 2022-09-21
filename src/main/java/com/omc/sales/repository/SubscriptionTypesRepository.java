package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.SubscriptionTypes;

public interface SubscriptionTypesRepository extends JpaRepository<SubscriptionTypes ,Long>{

	public SubscriptionTypes findBySubId(Long subId);

}
