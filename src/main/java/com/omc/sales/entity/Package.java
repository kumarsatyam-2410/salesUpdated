package com.omc.sales.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class notification
 */ 
@Entity
@Table(name = "sales_package")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "package_Id")
	private Long id;

	@Column(name = "package_Name")
	private String packageName;

	@Column(name = "package_Description")
	private String packageDescription;

	@Column(name = "package_type")
	private String packageType;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "suply_hours")
	private String suplyHours;

	@Column(name = "load_max_per_day")
	private BigDecimal maxLoadPerDay;

	@Column(name = "total_load")
	private BigDecimal totalLoad;

//	@Column(name = "added_on")
//	private Timestamp addedOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "created_by")
	private String created_by;

	@Column(name = "updated_by")
	private String updated_by;
	
	@Column(name = "customer_type")
	private String customerType;
	
	@Column(name = "unit_price")
	private BigDecimal unit_price;
	
	@Column(name = "billing_type")
	private String billingType;
	
	@Column(name = "OTI")
	private BigDecimal OTI;
	
	@Column(name = "Remarks")
	private String Remarks;
	
	@Column(name = "validity_days")
  	private int validityDays;
	
	@Column(name = "minimum_package_monthly")
	private BigDecimal minimumPackageMonthly;
	
	@Column(name = "start_timing")
	private Long startTiming;
	
	@Column(name = "end_timing")
	private Long endTiming;
	
	@Column(name = "closed_package")
	private int closedPackage;
	
	@Column(name = "validity")
	private Timestamp validity;
	
	@Column(name = "churn")
	private int churn;
	
	@Column(name = "grace")
	private int grace;
	
	public int getChurn() {
		return churn;
	}

	public void setChurn(int churn) {
		this.churn = churn;
	}

	public int getGrace() {
		return grace;
	}

	public void setGrace(int grace) {
		this.grace = grace;
	}

	public int getClosedPackage() {
		return closedPackage;
	}

	public void setClosedPackage(int closedPackage) {
		this.closedPackage = closedPackage;
	}

	public String getCustomerType() {
		return customerType;
	}

	public int getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}

	public BigDecimal getMinimumPackageMonthly() {
		return minimumPackageMonthly;
	}

	public void setMinimumPackageMonthly(BigDecimal minimumPackageMonthly) {
		this.minimumPackageMonthly = minimumPackageMonthly;
	}

	public Long getStartTiming() {
		return startTiming;
	}

	public void setStartTiming(Long startTiming) {
		this.startTiming = startTiming;
	}

	public Long getEndTiming() {
		return endTiming;
	}

	public void setEndTiming(Long endTiming) {
		this.endTiming = endTiming;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public BigDecimal getOTI() {
		return OTI;
	}

	public void setOTI(BigDecimal oTI) {
		OTI = oTI;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public Package()
	{

	}

	public Long getId() {
		return id;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Timestamp getValidity() {
		return validity;
	}

	public String getSuplyHours() {
		return suplyHours;
	}

	public BigDecimal getMaxLoadPerDay() {
		return maxLoadPerDay;
	}

	public BigDecimal getTotalLoad() {
		return totalLoad;
	}

//	public Timestamp getAddedOn() {
//		return addedOn;
//	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public String getCreated_by() {
		return created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setValidity(Timestamp validity) {
		this.validity = validity;
	}

	public void setSuplyHours(String suplyHours) {
		this.suplyHours = suplyHours;
	}

	public void setMaxLoadPerDay(BigDecimal maxLoadPerDay) {
		this.maxLoadPerDay = maxLoadPerDay;
	}

	public void setTotalLoad(BigDecimal totalLoad) {
		this.totalLoad = totalLoad;
	}

//	public void setAddedOn(Timestamp addedOn) {
//		this.addedOn = addedOn;
//	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}



}
