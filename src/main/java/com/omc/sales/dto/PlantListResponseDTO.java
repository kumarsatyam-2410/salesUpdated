package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.Plant;

public class PlantListResponseDTO extends AbstractResponseDTO{

	private List<Plant> list;
	private Long plantId;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Plant> getList() {
		return list;
	}
	public void setList(List<Plant> list) {
		this.list = list;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId =plantId;
	}


}
