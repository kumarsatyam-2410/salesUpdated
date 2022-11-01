package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.PlantPoll;
import com.omc.sales.entity.PollSll;

public class PlantPollSllCustomerListDTO extends AbstractResponseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<PollSll> list;
	List<PlantPoll> list1;

	public List<PlantPoll> getList1() {
		return list1;
	}

	public void setList1(List<PlantPoll> list1) {
		this.list1 = list1;
	}



	public List<PollSll> getList() {
		return list;
	}

	public void setList(List<PollSll> list) {
		this.list = list;
	}
	
	

}
