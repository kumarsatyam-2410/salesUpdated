package com.omc.sales.dto;

import java.util.List;

public class NotificationResponseDTO extends AbstractResponseDTO{

	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "NotificationResponseDTO [id=" + id + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", status="
				+ status + ", getId()=" + getId() + ", getStatus()=" + getStatus() + ", getErrorCode()="
				+ getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
