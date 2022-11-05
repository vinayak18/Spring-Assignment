package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {CustomerNotFoundException.class})
	public ResponseEntity<Object> exception(CustomerNotFoundException exception){
		return new ResponseEntity<Object>("Customer not found!",HttpStatus.NOT_FOUND);
	}

}
