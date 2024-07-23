package com.dextris.hrms.hr_service.exception;

public class NoDataPresentException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public  NoDataPresentException(String message) {
		super(message);
	}
}
