package com.example.DesignPattern.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}
	
	@ExceptionHandler(StudentEntryException.class)
	public ResponseEntity<String> handleStudentEntryException(StudentEntryException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}
	
	@ExceptionHandler(PizzaNotFoundException.class)
	public ResponseEntity<String> handlePizzaNotFoundException(PizzaNotFoundException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}
}
