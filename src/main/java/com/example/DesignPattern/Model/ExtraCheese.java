package com.example.DesignPattern.Model;

public class ExtraCheese extends PizzaDecorator{

	BasePizza basePizza;
	
	public ExtraCheese(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
	@Override
	public String pizzaSpecs() {
		return "Hi I add taste with extra cheese";
	}

	@Override
	public int cost() {
		return basePizza.cost() + 50;
	}

}
