package com.omc.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.UserTarget;

public interface UserTargetRepository extends JpaRepository<UserTarget,Long> {

}
