package com.vsm.userservice.exceptions;



import java.time.LocalDate;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private LocalDate timeStamp;
	private String message;
	private HttpStatus status;
	
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate localDate) {
		this.timeStamp = localDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ErrorResponse(LocalDate timeStamp, String message, HttpStatus status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;
	}
	public ErrorResponse() {
		super();
		
	}
	
	
}
