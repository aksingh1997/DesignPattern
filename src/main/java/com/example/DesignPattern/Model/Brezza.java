package com.example.DesignPattern.Model;

public class Brezza extends Vehicle {
	public Brezza(String brand, int wheels) {
		super(brand, wheels);
	}
	@Override
	public String enginePower() {
		return "1125cc"; 
	}
	@Override
	public String specs() {
		return "Car brand = " + this.getBrand() + ", wheels = " + this.getWheels() + ", engine power = " + this.enginePower();
	}
}
