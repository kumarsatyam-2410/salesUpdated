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
@Table(name = "plant_users")
public class PlantUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_user_id")
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn( name="user_id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn( name="plant_id",nullable=false)
	private Plant plant;
	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "added_by")
	private String addedby;

	@Column(name = "added_on")
	private Timestamp addedOn;

	
	public PlantUsers(){
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Plant getPlant() {
		return plant;
	}


	public void setPlant(Plant plant) {
		this.plant = plant;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAddedby() {
		return addedby;
	}


	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}


	public Timestamp getAddedOn() {
		return addedOn;
	}


	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}
}
