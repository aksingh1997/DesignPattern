package com.example.DesignPattern.Model;


import com.example.DesignPattern.BeanUtility;
import com.example.DesignPattern.DesignPatternApplication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotifyMe implements Observer{

	private int custId;
	private String customerName = "";
	
	public NotifyMe(int custId) {
		this.custId = custId;
		customerName = BeanUtility.customerDao.fetchCustomerName(custId);
	}
	@Override
	public String eventTrigger(Observable observable) {
		return "Hey " + customerName + "! Your product " +  observable.getProductName() + " is availabe";
	}
	
}
