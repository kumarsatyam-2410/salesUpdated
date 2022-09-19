package com.omc.sales.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="revenue_collection_target")
public class RevenueCollectionTarget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long rctId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "target_type")
	private String targetType;
	
	@Column(name = "target_start_date")
	private Date targetStartDate;
	
	@Column(name = "target_end_date")
	private Date targetEndDate;
	
	@Column(name = "revenue_target_amount")
	private BigDecimal revenueTargetAmount;
	
	@Column(name = "comment")
	private String comment;

	@Column(name = "added_by")
	private int addedBy;
	
	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public RevenueCollectionTarget() {
		
	}

	public Long getRctId() {
		return rctId;
	}

	public void setRctId(Long rctId) {
		this.rctId = rctId;
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
