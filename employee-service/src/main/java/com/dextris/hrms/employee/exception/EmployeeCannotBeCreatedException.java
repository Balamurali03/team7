package com.dextris.hrms.employee.exception;

public class EmployeeCannotBeCreatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeCannotBeCreatedException(String message) {
		super(message);
	}
}
