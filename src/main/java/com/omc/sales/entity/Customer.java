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

/**
 * The Class Users.   `customer_id` `customername` `email` `password` `temp_password` `mobile` `role` `added_on` `updated_on` 
 */ 
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "mobile_no")
	private String mobile;

	@Column(name = "adhar_no")
	private String adharNumber;

	@Column(name = "package_type")
	private String packageType;

	@Column(name = "subscription_type")
	private String subscriptionType;
	
	@Column(name = "customer_pic")
	private String customerPic;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

	@Column(name = "subscription_start_date")
	private Timestamp subscriptionStartDate;
	@Column(name = "subscription_end_date")
	private Timestamp subscriptionEndDate;
	@Column(name = "last_success_subscription_date")
	private Timestamp lastSuccessSubscriptionDate;

//	@Column(name = "added_on")
//	private Timestamp addedOn;
	
	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "customer_status")
	private String customerStatus;
	
	@Column(name = "sales_executive_id")
	private int salesExecutiveId;
	
	@Column(name = "cust_acq_id")
	private Long custAcqId;
	
	@Column(name = "plant_id")
	private int plantId;
	
	@Column(name = "omc_id")
	private Long omcId;
	
	@Column(name = "customer_uid")
	private String customerUid;
	
	@Column(name = "led")
	private String led;
	
	@Column(name = "small_board")
	private String smallBoard;
	
	@Column(name = "big_board")
	private String bigBoard;
	
	@Column(name = "wire_meter")
	private BigDecimal wire_meter;
	
	@Column(name = "poll_no")
	private Long poll_no;
	
	@Column(name = "father_husband_name")
	private String fatherHusbandName;
	
	@Column(name = "device_connected")
	private String deviceConnected;
	
	@Column(name = "spi_category")
	private String spiCategory;
	
	@Column(name = "live_date")
	private Date liveDate;
	
	@Column(name = "customer_type")       /////////////////////
	private String customerType;
	
	@Column(name = "Subscription_Package_amount")
	private BigDecimal SubscriptionPackageAmount;
	
	@Column(name = "Subscription_Package_id")
	private Long Subscription_Package_id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "date_cancell_hold_unhold")
	private Date date_cancell_hold_unhold;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "type_of_establishment")
	private String typeOfEstablishment;
	
	@Column(name = "current_package_id")
	private Long currentPackageId;
	
	@Column(name = "caf_no")
	private String cafNo;
	
	@Column(name = "sll")
	private Long sll;
	
	@Column(name = "no_of_rcb")
	private Long noOfRcb;
	
	@Column(name = "billing_type")
	private String billingType;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "activated_by")
	private int activatedBy;
	
	@Column(name = "payment_by")
	private int paymentBy;
	
	
	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public int getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(int activatedBy) {
		this.activatedBy = activatedBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public Long getSll() {
		return sll;
	}

	public void setSll(Long sll) {
		this.sll = sll;
	}

	public Long getNoOfRcb() {
		return noOfRcb;
	}

	public void setNoOfRcb(Long noOfRcb) {
		this.noOfRcb = noOfRcb;
	}

	public String getCafNo() {
		return cafNo;
	}

	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
	}

	public Long getCurrentPackageId() {
		return currentPackageId;
	}

	public void setCurrentPackageId(Long currentPackageId) {
		this.currentPackageId = currentPackageId;
	}

	@Column(name = "Current_Package_amount")
	private BigDecimal CurrentPackageAmount;
	
	public BigDecimal getCurrentPackageAmount() {
		return CurrentPackageAmount;
	}

	public void setCurrentPackageAmount(BigDecimal currentPackageAmount) {
		CurrentPackageAmount = currentPackageAmount;
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

	
	public String getTypeOfEstablishment() {
		return typeOfEstablishment;
	}

	public void setTypeOfEstablishment(String typeOfEstablishment) {
		this.typeOfEstablishment = typeOfEstablishment;
	}

	public Long getOmcId() {
		return omcId;
	}

	public void setOmcId(Long omcId) {
		this.omcId = omcId;
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

	public Customer()
	{

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

//	public Timestamp getAddedOn() {
//		return addedOn;
//	}

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

//	public void setAddedOn(Timestamp addedOn) {
//		this.addedOn = addedOn;
//	}

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
		return "Customer [id=" + id + ", customerName=" + customerName + ", gender=" + gender + ", address=" + address
				+ ", zipcode=" + zipcode + ", mobile=" + mobile + ", adharNumber=" + adharNumber + ", packageType="
				+ packageType + ", subscriptionType=" + subscriptionType + ", customerPic=" + customerPic
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", subscriptionStartDate="
				+ subscriptionStartDate + ", subscriptionEndDate=" + subscriptionEndDate
				+ ", lastSuccessSubscriptionDate=" + lastSuccessSubscriptionDate + ", isActive=" + isActive
				+ ", customerStatus=" + customerStatus + ", salesExecutiveId=" + salesExecutiveId + ", custAcqId="
				+ custAcqId + ", plantId=" + plantId + "]";
	}


}
