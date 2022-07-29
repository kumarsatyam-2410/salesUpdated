package com.omc.sales.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class AbhTargetDTO {
	
	private Long abhId;
	
	private String userId;
	
	private String targetType;
	
	private Date targetStartDate;
	
	private Date targetEndDate;

	private int noCustomerAcqTarget;
	
	private BigDecimal revenueTargetAmount;
	
	private String comment;
	
	private int addedBy;
	
	

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public String getUserId() {
		return userId;
	}
	
	public Long getAbhId() {
		return abhId;
	}

	public void setAbhId(Long abhId) {
		this.abhId = abhId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public Date getTargetStartDate() {
		return targetStartDate;
	}

	public void setTargetStartDate(Date targetStartDate) {
		this.targetStartDate = targetStartDate;
	}

	public Date getTargetEndDate() {
		return targetEndDate;
	}

	public void setTargetEndDate(Date targetEndDate) {
		this.targetEndDate = targetEndDate;
	}

	public int getNoCustomerAcqTarget() {
		return noCustomerAcqTarget;
	}

	public void setNoCustomerAcqTarget(int noCustomerAcqTarget) {
		this.noCustomerAcqTarget = noCustomerAcqTarget;
	}

	public BigDecimal getRevenueTargetAmount() {
		return revenueTargetAmount;
	}

	public void setRevenueTargetAmount(BigDecimal revenueTargetAmount) {
		this.revenueTargetAmount = revenueTargetAmount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AbhTargetDTO() {
		
	}
	
	

}
