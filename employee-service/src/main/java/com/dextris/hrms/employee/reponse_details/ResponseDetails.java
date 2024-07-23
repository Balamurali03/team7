package com.dextris.hrms.employee.reponse_details;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDetails {
	private LocalDateTime time;
	private String message;
	private HttpStatus status;
}
