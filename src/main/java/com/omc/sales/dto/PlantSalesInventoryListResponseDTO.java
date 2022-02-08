package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.PlantSalesInventory;

public class PlantSalesInventoryListResponseDTO extends AbstractResponseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PlantSalesInventory> list;

	public List<PlantSalesInventory> getList() {
		return list;
	}

	public void setList(List<PlantSalesInventory> list) {
		this.list = list;
	}

	
}
