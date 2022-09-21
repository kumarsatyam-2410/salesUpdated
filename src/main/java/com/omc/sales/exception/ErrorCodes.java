package com.omc.sales.exception;

/**
 * The Enum ErrorCodes.
 */
public enum ErrorCodes {
	
	// =============== INPUT_VALIDATION error codes range =====================
	/** General Error occured. */
	GENERAL_ERROR(1013),
	
	NOT_UNIQUE_NOTIFICATION(1000),
	NOT_UNIQUE_CUSTOMER(2000),
	NOT_UNIQUE_PACKAGE(3000),
	NOT_UNIQUE_CONTENT(4000),
	CONTENT_NOT_EXIST(4001),
	SUBSCRIPTION_ALREADY_EXIST(5000),
	NO_USER_CONTENT_PROFILE_EXISTS(4002),
	NOT_UNIQUE_USER_CONTENT_PROFILE(4003),
	NOT_UNIQUE_Plan(4004),
	Sales_head_not_found(5000),
	Subscription_id_not_found(6000),
	USER_NOT_FOUND(1001);

	/** The error code. */
	private final int errorCode;

	/**
	 * Instantiates a new error status codes.
	 *
	 * @param errorCode the error code
	 * @param errorCode the error code
	 */
	private ErrorCodes(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return this.errorCode;
	}

}
