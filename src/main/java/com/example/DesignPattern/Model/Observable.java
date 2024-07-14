package com.example.DesignPattern.Model;

public interface Observable {
	public String getProductName();
	public String specs();
	public void addObserver(Observer observer);
	public void notifyObserver();
	public String addStock();
	public String removeStock();
}
