package com.dextris.hrms.hr_service.response_details;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record ErrorResponse(String message, LocalDateTime time,HttpStatus status) {

}
