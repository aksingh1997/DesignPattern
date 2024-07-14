package com.example.DesignPattern.Exception;

public class PizzaNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 3758718655274600520L;

	public PizzaNotFoundException(String msg) {
		super(msg);
	}
	
}
