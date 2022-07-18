package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.ChurnCustomer;


public class ChurnUserListResponseDTO extends AbstractResponseDTO{

	private static final long serialVersionUID = 1L;
	
	List<ChurnCustomer> list;

	public List<ChurnCustomer> getList() {
		return list;
	}

	public void setList(List<ChurnCustomer> list) {
		this.list = list;
	}
	
	

	
}
