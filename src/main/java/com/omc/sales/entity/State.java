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
@Table(name = "rms_state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID")
	private Integer id;

	@Column(name = "STATE_NAME")
	private String stateName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="COUNTRY_ID", nullable=false)
	private Country country;
	
	@JsonBackReference
	@OneToMany(mappedBy="state")
	private Set<Plant> plants;

	@JsonIgnore
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@JsonIgnore
	@Column(name = "ADDED_ON")
	private Timestamp addedOn;

	@JsonIgnore
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;

	public State() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	

}
