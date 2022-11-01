package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omc.sales.entity.AbhTarget;

public interface AbhTargetRepository extends JpaRepository<AbhTarget,Long> {

         public AbhTarget findByAbhId(Long abhId);

		public  List<AbhTarget> findAbhTargetByUserId(String userId);

		public List<AbhTarget> getAbhTargetByAddedBy(int addedBy);

		public List<AbhTarget> findAllByOrderByAbhIdDesc();

	    public Long deleteByAbhId(Long abhId);


}
