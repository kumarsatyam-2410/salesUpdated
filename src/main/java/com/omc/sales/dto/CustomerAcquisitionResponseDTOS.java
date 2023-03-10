package com.omc.sales.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CustomerAcquisitionResponseDTOS {
	
	private Long id;

	private String customerName;
	
	private String plantId;

	private String gender;
	
	private String address;

	private String zipcode;
	
	private String abhApprovalStatus;

	private String salesheadApprovalStatus;
	
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
    
	private Long omcId;
	
	private BigDecimal SubscriptionPackageAmount;
	
	private Long SubscriptionPackageId;
	
	private String spiCategory;
	
	private String deviceConnected;
	
	private String led;
	
	private String smallBoard;
	
	private String bigBoard;
	
	private Long pollNo;
	
	private String professionOccupation;
	
	private String connectionAddressDistrict;
	
	private String PermanentAddressDistrict;
	
	private String permanentAddressProofType;
	
	private String permanentAddressDocNo;
	
	private String plantName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
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

	public String getAcquisition_status() {
		return acquisition_status;
	}

	public void setAcquisition_status(String acquisition_status) {
		this.acquisition_status = acquisition_status;
	}

	public String getUpload_caf_path() {
		return upload_caf_path;
	}

	public void setUpload_caf_path(String upload_caf_path) {
		this.upload_caf_path = upload_caf_path;
	}

	public String getUpload_installation_certificate() {
		return upload_installation_certificate;
	}

	public void setUpload_installation_certificate(String upload_installation_certificate) {
		this.upload_installation_certificate = upload_installation_certificate;
	}

	public int getNo_board_installation_required() {
		return no_board_installation_required;
	}

	public void setNo_board_installation_required(int no_board_installation_required) {
		this.no_board_installation_required = no_board_installation_required;
	}

	public int getNo_sll_installation_required() {
		return no_sll_installation_required;
	}

	public void setNo_sll_installation_required(int no_sll_installation_required) {
		this.no_sll_installation_required = no_sll_installation_required;
	}

	public int getNo_rcbs_installation_required() {
		return no_rcbs_installation_required;
	}

	public void setNo_rcbs_installation_required(int no_rcbs_installation_required) {
		this.no_rcbs_installation_required = no_rcbs_installation_required;
	}

	public int getNo_polls_installation_required() {
		return no_polls_installation_required;
	}

	public void setNo_polls_installation_required(int no_polls_installation_required) {
		this.no_polls_installation_required = no_polls_installation_required;
	}

	public int getNo_wire_in_meter_required() {
		return no_wire_in_meter_required;
	}

	public void setNo_wire_in_meter_required(int no_wire_in_meter_required) {
		this.no_wire_in_meter_required = no_wire_in_meter_required;
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

	public Long getOmcId() {
		return omcId;
	}

	public void setOmcId(Long omcId) {
		this.omcId = omcId;
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

	public void setSubscriptionPackageId(Long subscriptionPackageId) {
		SubscriptionPackageId = subscriptionPackageId;
	}

	public String getSpiCategory() {
		return spiCategory;
	}

	public void setSpiCategory(String spiCategory) {
		this.spiCategory = spiCategory;
	}

	public String getDeviceConnected() {
		return deviceConnected;
	}

	public void setDeviceConnected(String deviceConnected) {
		this.deviceConnected = deviceConnected;
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

	public Long getPollNo() {
		return pollNo;
	}

	public void setPollNo(Long pollNo) {
		this.pollNo = pollNo;
	}

	public String getProfessionOccupation() {
		return professionOccupation;
	}

	public void setProfessionOccupation(String professionOccupation) {
		this.professionOccupation = professionOccupation;
	}

	public String getConnectionAddressDistrict() {
		return connectionAddressDistrict;
	}

	public void setConnectionAddressDistrict(String connectionAddressDistrict) {
		this.connectionAddressDistrict = connectionAddressDistrict;
	}

	public String getPermanentAddressDistrict() {
		return PermanentAddressDistrict;
	}

	public void setPermanentAddressDistrict(String permanentAddressDistrict) {
		PermanentAddressDistrict = permanentAddressDistrict;
	}

	public String getPermanentAddressProofType() {
		return permanentAddressProofType;
	}

	public void setPermanentAddressProofType(String permanentAddressProofType) {
		this.permanentAddressProofType = permanentAddressProofType;
	}

	public String getPermanentAddressDocNo() {
		return permanentAddressDocNo;
	}

	public void setPermanentAddressDocNo(String permanentAddressDocNo) {
		this.permanentAddressDocNo = permanentAddressDocNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	
	

}
