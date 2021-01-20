package com.capstone.webapplication.exception;

public class CustomerAlreadyExsistsException extends Exception {

	private static final long serialVersionUID = -6047577514587434069L;

	public CustomerAlreadyExsistsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerAlreadyExsistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerAlreadyExsistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerAlreadyExsistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerAlreadyExsistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
