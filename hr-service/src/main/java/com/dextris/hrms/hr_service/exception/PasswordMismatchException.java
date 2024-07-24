package com.dextris.hrms.hr_service.exception;

public class PasswordMismatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public  PasswordMismatchException(String message) {
		super(message);
	}
}
