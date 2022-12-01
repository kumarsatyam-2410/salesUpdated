package com.omc.sales.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales_head_target")
public class SalesHeadTarget {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sales_head_id")
	private Long salesHeadId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "target_type")
	private String targetType;

	@Column(name = "year")
	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "month")
	private String month ;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "no_customer_acq_target")
	private int noCustomerAcqTarget;
	
	@Column(name = "revenue_target_amount")
	private BigDecimal revenueTargetAmount;
	
	@Column(name = "comments")
	private String comment;
	
	@Column(name = "added_by")
	private int addedBy;

	public SalesHeadTarget() {
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
