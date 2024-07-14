package com.example.DesignPattern.Model;

public class FreshGarlic extends PizzaDecorator{

	BasePizza basePizza;
	
	public FreshGarlic(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public String pizzaSpecs() {
		return "Hey there, fresh garlic will add tangy taste to your pizza";
	}

	@Override
	public int cost() {
		return basePizza.cost() + 45;
	}

}
