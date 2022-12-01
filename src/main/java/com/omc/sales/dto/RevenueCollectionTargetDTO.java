package com.omc.sales.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class RevenueCollectionTargetDTO {
	
	private Long rctId;
	
	private String targetType;
	
	private String year;
	
	private String month;

	private BigDecimal revenueTargetAmount;
	
	private String comment;
	
	private int addedBy;
	
	private int userId;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public RevenueCollectionTargetDTO() {
		
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}


	
	public Long getRctId() {
		return rctId;
	}

	public void setRctId(Long rctId) {
		this.rctId = rctId;
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
	
	
	

}
