package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Plant;

public class PlantListResponseDTO extends AbstractResponseDTO{

	private List<Plant> list;
	
	public List<Plant> getList() {
		return list;
	}
	public void setList(List<Plant> list) {
		this.list = list;
	}

}
