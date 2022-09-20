package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SalesHeadTargetDTO {
	
    private Long salesHeadId;

	private String userId;

	private String targetType;

	private Timestamp targetStartDate;
	
	private Timestamp targetEndDate;
	
	private int noCustomerAcqTarget;
	
	private BigDecimal revenueTargetAmount;
	
	private String comment;
	
	private int addedBy;

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
