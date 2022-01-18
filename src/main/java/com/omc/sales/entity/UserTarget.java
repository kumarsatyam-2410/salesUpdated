package com.omc.sales.entity;

import java.io.Serializable;
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
@Table(name = "customer_payment_details")
public class UserTarget implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525436262166216L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cp_id")
	private Long cpId;

	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "plant_id")
	private Integer plantId;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name="payment_amount", precision=10, scale=2)
	private BigDecimal paymentAmount;
	
	@Column(name = "payment_currency")
	private String paymentCurrency;
	
	@Column(name = "payment_date")
	private Timestamp paymentDate;
	
	@Column(name = "payment_received_user_id")
	private Integer paymentReceivedUserId;
		
	@Column(name = "remark")
	private String remark;

	
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy = "plant_id") private PlantCapacity plantCapacity;
	 */
	
	public UserTarget(){
		
	}



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



	public Integer getPaymentReceivedUserId() {
		return paymentReceivedUserId;
	}



	public void setPaymentReceivedUserId(Integer paymentReceivedUserId) {
		this.paymentReceivedUserId = paymentReceivedUserId;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "CustomerPaymentDetails [cpId=" + cpId + ", customerId=" + customerId + ", plantId=" + plantId
				+ ", paymentMode=" + paymentMode + ", paymentAmount=" + paymentAmount + ", paymentCurrency="
				+ paymentCurrency + ", paymentDate=" + paymentDate + ", paymentReceivedUserId=" + paymentReceivedUserId
				+ ", remark=" + remark + "]";
	}
	
	
	}
