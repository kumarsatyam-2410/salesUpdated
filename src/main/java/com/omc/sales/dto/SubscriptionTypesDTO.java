package com.omc.sales.dto;


public class SubscriptionTypesDTO {
	
    private Long subId;
	
	private String subscriptionType;
	
	private int subStatus;

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public int getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(int subStatus) {
		this.subStatus = subStatus;
	}

	
}
