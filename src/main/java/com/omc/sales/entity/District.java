package com.omc.sales.entity;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Users.
 */
@Entity
@Table(name = "rms_district")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRICT_ID")
	private Integer id;

	@Column(name = "NAME")
	private String districtName;
	
	@JsonBackReference
	@OneToMany(mappedBy="district")
	private Set<Plant> plants;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="STATE_ID", nullable=false)
	private State state;

	@JsonIgnore
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@JsonIgnore
	@Column(name = "ADDED_ON")
	private Timestamp addedOn;

	@JsonIgnore
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;

	public District() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	 * @return the plants
	 */
	public Set<Plant> getPlants() {
		return plants;
	}

	/**
	 * @param plants the plants to set
	 */
	public void setPlants(Set<Plant> plants) {
		this.plants = plants;
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

	

}
