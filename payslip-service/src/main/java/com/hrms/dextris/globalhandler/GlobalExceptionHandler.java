package com.hrms.dextris.globalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hrms.dextris.exception.PaySlipNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(PaySlipNotFoundException.class)
	    public ResponseEntity<String> handlePayslipNotFoundException(PaySlipNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
