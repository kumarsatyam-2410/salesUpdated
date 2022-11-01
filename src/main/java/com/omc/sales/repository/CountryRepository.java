package com.omc.sales.repository;


import com.omc.sales.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer> {



    public List<Country> findAllByOrderByIdDesc();
}
