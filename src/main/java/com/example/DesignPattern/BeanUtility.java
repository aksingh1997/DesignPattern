package com.example.DesignPattern;

import com.example.DesignPattern.DAO.CustomerDao;
import com.example.DesignPattern.JPA.CustomerRepository;

import lombok.Getter;

@Getter
public class BeanUtility {
	
	public static CustomerDao customerDao;
	public static CustomerRepository customerRepository;
}
