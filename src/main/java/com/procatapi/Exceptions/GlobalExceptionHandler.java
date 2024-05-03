package com.procatapi.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // This help to response go to POSTMAN
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String HendleResourceNotFoundException(ResourceNotFoundException e) {

		return e.getMessage();
	}

}
