package com.example.DesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.DesignPattern.DAO.CustomerDao;
import com.example.DesignPattern.JPA.CustomerRepository;

@SpringBootApplication
@ComponentScan("com.example.DesignPattern.*")
public class DesignPatternApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BeanUtility.customerDao = applicationContext.getBean(CustomerDao.class);
		BeanUtility.customerRepository = applicationContext.getBean(CustomerRepository.class);
	}
}
