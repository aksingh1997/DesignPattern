package com.example.DesignPattern.Model;

public class Pepperoni implements BasePizza{

	@Override
	public String pizzaSpecs() {
		return "I am classic Pepperoni pizza";
	}

	@Override
	public int cost() {
		return 350;
	}

}
