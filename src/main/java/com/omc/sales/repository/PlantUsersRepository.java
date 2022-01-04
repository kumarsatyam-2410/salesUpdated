package com.omc.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantUsers;



/**
 * The Interface UsersRepository.
 */
@Repository
public interface PlantUsersRepository extends JpaRepository<PlantUsers, Long> {
	
	@Query("SELECT r.plant FROM PlantUsers r where r.user.id=:userId")
	List<Plant> findPlantByUser(@Param("userId") Long userId);
}
