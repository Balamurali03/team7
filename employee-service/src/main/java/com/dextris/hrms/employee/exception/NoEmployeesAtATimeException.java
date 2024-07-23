package com.dextris.hrms.employee.exception;

public class NoEmployeesAtATimeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoEmployeesAtATimeException(String message) {
		super(message);
	}
}
