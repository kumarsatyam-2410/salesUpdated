package com.omc.sales.dto;

import java.io.Serializable;

public abstract class AbstractResponseDTO implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -858797977997981460L;
	
	protected Integer errorCode;
	
	protected String errorMessage;

	/** The status. */
	protected Integer status;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
