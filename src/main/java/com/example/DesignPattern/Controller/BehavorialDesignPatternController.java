package com.example.DesignPattern.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignPattern.Model.Customer;
import com.example.DesignPattern.Model.NotifyMe;
import com.example.DesignPattern.Service.BehavorialService;

@RestController
public class BehavorialDesignPatternController {
	
	@Autowired
	BehavorialService behavorialService;
	
	//Observer Design pattern
	/*
	 * This is used in cases when there is some event to be observed and once that event occurs it will notify all the observers about that event.
	 * It has one Observable interface which is implemented by events that are to be observed. It has one Observer interface which will be implemented by
	 * classes that will observe events. Each observable class will have a list of observers, which are interested in this event and will get notified.
	 * Thus Observable HAS-A Observer.
	 * Lets create a notification system for Iphone and Jordan stock, once they are available, notify the users who have clicked Notify Me!
	 */
	@PostMapping("add-customer")
	public String addCustomer(@RequestBody Customer customer) {
		return behavorialService.addCustomer(customer);
	}
	
	@GetMapping("get-all-customer")
	public List<Customer> getAllCustomer() {
		return behavorialService.getAllCustomer();
	}
	
	@GetMapping("initialize-products")
	public String initializeProducts() {
		return behavorialService.createObject();
	}
	
	@PostMapping("notify-me")
	public String notifyMe(@RequestParam("subscriberId") int subscriberId, @RequestParam("subscribedProduct") String subscribedProduct) {
		return behavorialService.notifyMe(subscriberId, subscribedProduct);
	}
	
	@GetMapping("/observer/add-iphone") 
	public String addIphone(){
		return behavorialService.addIphone();
	}
	
	@GetMapping("/observer/remove-iphone") 
	public void removeIphone(){
		behavorialService.removeIphone();
	}
	
	@GetMapping("/observer/add-jordan") 
	public String addJordan(){
		return behavorialService.addJordan();
	}
	
	@GetMapping("/observer/remove-jordan") 
	public void removeJordan(){
		behavorialService.removeJordan();
	}
}
