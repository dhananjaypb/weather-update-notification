package org.weather.update.notification.exception;

/*
 * This is custom exception created for business exception
 * It accepts string message in constructor
 */
public class BusinessException extends Exception {

	public BusinessException(String str) {
		super(str);
	}

}
