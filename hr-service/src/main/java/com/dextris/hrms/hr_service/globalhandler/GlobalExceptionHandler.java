package com.dextris.hrms.hr_service.globalhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dextris.hrms.hr_service.exception.AlreadyLoggedoffException;
import com.dextris.hrms.hr_service.exception.NoDataPresentException;
import com.dextris.hrms.hr_service.exception.PasswordMismatchException;
import com.dextris.hrms.hr_service.exception.UserAlreadyExistException;
import com.dextris.hrms.hr_service.exception.UserAlreadyLoggedInException;
import com.dextris.hrms.hr_service.exception.UserNotExistException;
import com.dextris.hrms.hr_service.response_details.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserAlreadyLoggedInException.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyLoggedInException(UserAlreadyLoggedInException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.ALREADY_REPORTED);
		return new ResponseEntity<>(errorResponse,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value = PasswordMismatchException.class)
	public ResponseEntity<ErrorResponse> handlePasswordMismatchException(PasswordMismatchException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NoDataPresentException.class)
	public ResponseEntity<ErrorResponse> handleNoDataPresentException(NoDataPresentException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(errorResponse,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserAlreadyExistException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.ALREADY_REPORTED);
		return new ResponseEntity<>(errorResponse,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value = UserNotExistException.class)
	public ResponseEntity<ErrorResponse> handleUserNotExistException(UserNotExistException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AlreadyLoggedoffException.class)
	public ResponseEntity<ErrorResponse> handleAlreadyLoggedoffException(AlreadyLoggedoffException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
