package com.bleizing.exception;

/**
 * 
 * @author Nuriman
 *
 */
public class ProcessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6227334118301114998L;

	private ErrorType errorType;
	private String errorCode;

	public ProcessException(){}
	
	public ProcessException(final String errorCode,final ErrorType errorType) {
		this(errorCode,errorType, null);
	}
	
	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public ProcessException(final String errorCode,final ErrorType errorType, final Throwable cause) {
		super(errorType.description, cause);
		this.errorType = errorType;
	}

	
	public boolean isTimeout() {
		return ErrorType.CONNECTION_READ_TIMEOUT.equals(errorType);
	}

}
