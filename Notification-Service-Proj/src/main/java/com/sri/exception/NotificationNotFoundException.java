package com.sri.exception;

public class NotificationNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotificationNotFoundException() {
		super();
	}
	public NotificationNotFoundException(String msg) {
		super(msg);
	}
	
}
