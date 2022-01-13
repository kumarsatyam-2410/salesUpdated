package com.omc.sales.dto;

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

	private Integer plantId;

	private String paymentMode;

	private BigDecimal paymentAmount;
	
	private String paymentCurrency;
	
	private Timestamp paymentDate;
	
	private Timestamp paymentReceivedUserId;
		
	private String remark;

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

	public Timestamp getPaymentReceivedUserId() {
		return paymentReceivedUserId;
	}

	public void setPaymentReceivedUserId(Timestamp paymentReceivedUserId) {
		this.paymentReceivedUserId = paymentReceivedUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CustomerPaymentDTO [cpId=" + cpId + ", customerId=" + customerId + ", plantId=" + plantId
				+ ", paymentMode=" + paymentMode + ", paymentAmount=" + paymentAmount + ", paymentCurrency="
				+ paymentCurrency + ", paymentDate=" + paymentDate + ", paymentReceivedUserId=" + paymentReceivedUserId
				+ ", remark=" + remark + "]";
	}

}