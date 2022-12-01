package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserTargetDTO {
	
    private Long targetId;
	
	private Integer userId;
	
	private String targetType;
	
	private String year;
	
	private String month;
	
	private Long noCustomerAcqTarget;
	
	private BigDecimal revenueTargetAmount;
	
	private String comment;
	
	private int addedBy;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
				+ ", year=" + year + ", month=" + month + ", noCustomerAcqTarget="
				+ noCustomerAcqTarget + ", revenueTargetAmount=" + revenueTargetAmount + ", comment=" + comment + "]";
	}
	
	

}
