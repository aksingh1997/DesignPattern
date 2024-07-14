package com.example.DesignPattern.Model;

//Decorator class has IS-A relation with base class
//Now any class that extends PizzaDecorator will also be BasePizza
//Any class that extends PizzaDecorator class will be having HAS-A relationship with base-pizza
public abstract class PizzaDecorator implements BasePizza {
	public abstract String pizzaSpecs();
	public abstract int cost();
}
