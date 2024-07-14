package com.example.DesignPattern.Model;

import lombok.Getter;

@Getter
public abstract class Vehicle {
	private String brand;
	private int wheels;
	
	public Vehicle(String brand, int wheels) {
		this.brand = brand;
		this.wheels = wheels;
	}
	
	public abstract String enginePower();
	public abstract String specs();
}
