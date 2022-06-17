package com.omc.sales.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CafTableResponseDTO extends AbstractResponseDTO{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private String cafNo;

	public String getCafNo() {
		return cafNo;
	}

	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
	}
	
	

}
