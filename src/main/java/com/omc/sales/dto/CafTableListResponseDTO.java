package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.CafTable;

public class CafTableListResponseDTO extends AbstractResponseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private List<CafTable> list;

	public List<CafTable> getList() {
		return list;
	}

	public void setList(List<CafTable> list) {
		this.list = list;
	}
	
	

}
