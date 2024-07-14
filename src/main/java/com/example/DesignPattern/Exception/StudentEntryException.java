package com.example.DesignPattern.Exception;

public class StudentEntryException extends RuntimeException{
	private static final long serialVersionUID = 5261994789970975494L;
	public StudentEntryException(String msg) {
		super(msg);
	}
	public StudentEntryException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
