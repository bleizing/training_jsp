package com.bleizing.exception;

/**
 * @author austraramadhan
 */
public class ProcessExceptionDesc extends ProcessException {


	private static final long serialVersionUID = 6227334118301114998L;

	public final String customMessage;

	public final ErrorType errorType;

	/**
	 *
	 * @param errorType
	 * @param customMessage
	 */
	public ProcessExceptionDesc(final String errorCode,final ErrorType errorType, final String customMessage) {
		this.errorType = errorType;
		this.customMessage = customMessage;
		setErrorCode(errorCode);
	}
}
