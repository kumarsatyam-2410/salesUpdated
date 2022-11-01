package com.omc.sales.dto;

import java.util.List;

import com.omc.sales.entity.CafTable;

public class CafTableListResponseDTO extends AbstractResponseDTO{
	
	private static final long serialVersionUID = 1L;
	
	private List<CafTable> list;

	private Long aid;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public List<CafTable> getList() {
		return list;
	}

	public void setList(List<CafTable> list) {
		this.list = list;
	}
	
	

}
