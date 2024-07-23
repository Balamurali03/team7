package com.dextris.hrms.employee.globalhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dextris.hrms.employee.exception.EmployeeCannotBeCreatedException;
import com.dextris.hrms.employee.exception.EmployeeNotFoundException;
import com.dextris.hrms.employee.exception.NoEmployeesAtATimeException;
import com.dextris.hrms.employee.reponse_details.ResponseDetails;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ResponseDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeCannotBeCreatedException.class)
	public ResponseEntity<ResponseDetails> handleEmployeeCannotBeCreatedException(EmployeeCannotBeCreatedException ex) {
		ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoEmployeesAtATimeException.class)
	public ResponseEntity<ResponseDetails> handleNoEmployeesAtATimeException(NoEmployeesAtATimeException ex) {
		ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.NO_CONTENT);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDetails> handleException(Exception ex) {
		ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
