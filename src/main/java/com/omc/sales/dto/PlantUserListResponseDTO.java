package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.PlantUsers;

public class PlantUserListResponseDTO extends AbstractResponseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<PlantUsers> list;

	public List<PlantUsers> getList() {
		return list;
	}

	public void setList(List<PlantUsers> list) {
		this.list = list;
	}

}
