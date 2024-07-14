package com.example.DesignPattern.Model;

import com.example.DesignPattern.Exception.PizzaNotFoundException;

public class PizzaFactory {
	public static BasePizza getPizza(String pizzaName) {
		if("Margherita".equalsIgnoreCase(pizzaName))
			return new Margherita();
		else if("Pepperoni".equalsIgnoreCase(pizzaName))
			return new Pepperoni();
		else 
			throw new PizzaNotFoundException("Pizza not available");
	}
	public static BasePizza getToppingPizza(BasePizza basePizza, String topping) {
		if("ExtraCheese".equalsIgnoreCase(topping))
			return new ExtraCheese(basePizza);
		else if("Jalepeno".equalsIgnoreCase(topping))
			return new Jalepeno(basePizza);
		else if("FreshGarlic".equalsIgnoreCase(topping))
			return new FreshGarlic(basePizza);
		else
			throw new PizzaNotFoundException("Pizza not available");
	}
}
