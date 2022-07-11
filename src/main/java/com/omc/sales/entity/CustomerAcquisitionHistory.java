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
@Table(name = "customers_acquisition_history")
public class CustomerAcquisitionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_cust_acq_id")
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
	
	@Column(name = "abh_approval_status")
	private String abhApprovalStatus;
	
	@Column(name = "saleshead_approval_status")
	private String salesheadApprovalStatus;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "acquisition_status")
	private String acquisition_status;

	@Column(name = "upload_caf_path")
	private String upload_caf_path;

	@Column(name = "subscription_start_date")
	private Timestamp subscriptionStartDate;
	
	@Column(name = "subscription_end_date")
	private Timestamp subscriptionEndDate;
	
	@Column(name = "last_success_subscription_date")
	private Timestamp lastSuccessSubscriptionDate;

	@Column(name = "upload_installation_certificate")
	private String upload_installation_certificate;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "no_board_installation_required")
	private int no_board_installation_required;

	@Column(name = "no_sll_installation_required")
	private int no_sll_installation_required;

	@Column(name = "no_rcbs_installation_required")
	private int no_rcbs_installation_required;

	@Column(name = "no_polls_installation_required")
	private int no_polls_installation_required;

	@Column(name = "no_wire_in_meter_required")
	private int no_wire_in_meter_required;
	
	@Column(name = "omc_id")
	private Long omcId;
	
	@Column(name = "Subscription_Package_amount")
	private BigDecimal SubscriptionPackageAmount;
	
	@Column(name = "Subscription_Package_id")
	private Long SubscriptionPackageId;
	
	@Column(name = "spi_category")
	private String spiCategory;
	
	@Column(name = "device_connected")
	private String deviceConnected;
	
	@Column(name = "led")
	private String led;
	
	@Column(name = "small_board")
	private String smallBoard;
	
	@Column(name = "big_board")
	private String bigBoard;
	
	@Column(name = "poll_no")
	private Long pollNo;
	
	@Column(name = "type_of_establishment")
	private String typeOfEstablishment;
	
	@Column(name = "profession_occupation")
	private String professionOccupation;
	
	@Column(name = "connection_address_district")
	private String connectionAddressDistrict;
	
	@Column(name = "Permanent_address_district")
	private String PermanentAddressDistrict;
	
	@Column(name = "permanent_address_proof_type")
	private String permanentAddressProofType;
	
	@Column(name = "permanent_address_doc_no")
	private String permanentAddressDocNo;

	@Column(name = "caf_no")
	private String cafNo;
	
	@Column(name = "billing_type")
	private String billingType;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "payment_by")
	private int paymentBy;
	
	@Column(name = "type_of_board")
	private String typeOfBoard;
	
	@Column(name = "sll_no")
	private String sllNo;
	
	
	public String getSllNo() {
		return sllNo;
	}

	public void setSllNo(String sllNo) {
		this.sllNo = sllNo;
	}

	public String getTypeOfBoard() {
		return typeOfBoard;
	}

	public void setTypeOfBoard(String typeOfBoard) {
		this.typeOfBoard = typeOfBoard;
	}

	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public CustomerAcquisitionHistory() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public String getUpload_installation_certificate() {
		return upload_installation_certificate;
	}

	public void setUpload_installation_certificate(String upload_installation_certificate) {
		this.upload_installation_certificate = upload_installation_certificate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public String getTypeOfEstablishment() {
		return typeOfEstablishment;
	}

	public void setTypeOfEstablishment(String typeOfEstablishment) {
		this.typeOfEstablishment = typeOfEstablishment;
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

	public String getCafNo() {
		return cafNo;
	}

	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
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
	
	
}
