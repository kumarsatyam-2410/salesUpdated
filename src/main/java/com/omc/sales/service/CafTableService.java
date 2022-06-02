package com.omc.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omc.sales.dto.CafTableDTO;
import com.omc.sales.entity.CafTable;
import com.omc.sales.repository.CafTableRepository;

@Service
public class CafTableService<cafNo> {
	
	@Autowired
	private CafTableRepository cafTableRepository;

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

	public List<CafTable> getCafTable(int plantId, String billingType) {
		List<CafTable> list=new ArrayList<>();
		CafTable CafTable   = cafTableRepository.findByPlantIdAndBillingType(plantId,billingType);
		list.add(CafTable);
		return list;
		
	}

	
	

}
