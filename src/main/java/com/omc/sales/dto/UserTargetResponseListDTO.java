package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.UserTarget;

public class UserTargetResponseListDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserTarget> list;

	public List<UserTarget> getList() {
		return list;
	}

	public void setList(List<UserTarget> list) {
		this.list = list;
	}
	
	

}
