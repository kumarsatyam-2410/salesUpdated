package com.omc.sales.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Users.   
*/ 

@Entity
@Table(name = "customers_acquisition")
public class CustomerAcquisition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_acq_id")
	private Long id;

	@Column(name = "plant_id")
	private Long plantId;
	
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

	@Column(name = "acquisition_status")
	private String acquisitionStatus;

	@Column(name = "upload_caf_path")
	private String uploadCafPath;
	
	
	@Column(name = "sales_executive_id")
	private String salesExecutiveId;


	@Column(name = "subscription_start_date")
	private Timestamp subscriptionStartDate;
	
	@Column(name = "subscription_end_date")
	private Timestamp subscriptionEndDate;
	
	@Column(name = "last_success_subscription_date")
	private Timestamp lastSuccessSubscriptionDate;

	@Column(name = "upload_installation_certificate")
	private String uploadInstallationCertificate;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "no_board_installation_required")
	private Integer noBoardInstallationRequired;

	@Column(name = "no_sll_installation_required")
	private Integer noSllInstallationRequired;

	@Column(name = "no_rcbs_installation_required")
	private Integer noRcbsInstallationRequired;

	@Column(name = "no_polls_installation_required")
	private Integer noPollsInstallationRequired;

	@Column(name = "no_wire_in_meter_required")
	private Integer noWireInMeterRequired;

	public CustomerAcquisition()
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

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAcquisitionStatus() {
		return acquisitionStatus;
	}

	public String getUploadCafPath() {
		return uploadCafPath;
	}

	public String getSalesExecutiveId() {
		return salesExecutiveId;
	}

	public String getUploadInstallationCertificate() {
		return uploadInstallationCertificate;
	}

	public Integer getNoBoardInstallationRequired() {
		return noBoardInstallationRequired;
	}

	public Integer getNoSllInstallationRequired() {
		return noSllInstallationRequired;
	}

	public Integer getNoRcbsInstallationRequired() {
		return noRcbsInstallationRequired;
	}

	public Integer getNoPollsInstallationRequired() {
		return noPollsInstallationRequired;
	}

	public Integer getNoWireInMeterRequired() {
		return noWireInMeterRequired;
	}

	public void setAcquisitionStatus(String acquisitionStatus) {
		this.acquisitionStatus = acquisitionStatus;
	}

	public void setUploadCafPath(String uploadCafPath) {
		this.uploadCafPath = uploadCafPath;
	}

	public void setSalesExecutiveId(String salesExecutiveId) {
		this.salesExecutiveId = salesExecutiveId;
	}

	public void setUploadInstallationCertificate(String uploadInstallationCertificate) {
		this.uploadInstallationCertificate = uploadInstallationCertificate;
	}

	public void setNoBoardInstallationRequired(Integer noBoardInstallationRequired) {
		this.noBoardInstallationRequired = noBoardInstallationRequired;
	}

	public void setNoSllInstallationRequired(Integer noSllInstallationRequired) {
		this.noSllInstallationRequired = noSllInstallationRequired;
	}

	public void setNoRcbsInstallationRequired(Integer noRcbsInstallationRequired) {
		this.noRcbsInstallationRequired = noRcbsInstallationRequired;
	}

	public void setNoPollsInstallationRequired(Integer noPollsInstallationRequired) {
		this.noPollsInstallationRequired = noPollsInstallationRequired;
	}

	public void setNoWireInMeterRequired(Integer noWireInMeterRequired) {
		this.noWireInMeterRequired = noWireInMeterRequired;
	}



}
