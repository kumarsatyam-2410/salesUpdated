package com.omc.sales.repository;

import java.util.List;

import com.omc.sales.entity.SllChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PollSll;




/**
 * The Interface UsersRepository.
 */
@Repository
public interface PollSllRepository extends JpaRepository<PollSll, Long> {

//public 	List<PollSll> findAllByPsId(Long psId);

    public List<PollSll> findAllByPlantPoll(PlantPoll plantPoll);
    public PollSll findBypsId(Long psId);

	public List<PollSll> findAllBySllNumber(Long sllNumber);
    public Long deleteByPsId(Long psId);



}
