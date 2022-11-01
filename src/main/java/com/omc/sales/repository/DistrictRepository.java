package com.omc.sales.repository;

import com.omc.sales.entity.District;
import com.omc.sales.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {

    public List<District> findByStateId(Integer stateId);
}
