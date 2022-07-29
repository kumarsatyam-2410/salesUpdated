package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.UserTarget;

public interface UserTargetRepository extends JpaRepository<UserTarget,Long> {

   public List<UserTarget> findListByUserId(String userId);

public List<UserTarget> getListByAddedBy(int addedBy);

public List<UserTarget> findTop10ByOrderByTargetIdDesc();

}
