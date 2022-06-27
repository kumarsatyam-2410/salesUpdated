package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.PollSll;

public class PlantPollSllCustomerListDTO extends AbstractResponseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<PollSll> list;

	public List<PollSll> getList() {
		return list;
	}

	public void setList(List<PollSll> list) {
		this.list = list;
	}
	
	

}
