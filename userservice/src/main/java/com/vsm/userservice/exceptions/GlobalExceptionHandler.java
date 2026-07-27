package com.vsm.userservice.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorResponse errorresponse = new ErrorResponse();
		errorresponse.setMessage(ex.getMessage());
		errorresponse.setStatus(HttpStatus.NOT_FOUND);
		errorresponse.setTimeStamp(LocalDate.now());
		return errorresponse;
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse handleNosuchElementException(NoSuchElementException exe) {
		ErrorResponse errorresponse = new ErrorResponse();
		errorresponse.setMessage(exe.getMessage());
		errorresponse.setStatus(HttpStatus.NOT_FOUND);
		errorresponse.setTimeStamp(LocalDate.now());
		return errorresponse;
	}
}
