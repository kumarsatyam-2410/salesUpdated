package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.dto.AbstractResponseDTO;
import com.omc.sales.entity.SubscriptionTypes;

public class SubscriptionTypesListResponseDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<SubscriptionTypes> list;

	public List<SubscriptionTypes> getList() {
		return list;
	}

	public void setList(List<SubscriptionTypes> list) {
		this.list = list;
	}
	
	

}
