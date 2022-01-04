package com.omc.sales.dto;

import java.sql.Timestamp;

/**
 * The Class CustomerDTO.
 */
public class NotificationDTO {

	/**
	 * Instantiates a new user DTO.
	 */
	public NotificationDTO() {

	}

	private Long id;

	private String notificationType;

	private String notificationMode;

	private String message;

	private Timestamp addedOn;
	
	private Timestamp updatedOn;
	
	private boolean isActive;

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

	public Timestamp getAddedOn() {
		return addedOn;
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