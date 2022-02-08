package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserTargetDTO {
	
    private Long targetId;
	
	private String userId;
	
	private String targetType;
	
	private Timestamp targetStartDate;
	
	private Timestamp targetEndDate;
	
	private Long noCustomerAcqTarget;
	
	private BigDecimal revenueTargetAmount;
	
	private String comment;

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getUserId() {
		return userId;
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

	public Timestamp getTargetStartDate() {
		return targetStartDate;
	}

	public void setTargetStartDate(Timestamp targetStartDate) {
		this.targetStartDate = targetStartDate;
	}

	public Timestamp getTargetEndDate() {
		return targetEndDate;
	}

	public void setTargetEndDate(Timestamp targetEndDate) {
		this.targetEndDate = targetEndDate;
	}

	public Long getNoCustomerAcqTarget() {
		return noCustomerAcqTarget;
	}

	public void setNoCustomerAcqTarget(Long noCustomerAcqTarget) {
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

	@Override
	public String toString() {
		return "UserTargetDTO [targetId=" + targetId + ", userId=" + userId + ", targetType=" + targetType
				+ ", targetStartDate=" + targetStartDate + ", targetEndDate=" + targetEndDate + ", noCustomerAcqTarget="
				+ noCustomerAcqTarget + ", revenueTargetAmount=" + revenueTargetAmount + ", comment=" + comment + "]";
	}
	
	

}
