package com.example.DesignPattern.Model;

public class Nexon extends Vehicle{
	public Nexon(String brand, int wheels) {
		super(brand, wheels);
	}
	@Override
	public String enginePower() {
		return "1000cc"; 
	}
	@Override
	public String specs() {
		return "Car brand = " + this.getBrand() + ", wheels = " + this.getWheels() + ", engine power = " + this.enginePower();
	}
}
