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

	@Column(name = "history_created_on")
	private Timestamp historyCreatedOn;
	
	
	@Column(name = "cust_acq_id")
	private Long cust_acq_id;

	public Long getCust_acq_id() {
		return cust_acq_id;
	}

	public void setCust_acq_id(Long cust_acq_id) {
		this.cust_acq_id = cust_acq_id;
	}

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
	private String pollNo;
	
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

	public String getPollNo() {
		return pollNo;
	}

	public void setPollNo(String pollNo) {
		this.pollNo = pollNo;
	}

	public String getTypeOfEstablishment() {
		return typeOfEstablishment;
	}

	public void setTypeOfEstablishment(String typeOfEstablishment) {
		this.typeOfEstablishment = typeOfEstablishment;
	}

	public Long getPlantId() {
		return plantId;
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

	public String getAcquisition_status() {
		return acquisition_status;
	}

	public String getUpload_caf_path() {
		return upload_caf_path;
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

	public String getUpload_installation_certificate() {
		return upload_installation_certificate;
	}

	public boolean isActive() {
		return isActive;
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

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public void setAcquisition_status(String acquisition_status) {
		this.acquisition_status = acquisition_status;
	}

	public void setUpload_caf_path(String upload_caf_path) {
		this.upload_caf_path = upload_caf_path;
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

	public void setUpload_installation_certificate(String upload_installation_certificate) {
		this.upload_installation_certificate = upload_installation_certificate;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public CustomerAcquisitionHistory()
	{

	}

	public Long getId() {
		return id;
	}

	public Timestamp getHistoryCreatedOn() {
		return historyCreatedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHistoryCreatedOn(Timestamp historyCreatedOn) {
		this.historyCreatedOn = historyCreatedOn;
	}


}
