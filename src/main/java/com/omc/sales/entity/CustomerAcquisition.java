package com.omc.sales.entity;

import java.math.BigDecimal;
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
	
	@Column(name = "customer_uid")
	private String customerUserId;
	
	@Column(name = "recharge_no")
	private String rechargeNo;
	
	@Column(name = "cust_type")
	private String customerType;
	
	@Column(name = "package_id")
	private Long packageId;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "payment_date")
	private Timestamp paymentDate;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "payment_currency")
	private String paymentCurrency;
	
	@Column(name = "fathers_name")
	private String fathersName;
	
	@Column(name = "husband_name")
	private String husbandName;
	
	@Column(name = "con_address")
	private String conAddress;
	
	@Column(name = "con_village")
	private String conVillage;
	
	@Column(name = "con_tehsil")
	private String conTehsil;
	
	@Column(name = "con_postoffice")
	private String conPostoffice;
	
	@Column(name = "con_pincode")
	private String conPincode;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "permanent_village")
	private String permanentVillage;
	
	@Column(name = "permanent_tehsil")
	private String permanentTehsil;
	
	@Column(name = "permanent_postoffice")
	private String permanentPostoffice;
	
	@Column(name = "permanent_pincode")
	private String permanentPincode;
	
	@Column(name = "id_proof_type")
	private String idProofType;
	
	@Column(name = "id_prof_doc_no")
	private String idProfDocNo;
	
	@Column(name = "address_proof_type")
	private String addressProofType;

	@Column(name = "address_proof_doc_no")
	private String addressProofDocNo;
	
	@Column(name = "nature_of_supply")
	private String natureOfSupply;
	
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

	public String getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}

	public String getRechargeNo() {
		return rechargeNo;
	}

	public void setRechargeNo(String rechargeNo) {
		this.rechargeNo = rechargeNo;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getConAddress() {
		return conAddress;
	}

	public void setConAddress(String conAddress) {
		this.conAddress = conAddress;
	}

	public String getConVillage() {
		return conVillage;
	}

	public void setConVillage(String conVillage) {
		this.conVillage = conVillage;
	}

	public String getConTehsil() {
		return conTehsil;
	}

	public void setConTehsil(String conTehsil) {
		this.conTehsil = conTehsil;
	}

	public String getConPostoffice() {
		return conPostoffice;
	}

	public void setConPostoffice(String conPostoffice) {
		this.conPostoffice = conPostoffice;
	}

	public String getConPincode() {
		return conPincode;
	}

	public void setConPincode(String conPincode) {
		this.conPincode = conPincode;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentVillage() {
		return permanentVillage;
	}

	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}

	public String getPermanentTehsil() {
		return permanentTehsil;
	}

	public void setPermanentTehsil(String permanentTehsil) {
		this.permanentTehsil = permanentTehsil;
	}

	public String getPermanentPostoffice() {
		return permanentPostoffice;
	}

	public void setPermanentPostoffice(String permanentPostoffice) {
		this.permanentPostoffice = permanentPostoffice;
	}

	public String getPermanentPincode() {
		return permanentPincode;
	}

	public void setPermanentPincode(String permanentPincode) {
		this.permanentPincode = permanentPincode;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProfDocNo() {
		return idProfDocNo;
	}

	public void setIdProfDocNo(String idProfDocNo) {
		this.idProfDocNo = idProfDocNo;
	}

	public String getAddressProofType() {
		return addressProofType;
	}

	public void setAddressProofType(String addressProofType) {
		this.addressProofType = addressProofType;
	}

	public String getAddressProofDocNo() {
		return addressProofDocNo;
	}

	public void setAddressProofDocNo(String addressProofDocNo) {
		this.addressProofDocNo = addressProofDocNo;
	}

	public String getNatureOfSupply() {
		return natureOfSupply;
	}

	public void setNatureOfSupply(String natureOfSupply) {
		this.natureOfSupply = natureOfSupply;
	}



}
