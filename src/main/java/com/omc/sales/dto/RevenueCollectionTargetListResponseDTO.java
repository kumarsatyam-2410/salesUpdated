package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.RevenueCollectionTarget;

public class RevenueCollectionTargetListResponseDTO extends AbstractResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<RevenueCollectionTarget> list;

	public List<RevenueCollectionTarget> getList() {
		return list;
	}

	public void setList(List<RevenueCollectionTarget> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
