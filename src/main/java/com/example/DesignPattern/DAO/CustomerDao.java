package com.example.DesignPattern.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.DesignPattern.BeanUtility;
import com.example.DesignPattern.DesignPatternApplication;
import com.example.DesignPattern.JPA.CustomerRepository;
import com.example.DesignPattern.Model.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public String saveCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		}
		catch(Exception ex) {
			System.out.println("Error while saving customer\n" + ex.getMessage());
		}
		return "Customer Saved!";
	}
	
	public String fetchCustomerName(int custId) {
		String name = "";
		try {
			name = BeanUtility.customerRepository.customerName(custId);
		}
		catch(Exception ex) {
			System.out.println("Error while fetching name\n"+  ex.getMessage());
		}
		return name;
	}
	
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = null;
		try {
			customerList = customerRepository.findAll();
		}catch(Exception ex) {
			System.out.println("Error while fetching name\n"+  ex.getMessage());
		}
		return customerList;
	}
}
