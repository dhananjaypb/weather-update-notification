package org.weather.update.notification.exception;

/*
 * This is custom exception created for Invalid Body exception
 * It accepts string message in constructor
 */
public class InvalidBodyException extends Exception {

	public InvalidBodyException(String str) {
		super(str);
	}

}
