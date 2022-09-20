package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.SalesHeadTarget;

public class SalesHeadTargetListResponseDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SalesHeadTarget> list;

	public List<SalesHeadTarget> getList() {
		return list;
	}

	public void setList(List<SalesHeadTarget> list) {
		this.list = list;
	}
	
}
