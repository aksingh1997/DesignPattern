package com.example.DesignPattern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignPattern.Model.Vehicle;
import com.example.DesignPattern.Service.CreationalService;

@RestController
public class CreationalDesignPatternController {
	
	@Autowired
	CreationalService creationalService;

	//Singleton Design Pattern
	/*A design pattern in which a class can have only one object.
	 * Make the class constructor private -> means cannot create object by using new keyword
	 * provide single object by using static method whenever called 
	 */
	
	@GetMapping("/singleton")
	public void singleton() {
		creationalService.demoSingleton();
	}
	
	//builder design pattern
	/*
	 * A design pattern in which we have separate builder class to which builds object for us
	 * If we have a large no of fields in our class then inorder to set their value via constructor, client needs to know the order in which 
	 * params should be send to its constructor for object creation. To avoid this we can send few required params via constructor and set other 
	 * params using param's name. 
	 */
	@GetMapping("builder")
	public void builder() {
		creationalService.demoBuilder();
	}
	
	//factory design pattern
	/*
	 * A design pattern in which manufactures the object for client based on some condition and also provides an abstraction layer between client and
	 * actual class
	 */
	@GetMapping("factory/{carName}")
	public ResponseEntity<?> factory(@PathVariable("carName")String carName) {
		Vehicle vehicle = creationalService.demoFactory(carName);
		return ResponseEntity.ok(vehicle.specs()); //handle exception here , global exception handle if car name is not present
	}
	
	//abstract factory design pattern
	/*
	 *  A design pattern which provides another layer of abstraction over factory classes. Factory of factories.
	 */
	
	
	//prototype design pattern
	/*
	 * prototype design pattern is required when object creation is costly, for example object creation takes database intervention.
	 * To avoid this, first time we can create object via database layer, next time we can simply clone the first object (deep copy) to avoid database call
	 */
	@GetMapping("prototype")
	public void prototype() {
		creationalService.demoPrototype();
	}
}
