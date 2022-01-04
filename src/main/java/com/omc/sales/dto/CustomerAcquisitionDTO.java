package com.omc.sales.dto;

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