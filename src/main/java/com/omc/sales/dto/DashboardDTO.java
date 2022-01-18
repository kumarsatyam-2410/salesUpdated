package com.omc.sales.dto;

public class DashboardDTO {

	private String userId;
	private String userEmail;
	
	private CustomerData customerData;
	private RevenueData revenueData;
	private ActivationData activationData;
	private BusinessInventory businessInventory;
	
	public class CustomerData{
		private String totalCustomerAcquired;
		private String totalCustomerAcquiredCurrentMonth;
		private String targetCustomerAcquired;
		private String targetCustomerAcquiredCurrentMonth;
		public String getTotalCustomerAcquired() {
			return totalCustomerAcquired;
		}
		public String getTotalCustomerAcquiredCurrentMonth() {
			return totalCustomerAcquiredCurrentMonth;
		}
		public String getTargetCustomerAcquired() {
			return targetCustomerAcquired;
		}
		public String getTargetCustomerAcquiredCurrentMonth() {
			return targetCustomerAcquiredCurrentMonth;
		}
		public void setTotalCustomerAcquired(String totalCustomerAcquired) {
			this.totalCustomerAcquired = totalCustomerAcquired;
		}
		public void setTotalCustomerAcquiredCurrentMonth(String totalCustomerAcquiredCurrentMonth) {
			this.totalCustomerAcquiredCurrentMonth = totalCustomerAcquiredCurrentMonth;
		}
		public void setTargetCustomerAcquired(String targetCustomerAcquired) {
			this.targetCustomerAcquired = targetCustomerAcquired;
		}
		public void setTargetCustomerAcquiredCurrentMonth(String targetCustomerAcquiredCurrentMonth) {
			this.targetCustomerAcquiredCurrentMonth = targetCustomerAcquiredCurrentMonth;
		}
	}

	public class RevenueData{
		private String totalRevenue;
		private String totalRevenueCurrentMonth;
		private String targetRevenue;
		private String targetRevenueCurrentMonth;
		public String getTotalRevenue() {
			return totalRevenue;
		}
		public String getTotalRevenueCurrentMonth() {
			return totalRevenueCurrentMonth;
		}
		public String getTargetRevenue() {
			return targetRevenue;
		}
		public String getTargetRevenueCurrentMonth() {
			return targetRevenueCurrentMonth;
		}
		public void setTotalRevenue(String totalRevenue) {
			this.totalRevenue = totalRevenue;
		}
		public void setTotalRevenueCurrentMonth(String totalRevenueCurrentMonth) {
			this.totalRevenueCurrentMonth = totalRevenueCurrentMonth;
		}
		public void setTargetRevenue(String targetRevenue) {
			this.targetRevenue = targetRevenue;
		}
		public void setTargetRevenueCurrentMonth(String targetRevenueCurrentMonth) {
			this.targetRevenueCurrentMonth = targetRevenueCurrentMonth;
		}
	}
	
	public class ActivationData{
		private String totalActivation;
		private String totalActivationCurrentMonth;
		private String targetActivation;
		private String targetActivationCurrentMonth;
		public String getTotalActivation() {
			return totalActivation;
		}
		public String getTotalActivationCurrentMonth() {
			return totalActivationCurrentMonth;
		}
		public String getTargetActivation() {
			return targetActivation;
		}
		public String getTargetActivationCurrentMonth() {
			return targetActivationCurrentMonth;
		}
		public void setTotalActivation(String totalActivation) {
			this.totalActivation = totalActivation;
		}
		public void setTotalActivationCurrentMonth(String totalActivationCurrentMonth) {
			this.totalActivationCurrentMonth = totalActivationCurrentMonth;
		}
		public void setTargetActivation(String targetActivation) {
			this.targetActivation = targetActivation;
		}
		public void setTargetActivationCurrentMonth(String targetActivationCurrentMonth) {
			this.targetActivationCurrentMonth = targetActivationCurrentMonth;
		}
	}
	
	public class BusinessInventory{
		private String totalPoles;
		private String totalMeters;
		private String totalKits;
		public String getTotalPoles() {
			return totalPoles;
		}
		public String getTotalMeters() {
			return totalMeters;
		}
		public String getTotalKits() {
			return totalKits;
		}
		public void setTotalPoles(String totalPoles) {
			this.totalPoles = totalPoles;
		}
		public void setTotalMeters(String totalMeters) {
			this.totalMeters = totalMeters;
		}
		public void setTotalKits(String totalKits) {
			this.totalKits = totalKits;
		}
	}

	public String getUserId() {
		return userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public CustomerData getCustomerData() {
		return customerData;
	}

	public RevenueData getRevenueData() {
		return revenueData;
	}

	public ActivationData getActivationData() {
		return activationData;
	}

	public BusinessInventory getBusinessInventory() {
		return businessInventory;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}

	public void setRevenueData(RevenueData revenueData) {
		this.revenueData = revenueData;
	}

	public void setActivationData(ActivationData activationData) {
		this.activationData = activationData;
	}

	public void setBusinessInventory(BusinessInventory businessInventory) {
		this.businessInventory = businessInventory;
	}
	
	
	
}
