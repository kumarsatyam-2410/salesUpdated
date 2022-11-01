package com.omc.sales.repository;

import com.omc.sales.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State,Integer> {


   public List<State> findByCountryId(Integer countryId);

}
