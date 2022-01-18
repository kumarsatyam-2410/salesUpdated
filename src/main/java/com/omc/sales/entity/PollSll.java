package com.omc.sales.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Users.
 */
@Entity
@Table(name = "rms_poll_sll_mapping")
public class PollSll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "psll_id")
	private Long psId;

	@Column(name = "sll_number")
	private Long sllNumber;

	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="poll_id", nullable=false)
	private PlantPoll plantPoll;
	
	@OneToMany(mappedBy = "pollSll")
	private Set<SllCustomer> sllCustomers;
	
	public Set<SllCustomer> getSllCustomers() {
		return sllCustomers;
	}


	public void setSllCustomers(Set<SllCustomer> sllCustomers) {
		this.sllCustomers = sllCustomers;
	}


	@Column(name = "added_on")
	private Timestamp addedOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;
	
	
	public PollSll(){
		
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getPsId() {
		return psId;
	}


	public Long getSllNumber() {
		return sllNumber;
	}


	public PlantPoll getPlantPoll() {
		return plantPoll;
	}


	public Timestamp getAddedOn() {
		return addedOn;
	}


	public Timestamp getUpdatedOn() {
		return updatedOn;
	}


	public void setPsId(Long psId) {
		this.psId = psId;
	}


	public void setSllNumber(Long sllNumber) {
		this.sllNumber = sllNumber;
	}


	public void setPlantPoll(PlantPoll plantPoll) {
		this.plantPoll = plantPoll;
	}


	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}


	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}


	
	
}
