package com.javatechnology.exception;

public class LoginNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private long id;
	private static final long serialVersionUID = 1L;
	
	public LoginNotFoundException() {
		
	}
	public LoginNotFoundException(String message) {
		super(message);
	}

}
