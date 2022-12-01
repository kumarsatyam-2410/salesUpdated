package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SalesHeadTargetDTO {
	
    private Long salesHeadId;

	private String userId;

	private String targetType;

	private  String year;
	
	private String month;
	
	private int noCustomerAcqTarget;
	
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

	public SalesHeadTargetDTO() {
		super();
	}

	public Long getSalesHeadId() {
		return salesHeadId;
	}

	public void setSalesHeadId(Long salesHeadId) {
		this.salesHeadId = salesHeadId;
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

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

}
