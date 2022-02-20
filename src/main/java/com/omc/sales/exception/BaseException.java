package com.omc.sales.exception;

/**
 * The Class BaseException.
 */
public class BaseException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2203393553562842980L;

	/** The error code. */
	private String errorMsg;

	/** The error code. */
	private ErrorCodes errorCode;
	
	/** The Error value	 */
	private String ErrorValue;

	/**
	 * Instantiates a new base exception.
	 *
	 * @param errorMsg the error msg
	 * @param errorCode the error code
	 */
	public BaseException(String errorMsg, ErrorCodes errorCode) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
	
	/**
	 * 
	 * @param errorMsg
	 * @param errorCode
	 * @param errorValue
	 */
	public BaseException(String errorMsg, ErrorCodes errorCode, String errorValue) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.ErrorValue = errorValue;
	}

	/**
	 * Instantiates a new base exception.
	 *
	 * @param message the message
	 */
	public BaseException(String message) {
		super(message);
		this.errorMsg = message;
	}

	/**
	 * Instantiates a new base exception.
	 *
	 * @param errorMsg the error msg
	 * @param errorCode the error code
	 * @param cause the cause
	 */
	public BaseException(String errorMsg, ErrorCodes errorCode, Throwable cause) {
		super(errorMsg, cause);
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	
	public BaseException(String errorMsg,Throwable cause) {
		super(errorMsg, cause);
		this.errorMsg = errorMsg;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Sets the error msg.
	 *
	 * @param errorMsg the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorValue() {
		return ErrorValue;
	}

	public void setErrorValue(String errorValue) {
		ErrorValue = errorValue;
	}

}
