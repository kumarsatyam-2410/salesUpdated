package com.omc.sales.dto;

public class CafTableDTO {
	
	private Long id;
	private int plantId;
	private int omcId;
	private String billingType;
	private String customerNo;
	private String cafNo;
	
	
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public int getOmcId() {
		return omcId;
	}
	public void setOmcId(int omcId) {
		this.omcId = omcId;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCafNo() {
		return cafNo;
	}
	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	}
	
