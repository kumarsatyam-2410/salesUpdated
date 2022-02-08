package com.omc.sales.dto;



public class UserResponseDTO extends AbstractResponseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserResponseDTO [id=" + id + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", status="
				+ status + ", getId()=" + getId() + ", getStatus()=" + getStatus() + ", getErrorCode()="
				+ getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
