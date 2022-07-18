package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;



/**
 * The Class CustomerDTO.
 */
public class PackageDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public PackageDTO() {

	}

	private Long id;

	private String packageName;

	private String packageDescription;

	private String packageType;
	
	private BigDecimal amount;
	
	private Timestamp validity;
	
	private String suplyHours;
	
	private BigDecimal maxLoadPerDay;
	
	private BigDecimal totalLoad;
	
	private String created_by;
	
	private String updated_by;

	private Timestamp addedOn;
	
	private Timestamp updatedOn;
	
	private boolean isActive;
	
	private String customerType;
	
	private BigDecimal unit_price;
	
	private String billingType;
	
	private BigDecimal OTI;
	
	private int validityDays;
	
	private BigDecimal minimumPackageMonthly;
	
	private Long startTiming;
	
	private Long endTiming;
	
	private String Remarks;
	
	private int closedPackage;

	private int churn;
	
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


	public String getCustomerType() {
		return customerType;
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

	public Long getId() {
		return id;
	}


	public Timestamp getAddedOn() {
		return addedOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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


	public String getCreated_by() {
		return created_by;
	}


	public String getUpdated_by() {
		return updated_by;
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


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}






	

}