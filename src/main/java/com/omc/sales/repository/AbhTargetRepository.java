package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.AbhTarget;

public interface AbhTargetRepository extends JpaRepository<AbhTarget,Long> {

          public AbhTarget findAbhTargetByUserId(String userId);

}
