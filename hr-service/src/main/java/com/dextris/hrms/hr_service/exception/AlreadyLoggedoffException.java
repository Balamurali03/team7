package com.dextris.hrms.hr_service.exception;

public class AlreadyLoggedoffException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public  AlreadyLoggedoffException(String message) {
		super(message);
	}
}
