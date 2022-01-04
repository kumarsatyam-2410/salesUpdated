package com.omc.sales.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class notification
 */ 
@Entity
@Table(name = "sales_notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private Long id;

	@Column(name = "notification_type")
	private String notificationType;

	@Column(name = "notification_mode")
	private String notificationMode;

	@Column(name = "message")
	private String message;

	@Column(name = "added_on")
	private Timestamp addedOn;
	
	@Column(name = "updated_on")
	private Timestamp updatedOn;
	
	@Column(name = "is_active")
	private boolean isActive;

	public Notification()
	{

	}

	public Long getId() {
		return id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public String getNotificationMode() {
		return notificationMode;
	}

	public String getMessage() {
		return message;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public void setNotificationMode(String notificationMode) {
		this.notificationMode = notificationMode;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	


}
