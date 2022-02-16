package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.CustomerHistory;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory,Long>{

}
