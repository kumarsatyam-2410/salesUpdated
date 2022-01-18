package com.omc.sales.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Users.
 */
@Entity
@Table(name = "rms_sll_customer_mapping")
public class SllCustomer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sc_id")
	private Long scId;


	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="sll_id", nullable=false)
	private PollSll pollSll;
	
	@Column(name = "added_on")
	private Timestamp addedOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;
	
	
	public SllCustomer(){
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getScId() {
		return scId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public PollSll getPollSll() {
		return pollSll;
	}


	public Timestamp getAddedOn() {
		return addedOn;
	}


	public Timestamp getUpdatedOn() {
		return updatedOn;
	}


	public void setScId(Long scId) {
		this.scId = scId;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setPollSll(PollSll pollSll) {
		this.pollSll = pollSll;
	}


	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}


	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}



	
	
}
