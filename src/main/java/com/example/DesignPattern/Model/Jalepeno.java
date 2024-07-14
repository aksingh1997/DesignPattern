package com.example.DesignPattern.Model;

public class Jalepeno extends PizzaDecorator{

	BasePizza basePizza;
	
	public Jalepeno(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	
	@Override
	public String pizzaSpecs() {
		return "Hi I am Jalepeno, adding yumm to your pizza";
	}

	@Override
	public int cost() {
		return basePizza.cost() + 30;
	}

}
