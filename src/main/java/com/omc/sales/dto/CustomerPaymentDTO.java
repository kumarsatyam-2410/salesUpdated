package com.omc.sales.dto;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * The Class CustomerDTO.
 */
public class CustomerPaymentDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public CustomerPaymentDTO() {

	}

	private Long cpId;

	private Long customerId;
	
	private String customerName;

	private Integer plantId;

	private String paymentMode;

	private BigDecimal paymentAmount;
	
	private String paymentCurrency;
	
	private Timestamp paymentDate;
	
	private int paymentReceivedUserId;
		
	private String remark;


	private String razorpayPaymentId;

	private String cafNo;

	private Integer salesExecId;

	public Integer getSalesExecId() {
		return salesExecId;
	}

	public void setSalesExecId(Integer salesExecId) {
		this.salesExecId = salesExecId;
	}

	public String getCafNo() {
		return cafNo;
	}

	public void setCafNo(String cafNo) {
		this.cafNo = cafNo;
	}

	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}

	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getRazorpaySignature() {
		return razorpaySignature;
	}

	public void setRazorpaySignature(String razorpaySignature) {
		this.razorpaySignature = razorpaySignature;
	}

	private String razorpayOrderId;


	private Integer paymentStatus;


	private String razorpaySignature;



	public Long getCpId() {
		return cpId;
	}

	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentReceivedUserId() {
		return paymentReceivedUserId;
	}

	public void setPaymentReceivedUserId(int paymentReceivedUserId) {
		this.paymentReceivedUserId = paymentReceivedUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "CustomerPaymentDTO{" +
				"cpId=" + cpId +
				", customerId=" + customerId +
				", customerName='" + customerName + '\'' +
				", plantId=" + plantId +
				", paymentMode='" + paymentMode + '\'' +
				", paymentAmount=" + paymentAmount +
				", paymentCurrency='" + paymentCurrency + '\'' +
				", paymentDate=" + paymentDate +
				", paymentReceivedUserId=" + paymentReceivedUserId +
				", remark='" + remark + '\'' +
				", razorpayPaymentId='" + razorpayPaymentId + '\'' +
				", razorpayOrderId='" + razorpayOrderId + '\'' +
				", paymentStatus=" + paymentStatus +
				", razorpaySignature='" + razorpaySignature + '\'' +
				'}';
	}
}