package com.omc.sales.dto;

import java.util.List;

public class CustomerResponseDTO extends AbstractResponseDTO{

	private Long id;


	private Long ppId;


	public Long getPpId() {
		return ppId;
	}

	public void setPpId(Long ppId) {
		this.ppId = ppId;
	}


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CustomerResponseDTO [id=" + id + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", status="
				+ status + ", getId()=" + getId() + ", getStatus()=" + getStatus() + ", getErrorCode()="
				+ getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
