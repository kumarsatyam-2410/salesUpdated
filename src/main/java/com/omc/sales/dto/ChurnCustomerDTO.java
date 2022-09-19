package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;


public class ChurnCustomerDTO {
	
    private Long id;
  
	private Long customerId;
	
	private String customerName;

	private String gender;

	private String address;

	private String zipcode;

	private String mobile;

	private String adharNumber;

	private String packageType;

	private String subscriptionType;
	
	private String customerPic;

	private String latitude;

	private String longitude;

	private Timestamp subscriptionStartDate;

	private Timestamp subscriptionEndDate;

	private Timestamp lastSuccessSubscriptionDate;

	private Timestamp addedOn;

	private boolean isActive;

	private String customerStatus;
	
	private int salesExecutiveId;

	private Long custAcqId;

	private int plantId;
	
	private Long omcId;

	private String customerUid;
	
	private String led;

	private String smallBoard;
	
	private String bigBoard;

	private BigDecimal wireMeter;

	private Long pollNo;

	private String fatherHusbandName;

	private String deviceConnected;

	private String spiCategory;

	private Date liveDate;
     
	private String customerType;

	private BigDecimal SubscriptionPackageAmount;

	private Long SubscriptionPackageId;

	private String type;

	private Date dateCancellHoldUnhold;

	private String remarks;

	private String typeOfEstablishment;

	private Long currentPackageId;

	private String cafNo;

	private String sll;

	private Long noOfRcb;

	private String billingType;

	private int createdBy;

	private int activatedBy;
	
	private int paymentBy;

	private BigDecimal currentPackageAmount;
	
	private String typeOfBoard;
	
	private String installationCertificate;
	
	private String unSubscribe;
	
	private Timestamp graceExpiryDate;
	
	public String getUnSubscribe() {
		return unSubscribe;
	}

	public void setUnSubscribe(String unSubscribe) {
		this.unSubscribe = unSubscribe;
	}

	public Timestamp getGraceExpiryDate() {
		return graceExpiryDate;
	}

	public void setGraceExpiryDate(Timestamp graceExpiryDate) {
		this.graceExpiryDate = graceExpiryDate;
	}

	public void setSubscriptionPackageId(Long subscriptionPackageId) {
		SubscriptionPackageId = subscriptionPackageId;
	}

	public ChurnCustomerDTO() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getCustomerPic() {
		return customerPic;
	}

	public void setCustomerPic(String customerPic) {
		this.customerPic = customerPic;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Timestamp getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(Timestamp subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public Timestamp getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Timestamp subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public Timestamp getLastSuccessSubscriptionDate() {
		return lastSuccessSubscriptionDate;
	}

	public void setLastSuccessSubscriptionDate(Timestamp lastSuccessSubscriptionDate) {
		this.lastSuccessSubscriptionDate = lastSuccessSubscriptionDate;
	}

	public Timestamp getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public int getSalesExecutiveId() {
		return salesExecutiveId;
	}

	public void setSalesExecutiveId(int salesExecutiveId) {
		this.salesExecutiveId = salesExecutiveId;
	}

	public Long getCustAcqId() {
		return custAcqId;
	}

	public void setCustAcqId(Long custAcqId) {
		this.custAcqId = custAcqId;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public Long getOmcId() {
		return omcId;
	}

	public void setOmcId(Long omcId) {
		this.omcId = omcId;
	}

	public String getCustomerUid() {
		return customerUid;
	}

	public void setCustomerUid(String customerUid) {
		this.customerUid = customerUid;
	}

	public String getLed() {
		return led;
	}

	public void setLed(String led) {
		this.led = led;
	}

	public String getSmallBoard() {
		return smallBoard;
	}

	public void setSmallBoard(String smallBoard) {
		this.smallBoard = smallBoard;
	}

	public String getBigBoard() {
		return bigBoard;
	}

	public void setBigBoard(String bigBoard) {
		this.bigBoard = bigBoard;
	}

	public BigDecimal getWireMeter() {
		return wireMeter;
	}

	public void setWireMeter(BigDecimal wireMeter) {
		this.wireMeter = wireMeter;
	}

	public Long getPollNo() {
		return pollNo;
	}

	public void setPollNo(Long pollNo) {
		this.pollNo = pollNo;
	}

	public String getFatherHusbandName() {
		return fatherHusbandName;
	}

	public void setFatherHusbandName(String fatherHusbandName) {
		this.fatherHusbandName = fatherHusbandName;
	}

	public String getDeviceConnected() {
		return deviceConnected;
	}

	public void setDeviceConnected(String deviceConnected) {
		this.deviceConnected = deviceConnected;
	}

	public String getSpiCategory() {
		return spiCategory;
	}

	public void setSpiCategory(String spiCategory) {
		this.spiCategory = spiCategory;
	}

	public Date getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public BigDecimal getSubscriptionPackageAmount() {
		return SubscriptionPackageAmount;
	}

	public void setSubscriptionPackageAmount(BigDecimal subscriptionPackageAmount) {
		SubscriptionPackageAmount = subscriptionPackageAmount;
	}

	public Long getSubscriptionPackageId() {
		return SubscriptionPackageId;
	}

	public void setSubscription_Package_id(Long subscriptionPackageId) {
		SubscriptionPackageId = subscriptionPackageId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateCancellHoldUnhold() {
		return dateCancellHoldUnhold;
	}

	public void setDateCancellHoldUnhold(Date dateCancellHoldUnhold) {
		this.dateCancellHoldUnhold = dateCancellHoldUnhold;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTypeOfEstablishment() {
		return typeOfEstablishment;
	}

	public void setTypeOfEstablishment(String typeOfEstablishment) {
		this.typeOfEstablishment = typeOfEstablishment;
	}

	public Long getCurrentPackageId() {
		return currentPackageId;
	}

	public void setCurrentPackageId(Long currentPackageId) {
		this.currentPackageId = currentPackageId;
	}

	public String getCafNo() {
		return cafNo;
	}

	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
	}

	public String getSll() {
		return sll;
	}

	public void setSll(String sll) {
		this.sll = sll;
	}

	public Long getNoOfRcb() {
		return noOfRcb;
	}

	public void setNoOfRcb(Long noOfRcb) {
		this.noOfRcb = noOfRcb;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(int activatedBy) {
		this.activatedBy = activatedBy;
	}

	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public BigDecimal getCurrentPackageAmount() {
		return currentPackageAmount;
	}

	public void setCurrentPackageAmount(BigDecimal currentPackageAmount) {
		this.currentPackageAmount = currentPackageAmount;
	}

	public String getTypeOfBoard() {
		return typeOfBoard;
	}

	public void setTypeOfBoard(String typeOfBoard) {
		this.typeOfBoard = typeOfBoard;
	}

	public String getInstallationCertificate() {
		return installationCertificate;
	}

	public void setInstallationCertificate(String installationCertificate) {
		this.installationCertificate = installationCertificate;
	}
	
	
}
