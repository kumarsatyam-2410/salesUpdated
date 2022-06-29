package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.omc.sales.dto.CustomerDTO;
import com.omc.sales.entity.Customer;
import com.omc.sales.entity.Plant;
import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PollSll;
import com.omc.sales.entity.SllCustomer;
import com.omc.sales.exception.ErrorCodes;
import com.omc.sales.exception.SSNSQLException;
import com.omc.sales.repository.CustomerRepository;
import com.omc.sales.repository.PlantPollRepository;
import com.omc.sales.repository.PlantRepository;
import com.omc.sales.repository.PollSllRepository;
import com.omc.sales.repository.SllCustomerRepository;


@Service
public class PlantPollSllCustomerService {

	@Autowired
	private PlantRepository plantRepository;
	
	
	
	@Autowired
	private PlantPollRepository plantPollRepository;
	
	
	@Autowired
	private PollSllRepository pollSllRepository;
	
	@Autowired
	private SllCustomerRepository sllCustomerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(PlantPollSllCustomerService.class);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createPoll(String plantId, String pollNumber) throws SSNSQLException{

		PlantPoll plantPollEntity = new PlantPoll();
		plantPollEntity.setPlant(plantRepository.findById(Long.valueOf(plantId)).get());
		plantPollEntity.setAddedOn(new Timestamp(new Date().getTime()));
		plantPollEntity.setPollNumber(Long.valueOf(pollNumber));
		plantPollRepository.save(plantPollEntity);

		return plantPollEntity.getPpId();
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createSll(String pollId, String sllNumber) throws SSNSQLException{

		PollSll plantPollEntity = new PollSll();
		plantPollEntity.setPlantPoll(plantPollRepository.findById(Long.valueOf(pollId)).get());
		plantPollEntity.setAddedOn(new Timestamp(new Date().getTime()));
		plantPollEntity.setSllNumber(Long.valueOf(sllNumber));
		pollSllRepository.save(plantPollEntity);

		return plantPollEntity.getPsId();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createSllCustomer(String sllId, String customerId) throws SSNSQLException{

		SllCustomer sllCustomerEntity = new SllCustomer();
		sllCustomerEntity.setPollSll(pollSllRepository.findById(Long.valueOf(sllId)).get());
		sllCustomerEntity.setCustomer(customerRepository.findById(Long.valueOf(customerId)).get());
		sllCustomerRepository.save(sllCustomerEntity);

		return sllCustomerEntity.getScId();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<PlantPoll> getPollSll(Plant plant) {
		return plantPollRepository.findByPlant(plant);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<PollSll> listAllPollSll(PlantPoll plantPoll) {
		
		return pollSllRepository.findAllByPlantPoll(plantPoll);
	}
	
}
