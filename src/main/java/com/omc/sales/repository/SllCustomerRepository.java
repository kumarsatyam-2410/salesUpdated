package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Plant;
import com.omc.sales.entity.SllCustomer;




/**
 * The Interface UsersRepository.
 */
@Repository
public interface SllCustomerRepository extends JpaRepository<SllCustomer, Long> {


}
