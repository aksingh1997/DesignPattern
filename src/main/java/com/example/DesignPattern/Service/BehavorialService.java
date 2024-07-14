package com.example.DesignPattern.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DesignPattern.DAO.CustomerDao;
import com.example.DesignPattern.Model.Customer;
import com.example.DesignPattern.Model.Iphone;
import com.example.DesignPattern.Model.Jordan;
import com.example.DesignPattern.Model.NotifyMe;
import com.example.DesignPattern.Model.Observable;

@Service
public class BehavorialService {

	@Autowired
	CustomerDao customerDao;
	

	public String addCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	
	public String createObject() {
		Iphone iphone = Iphone.getObject();
		Jordan jordan = Jordan.getObject();
		iphone.setPrice(100000);
		jordan.setPrice(20000);
		iphone.setStock(1);
		jordan.setStock(1);
		return "Product listed = Iphone and Jordan";
	}
	
	public String addIphone() {
		 return Iphone.getObject().addStock();
	}

	public String removeIphone() {
		return Iphone.getObject().removeStock();
	}
	
	public String addJordan() {
		return Jordan.getObject().addStock();
	}

	public String removeJordan() {
		return Jordan.getObject().removeStock();
	}

	public String notifyMe(int subscriberId, String subscribedProduct) {
		NotifyMe notifyMe = null;
		try {
			notifyMe = new NotifyMe(subscriberId);
		} catch(Exception ex) {
			System.out.println("Cannot instatiate NotifyMe\n" + ex.getMessage());
		}
		
		Observable observable;
		if(subscribedProduct.equalsIgnoreCase("Iphone"))
			observable = Iphone.getObject();
		else if(subscribedProduct.equalsIgnoreCase("Jordan"))
			observable = Jordan.getObject();
		else
			return "Wrong subscribed Product";
		
		observable.addObserver(notifyMe);
		return subscribedProduct + " Subsribed!";
	}

	
}
