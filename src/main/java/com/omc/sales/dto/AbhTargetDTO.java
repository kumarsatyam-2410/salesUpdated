package com.omc.sales.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class AbhTargetDTO {
	
	private Long abhId;
	
	private Integer userId;
	
	private String targetType;
	
	private String year;

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

	private String month;

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

	public Integer getUserId() {
		return userId;
	}
	
	public Long getAbhId() {
		return abhId;
	}

	public void setAbhId(Long abhId) {
		this.abhId = abhId;
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
