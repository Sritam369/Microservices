package com.sri.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotificationNotFoundException.class)
	public ResponseEntity<ExceptionDetails> showMsg(NotificationNotFoundException e){
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setTimestamp(LocalDateTime.now());
		ex.setErrorMsg(e.getMessage());
		
		return new ResponseEntity<ExceptionDetails>(ex,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> showMsg(Exception e){
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setTimestamp(LocalDateTime.now());
		ex.setErrorMsg(e.getMessage());
		
		return new ResponseEntity<ExceptionDetails>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
