package com.omc.sales.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.omc.sales.entity.*;
import com.omc.sales.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.exception.SSNSQLException;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


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

	@Autowired
	private SllChannelRepository sllChannelRepository;
	
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
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public Long updatePoll(Long ppID,String plantId, String pollNumber) {
		LOGGER.info("In updatePlant  Service");
		PlantPoll plantPollEntity = new PlantPoll();
		plantPollEntity.setPpId(ppID);
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
	public Long updateSll(Long psId,String pollId, String sllNumber) throws SSNSQLException{

		PollSll plantPollEntity = new PollSll();
		plantPollEntity.setPsId(psId);
		plantPollEntity.setPlantPoll(plantPollRepository.findById(Long.valueOf(pollId)).get());
		plantPollEntity.setAddedOn(new Timestamp(new Date().getTime()));
		plantPollEntity.setSllNumber(Long.valueOf(sllNumber));
		pollSllRepository.save(plantPollEntity);

		return plantPollEntity.getPsId();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Long createSllCustomer(String sllId, String customerId,String channelNo) throws SSNSQLException{

		SllCustomer sllCustomerEntity = new SllCustomer();
		sllCustomerEntity.setPollSll(pollSllRepository.findById(Long.valueOf(sllId)).get());
		sllCustomerEntity.setCustomer(customerRepository.findById(Long.valueOf(customerId)).get());
		sllCustomerEntity.setChannelNo(channelNo);
		sllCustomerRepository.save(sllCustomerEntity);

		return sllCustomerEntity.getScId();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<PlantPoll> getPollNo(Plant plant) {
		return plantPollRepository.findByPlant(plant);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<PollSll> listAllPollSll(PlantPoll plantPoll) {
		
		return pollSllRepository.findAllByPlantPoll(plantPoll);
	}


	public List<PollSll> listAllPollSll(Long sllNumber) {
	    
		return pollSllRepository.findAllBySllNumber(sllNumber);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<SllChannel> listAllChannel(Integer sllId) {

		return sllChannelRepository.findAllBySllId(sllId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Long deletePoll(Long ppId) {
		LOGGER.info("In deletepoll  Service"+plantPollRepository.deleteByppId(ppId));
		Long id=plantPollRepository.deleteByppId(ppId);
		return id;

	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteSll(Long psId) {
		LOGGER.info("In deleteSll  Service"+pollSllRepository.deleteByPsId(psId));
		Long id=pollSllRepository.deleteByPsId(psId);
		return id;

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<PlantPoll> listAllByPpId(Long ppId) {

		List<PlantPoll> list=new ArrayList<>();
		PlantPoll plantPoll=plantPollRepository.findByppId(ppId);
		list.add(plantPoll);
		return list;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<PollSll> listAllByPsId(Long psId) {

		List<PollSll> list=new ArrayList<>();
		PollSll pollSll=pollSllRepository.findBypsId(psId);
		list.add(pollSll);
		return list;
	}




}
