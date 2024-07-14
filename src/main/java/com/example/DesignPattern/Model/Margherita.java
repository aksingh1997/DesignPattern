package com.example.DesignPattern.Model;

public class Margherita implements BasePizza{

	@Override
	public String pizzaSpecs() {
		return "I am classic Margherita pizza";
	}

	@Override
	public int cost() {
		return 310;
	}

}
