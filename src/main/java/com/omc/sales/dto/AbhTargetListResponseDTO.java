package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.AbhTarget;

public class AbhTargetListResponseDTO extends AbstractResponseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<AbhTarget> list;

	public List<AbhTarget> getList() {
		return list;
	}

	public void setList(List<AbhTarget> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
