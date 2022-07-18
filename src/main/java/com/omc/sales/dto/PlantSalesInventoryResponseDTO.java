package com.omc.sales.dto;

import java.util.Objects;

public class PlantSalesInventoryResponseDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long inventoryId;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Override
	public String toString() {
		return "PlantSalesInventoryResponseDTO [inventoryId=" + inventoryId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(inventoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlantSalesInventoryResponseDTO other = (PlantSalesInventoryResponseDTO) obj;
		return Objects.equals(inventoryId, other.inventoryId);
	}

	
	
	

}
