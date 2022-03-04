package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * The Class CustomerDTO.
 */
public class CustomerAcquisitionDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public CustomerAcquisitionDTO() {

	}

	private Long id;

	private String customerName;
	
	private String plantId;

	private String gender;

	private String address;

	private String zipcode;
	
	private String abhApprovalStatus;

	private String salesheadApprovalStatus;
	
	public String getAbhApprovalStatus() {
		return abhApprovalStatus;
	}

	public void setAbhApprovalStatus(String abhApprovalStatus) {
		this.abhApprovalStatus = abhApprovalStatus;
	}

	public String getSalesheadApprovalStatus() {
		return salesheadApprovalStatus;
	}

	public void setSalesheadApprovalStatus(String salesheadApprovalStatus) {
		this.salesheadApprovalStatus = salesheadApprovalStatus;
	}

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
	
	private String acquisition_status;
	
	private String upload_caf_path;
	private String upload_installation_certificate;
	private int no_board_installation_required;
	private int no_sll_installation_required;
	private int no_rcbs_installation_required;
	private int no_polls_installation_required;
	private int no_wire_in_meter_required;
	
	private String customerUserId;
	
	private String rechargeNo;
	
	private String customerType;
	
	private Long packageId;
	
	private BigDecimal amount;
	
	private Timestamp paymentDate;
	
	private String paymentStatus;
	
	private String paymentMode;
	
	private String paymentCurrency;
	
	private String fathersName;
	
	private String husbandName;
	
	private String conAddress;
	
	private String conVillage;
	
	private String conTehsil;
	
	private String conPostoffice;
	
	private String conPincode;
	
	private String permanentAddress;
	
	private String permanentVillage;
	
	private String permanentTehsil;
	
	private String permanentPostoffice;
	
	private String permanentPincode;
	
	private String idProofType;
	
	private String idProfDocNo;
	
	private String addressProofType;

	private String addressProofDocNo;
	
    private String natureOfSupply;
	
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

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getAcquisition_status() {
		return acquisition_status;
	}

	public String getUpload_caf_path() {
		return upload_caf_path;
	}

	public String getUpload_installation_certificate() {
		return upload_installation_certificate;
	}

	public int getNo_board_installation_required() {
		return no_board_installation_required;
	}

	public int getNo_sll_installation_required() {
		return no_sll_installation_required;
	}

	public int getNo_rcbs_installation_required() {
		return no_rcbs_installation_required;
	}

	public int getNo_polls_installation_required() {
		return no_polls_installation_required;
	}

	public int getNo_wire_in_meter_required() {
		return no_wire_in_meter_required;
	}

	public void setAcquisition_status(String acquisition_status) {
		this.acquisition_status = acquisition_status;
	}

	public void setUpload_caf_path(String upload_caf_path) {
		this.upload_caf_path = upload_caf_path;
	}

	public void setUpload_installation_certificate(String upload_installation_certificate) {
		this.upload_installation_certificate = upload_installation_certificate;
	}

	public void setNo_board_installation_required(int no_board_installation_required) {
		this.no_board_installation_required = no_board_installation_required;
	}

	public void setNo_sll_installation_required(int no_sll_installation_required) {
		this.no_sll_installation_required = no_sll_installation_required;
	}

	public void setNo_rcbs_installation_required(int no_rcbs_installation_required) {
		this.no_rcbs_installation_required = no_rcbs_installation_required;
	}

	public void setNo_polls_installation_required(int no_polls_installation_required) {
		this.no_polls_installation_required = no_polls_installation_required;
	}

	public void setNo_wire_in_meter_required(int no_wire_in_meter_required) {
		this.no_wire_in_meter_required = no_wire_in_meter_required;
	}

}