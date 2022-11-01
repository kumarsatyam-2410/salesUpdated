package com.omc.sales.repository;

import java.util.List;

import com.omc.sales.entity.PollSll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantPoll;




/**
 * The Interface UsersRepository.
 */
@Repository
public interface PlantPollRepository extends JpaRepository<PlantPoll, Long> {

	public List<PlantPoll> findByPlant(Plant plant);
	public PlantPoll findByppId(Long ppId);
	public Long deleteByppId(Long ppId);


}
