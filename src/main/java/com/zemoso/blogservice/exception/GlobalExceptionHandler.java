package com.zemoso.blogservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException rnfEx,WebRequest wr){
		ErrorDetails eD = new ErrorDetails(new Date(), rnfEx.getMessage() , wr.getDescription(false));
		return new ResponseEntity<>(eD,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(ResourceNotFoundException rnfEx,WebRequest wr){
		ErrorDetails eD = new ErrorDetails(new Date(), rnfEx.getMessage() , wr.getDescription(false));
		return new ResponseEntity<>(eD,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
