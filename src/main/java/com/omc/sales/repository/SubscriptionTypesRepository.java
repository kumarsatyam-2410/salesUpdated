package com.omc.sales.repository;

import com.omc.sales.entity.AbhTarget;
import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.SubscriptionTypes;

import java.util.List;

public interface SubscriptionTypesRepository extends JpaRepository<SubscriptionTypes ,Long>{

	public SubscriptionTypes findBySubId(Long subId);

	public List<SubscriptionTypes> findSubscriptionTypeBySubId(Long subId);

}
