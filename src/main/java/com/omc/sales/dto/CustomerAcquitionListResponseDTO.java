package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.CustomerAcquisition;




public class CustomerAcquitionListResponseDTO extends AbstractResponseDTO{

	private List<CustomerAcquisition> list;
	
	public List<CustomerAcquisition> getList() {
		return list;
	}
	public void setList(List<CustomerAcquisition> list) {
		this.list = list;
	}

}
