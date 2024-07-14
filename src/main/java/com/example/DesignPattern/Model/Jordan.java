package com.example.DesignPattern.Model;

import java.util.ArrayList;
import java.util.List;

public class Jordan implements Observable{
	
	private static Jordan object = new Jordan();
	private final String productName = "Jordan";
	private int price;
	private int stock;
	private List<Observer> observerList = new ArrayList<>();

	private Jordan() { //private Constructor
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public static Jordan getObject() {
		return object;
	}
	
	
	@Override
	public String getProductName() {
		return productName;
	}
	
	@Override
	public String specs() {
		return "Hi there I am " + productName + " and MyPrice = " + price;
	}
	
	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observerList) {
			System.out.println(observer.eventTrigger(this));
		}
	}
	
	@Override
	public String addStock() {
		this.stock++;
		if(stock == 3) {
			notifyObserver();
		}
		return productName + " count = " + stock;
	}

	@Override
	public String removeStock() {
		this.stock--;
		return productName + " count = " + stock;
	}
}
