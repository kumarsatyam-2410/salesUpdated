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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Users.
 */
@Entity
@Table(name = "rms_plant_poll_mapping")
public class PlantPoll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ppoll_id")
	private Long ppId;

	@Column(name = "poll_number")
	private Long pollNumber;

	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="plant_id", nullable=false)
	private Plant plant;
	
	@OneToMany(mappedBy = "plantPoll")
	private Set<PollSll> pollSll;
	

	@Column(name = "added_on")
	private Timestamp addedOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;

      public PlantPoll(){
  		
	       }

	public Set<PollSll> getPollSll() {
		return pollSll;
	}


	public void setPollSll(Set<PollSll> pollSll) {
		this.pollSll = pollSll;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getPpId() {
		return ppId;
	}


	public Long getPollNumber() {
		return pollNumber;
	}


	public Plant getPlant() {
		return plant;
	}


	public Timestamp getAddedOn() {
		return addedOn;
	}


	public Timestamp getUpdatedOn() {
		return updatedOn;
	}


	public void setPpId(Long ppId) {
		this.ppId = ppId;
	}


	public void setPollNumber(Long pollNumber) {
		this.pollNumber = pollNumber;
	}


	public void setPlant(Plant plant) {
		this.plant = plant;
	}


	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}


	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
