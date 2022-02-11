package com.omc.sales.exception;


public class SSNSQLException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The error code. */
	private String errorMsg;

	/** The error code. */
	private ErrorCodes errorCode;

	/**
	 * Instantiates a new entity not found exception.
	 *
	 * @param errorMsg the error msg
	 * @param errorCode the error code
	 */
	public SSNSQLException(String errorMsg, ErrorCodes errorCode) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}


	/* (non-Javadoc)
	 * @see com.gemalto.tlm.exception.BaseException#getErrorMsg()
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/* (non-Javadoc)
	 * @see com.gemalto.tlm.exception.BaseException#setErrorMsg(java.lang.String)
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/* (non-Javadoc)
	 * @see com.gemalto.tlm.exception.BaseException#getErrorCode()
	 */
	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	/* (non-Javadoc)
	 * @see com.gemalto.tlm.exception.BaseException#setErrorCode(com.gemalto.tlm.exception.ErrorCodes)
	 */
	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

}
