package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.omc.sales.dto.CafTableDTO;
import com.omc.sales.entity.CafTable;
import com.omc.sales.repository.CafTableRepository;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class CafTableService<cafNo> {
	
	@Autowired
	private CafTableRepository  cafTableRepository;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public String createCafNo(CafTableDTO cafTableDTO) {
		
		CafTable cafTable=new CafTable();
		cafTable.setId(cafTableDTO.getId());
		cafTable.setPlantId(cafTableDTO.getPlantId());
		cafTable.setOmcId(cafTableDTO.getOmcId());
		cafTable.setBillingType(cafTableDTO.getBillingType());
		cafTable.setCustomerNo(cafTableDTO.getCustomerNo());
		cafTable.setCafNo(cafTableDTO.getCafNo());
		cafTableRepository.save(cafTable);
		return cafTable.getCafNo();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CafTable> getCafTable(int plantId, String billingType) {
		List<CafTable> list=new ArrayList<>();
		CafTable CafTable   = cafTableRepository.findByPlantIdAndBillingType(plantId,billingType);
		list.add(CafTable);
		return list;
		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CafTable> getListCafNumber() {
		
		return cafTableRepository.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public String createCafTables(CafTableDTO cafTableDTO) {
	
		CafTable cafTable=new CafTable();
		cafTable.setId(cafTableDTO.getId());
		cafTable.setPlantId(cafTableDTO.getPlantId());
		cafTable.setOmcId(cafTableDTO.getOmcId());
		cafTable.setBillingType(cafTableDTO.getBillingType());
		cafTable.setCustomerNo(cafTableDTO.getCustomerNo());
		cafTable.setCafNo(cafTableDTO.getCafNo());
		cafTableRepository.save(cafTable);
		return cafTable.getCafNo();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public List<CafTable> getCafTable(Long id) {
		
		List<CafTable> list=new ArrayList<>();
		CafTable cafTable= cafTableRepository.findCafTableById(id);
		list.add(cafTable);
		return list;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Long deleteCafTable(Long id) {
		LOGGER.info("In deleteCaf  Service" + cafTableRepository.deleteByid(id));
		Long aid = cafTableRepository.deleteByid(id);
		return id;


	}

}
