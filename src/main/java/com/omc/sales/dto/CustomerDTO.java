package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;

/**
 * The Class CustomerDTO.
 */
public class CustomerDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public CustomerDTO() {

	}

	private Long id;

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
	
	private BigDecimal wire_meter;
	
	private Long poll_no;
	
	private String fatherHusbandName;
	
	private String deviceConnected;
	
	private String spiCategory;
	
	private Date liveDate;
	
	private String customerType;   
	
	private BigDecimal SubscriptionPackageAmount;

	private Long Subscription_Package_id;
	
	private String type;
	
	private Date date_cancell_hold_unhold;
	
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

	private Timestamp lastExpiryDate;
	
	private Timestamp churnDate;

	private String unsubType;
	
	private String aadharPicFront;
	
	private String aadharPicBack;

	public String getAadharPicFront() {
		return aadharPicFront;
	}

	public void setAadharPicFront(String aadharPicFront) {
		this.aadharPicFront = aadharPicFront;
	}

	public String getAadharPicBack() {
		return aadharPicBack;
	}

	public void setAadharPicBack(String aadharPicBack) {
		this.aadharPicBack = aadharPicBack;
	}

	public Timestamp getChurnDate() {
		return churnDate;
	}

	public void setChurnDate(Timestamp churnDate) {
		this.churnDate = churnDate;
	}

	public String getUnsubType() {
		return unsubType;
	}

	public void setUnsubType(String unsubType) {
		this.unsubType = unsubType;
	}

	public String getUnSubscribe() {
		return unSubscribe;
	}

	public void setUnSubscribe(String unSubscribe) {
		this.unSubscribe = unSubscribe;
	}

	
	public Timestamp getLastExpiryDate() {
		return lastExpiryDate;
	}

	public void setLastExpiryDate(Timestamp lastExpiryDate) {
		this.lastExpiryDate = lastExpiryDate;
	}

	public String getInstallationCertificate() {
		return installationCertificate;
	}

	public void setInstallationCertificate(String installationCertificate) {
		this.installationCertificate = installationCertificate;
	}

	public String getTypeOfBoard() {
		return typeOfBoard;
	}

	public void setTypeOfBoard(String typeOfBoard) {
		this.typeOfBoard = typeOfBoard;
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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

	public Long getCurrentPackageId() {
		return currentPackageId;
	}

	public void setCurrentPackageId(Long currentPackageId) {
		this.currentPackageId = currentPackageId;
	}

	public BigDecimal getCurrentPackageAmount() {
		return currentPackageAmount;
	}

	public void setCurrentPackageAmount(BigDecimal currentPackageAmount) {
		currentPackageAmount = currentPackageAmount;
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

	public BigDecimal getWire_meter() {
		return wire_meter;
	}

	public void setWire_meter(BigDecimal wire_meter) {
		this.wire_meter = wire_meter;
	}

	public Long getPoll_no() {
		return poll_no;
	}

	public void setPoll_no(Long poll_no) {
		this.poll_no = poll_no;
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

	public Long getSubscription_Package_id() {
		return Subscription_Package_id;
	}

	public void setSubscription_Package_id(Long subscription_Package_id) {
		Subscription_Package_id = subscription_Package_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate_cancell_hold_unhold() {
		return date_cancell_hold_unhold;
	}

	public void setDate_cancell_hold_unhold(Date date_cancell_hold_unhold) {
		this.date_cancell_hold_unhold = date_cancell_hold_unhold;
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

	public Long getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public String getPackageType() {
		return packageType;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public String getCustomerPic() {
		return customerPic;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public Timestamp getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public Timestamp getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public Timestamp getLastSuccessSubscriptionDate() {
		return lastSuccessSubscriptionDate;
	}

	public Timestamp getAddedOn() {
		return addedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public void setCustomerPic(String customerPic) {
		this.customerPic = customerPic;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setSubscriptionStartDate(Timestamp subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public void setSubscriptionEndDate(Timestamp subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public void setLastSuccessSubscriptionDate(Timestamp lastSuccessSubscriptionDate) {
		this.lastSuccessSubscriptionDate = lastSuccessSubscriptionDate;
	}

	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
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

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", customerName=" + customerName + ", gender=" + gender + ", address="
				+ address + ", zipcode=" + zipcode + ", mobile=" + mobile + ", adharNumber=" + adharNumber
				+ ", packageType=" + packageType + ", subscriptionType=" + subscriptionType + ", customerPic="
				+ customerPic + ", latitude=" + latitude + ", longitude=" + longitude + ", subscriptionStartDate="
				+ subscriptionStartDate + ", subscriptionEndDate=" + subscriptionEndDate
				+ ", lastSuccessSubscriptionDate=" + lastSuccessSubscriptionDate + ", addedOn=" + addedOn
				+ ", isActive=" + isActive + ", customerStatus=" + customerStatus + ", salesExecutiveId="
				+ salesExecutiveId + ", custAcqId=" + custAcqId + ", plantId=" + plantId + "]";
	}





	

}