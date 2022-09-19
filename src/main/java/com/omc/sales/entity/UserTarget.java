package com.omc.sales.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_target")
public class UserTarget {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="target_id")
	private Long targetId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="target_type")
	private String targetType;
	
	@Column(name="target_start_date")
	private Timestamp targetStartDate;
	
	@Column(name="target_end_date")
	private Timestamp targetEndDate;
	
	@Column(name="no_customer_acq_target")
	private Long noCustomerAcqTarget;
	
	@Column(name="revenue_target_amount")
	private BigDecimal revenueTargetAmount;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name = "added_by")
	private int addedBy;

	
	
	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public UserTarget() {
		super();
	}

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
		return "UserTarget [targetId=" + targetId + ", userId=" + userId + ", targetType=" + targetType
				+ ", targetStartDate=" + targetStartDate + ", targetEndDate=" + targetEndDate + ", noCustomerAcqTarget="
				+ noCustomerAcqTarget + ", revenueTargetAmount=" + revenueTargetAmount + ", comment=" + comment + "]";
	}
	
	

}
