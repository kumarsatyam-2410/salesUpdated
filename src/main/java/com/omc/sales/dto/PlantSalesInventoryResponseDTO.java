package com.omc.sales.dto;

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
		return "PlantSalesInventoryResponseDTO [inventoryId=" + inventoryId + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + ", status=" + status + ", getInventoryId()=" + getInventoryId()
				+ ", getStatus()=" + getStatus() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()="
				+ getErrorMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
