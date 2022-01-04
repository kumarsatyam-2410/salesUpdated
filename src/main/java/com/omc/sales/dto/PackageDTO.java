package com.omc.sales.dto;

import java.sql.Timestamp;

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
	
	private String amount;
	
	private Timestamp validity;
	
	private String suplyHours;
	
	private String maxLoadPerDay;
	
	private String totalLoad;
	
	private String created_by;
	
	private String updated_by;

	private Timestamp addedOn;
	
	private Timestamp updatedOn;
	
	private boolean isActive;

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


	public String getAmount() {
		return amount;
	}


	public Timestamp getValidity() {
		return validity;
	}


	public String getSuplyHours() {
		return suplyHours;
	}


	public String getMaxLoadPerDay() {
		return maxLoadPerDay;
	}


	public String getTotalLoad() {
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


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public void setValidity(Timestamp validity) {
		this.validity = validity;
	}


	public void setSuplyHours(String suplyHours) {
		this.suplyHours = suplyHours;
	}


	public void setMaxLoadPerDay(String maxLoadPerDay) {
		this.maxLoadPerDay = maxLoadPerDay;
	}


	public void setTotalLoad(String totalLoad) {
		this.totalLoad = totalLoad;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}






	

}