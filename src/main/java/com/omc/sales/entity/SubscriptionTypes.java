package com.omc.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscription_types")
public class SubscriptionTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sub_id")
	private Long subId;
	
	@Column(name="subscription_type")
	private String subscriptionType;
	
	@Column(name="sub_status")
	private int subStatus;

	public SubscriptionTypes() {
		super();
	}

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
