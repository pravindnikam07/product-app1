package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobaleException {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorMessage> productExceptionHandler(ProductException pe, WebRequest req) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(LocalDateTime.now(), pe.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e, WebRequest req) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(LocalDateTime.now(), e.getMessage(), req.getDescription(false)),HttpStatus.BAD_REQUEST);
	}
}
