package com.omc.sales.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Users.
 */
@Entity
@Table(name = "rms_plant")
public class Plant  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_id")
	private Long plantId;

	@Column(name = "omc_id")
	private Integer omcId;
	@Column(name = "name")
	private String name;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn( name="country_id", nullable=false)
	private Country country;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn( name="state_id",nullable=false)
	private State state;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn( name="district_id",nullable=false)
	private District district;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "remark")
	private String remark;

	@Column(name = "added_on")
	private Timestamp addedOn;

	@Column(name = "updated_on")
	private Timestamp updatedOn;
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy = "plant_id") private PlantCapacity plantCapacity;
	 */
	
	public Plant(){
		
	}
	
	/**
	 * @return the plantId
	 */
	public Long getPlantId() {
		return plantId;
	}

	/**
	 * @param plantId the plantId to set
	 */
	public void setPlantId(long plantId) {
		this.plantId = plantId;
	}

	/**
	 * @return the omcId
	 */
	public Integer getOmcId() {
		return omcId;
	}

	/**
	 * @param omcId the omcId to set
	 */
	public void setOmcId(Integer omcId) {
		this.omcId = omcId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the addedOn
	 */
	public Timestamp getAddedOn() {
		return addedOn;
	}

	/**
	 * @param addedOn the addedOn to set
	 */
	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", omcId=" + omcId + ", name=" + name + ", country=" + country + ", state="
				+ state + ", district=" + district + ", type=" + type + ", remark=" + remark + ", addedOn=" + addedOn
				+ ", updatedOn=" + updatedOn + ", getPlantId()=" + getPlantId() + ", getOmcId()=" + getOmcId()
				+ ", getName()=" + getName() + ", getType()=" + getType() + ", getRemark()=" + getRemark()
				+ ", getAddedOn()=" + getAddedOn() + ", getUpdatedOn()=" + getUpdatedOn() + ", getCountry()="
				+ getCountry() + ", getState()=" + getState() + ", getDistrict()=" + getDistrict() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/*
	 * public PlantCapacity getPlantCapacity() { return plantCapacity; }
	 * 
	 * public void setPlantCapacity(PlantCapacity plantCapacity) {
	 * this.plantCapacity = plantCapacity; }
	 */

	





}
