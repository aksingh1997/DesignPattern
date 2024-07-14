package com.example.DesignPattern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignPattern.Service.StructuralService;

@RestController
public class StructuralDesignPatternController {
	
	@Autowired
	StructuralService structuralService;

	//Adapter design pattern
	/*
	 * this design pattern solves compatibility issues. Lets suppose there is some legacy code functionality which is getting consumed by some third party
	 * via an interface. Now new enhancements came in. In order to integrate those enhancements without changing the legacy interface and via the old legacy
	 * methods is done by adapter design pattern. For example, we have an Music Player interface with play(Filetype x) function. This is implemented by
	 * MP3 player class and it only supports .mp3 files. Now with new enhancements, .mp4 and .flac came. These new music format is handled by ModernPlayer
	 * interface. By adapter pattern we will integrate ModernPlayer functionality in our existing mp3 player.
	 */
	@GetMapping("/adapter/{fileFormat}")
	public String adapter(@PathVariable("fileFormat") String fileFormat) {
		return structuralService.demoAdapter(fileFormat);
	}
	
	//decorator design pattern
	/*
	 * this design pattern is useful when we have a base class and many features that can be added to this base class to make it a specific version
	 * Every feature or combination of feature will require a new class inherited from base class. To avoid this we use decorator pattern.
	 * Here we will have some base pizzas - (Margherita, Pepperoni) and different flavours that can be added are - ExtraCheese, Jalepeno, FreshGarlic
	 * Lets see how we efficiently calculate price of pizza with these toppings
	 */
	@GetMapping("/decorator")
	public int decorator(@RequestParam("basePizza")String basePizza, @RequestParam("topping1") String topping1, @RequestParam("topping2") String topping2) {
		return structuralService.findPizzaPrice(basePizza, topping1, topping2); 	
	}
	
	
	//Fly-weight design pattern
	/*
	 * In flyweight design pattern, we try to reutilize the already created object and thus reutilize memory.
	 * In-order to reduce the size, we use intrinsic and extrinsic formula. Intrinsic data means the one that always remains same. We can create a hashMap
	 * and store our Intrinsic objects there. Next time if we need it, we can simply take it from HashMap.
	 * Lets take an example of Tree Object - {name, colour, texture, x-cordinate, y-cordinate}. At a closer look we can see, for any similar tree say - apple tree
	 * has same name, colour and texture. Only x-cordinate and y-cordinates are different for each tree. So we can make a separate object TreeSpecs(name, colour, 
	 * texture) and refer this in our Tree object. Store TreeSpecs in HashMap, so there will be only one instance for all apple tree, this will reduce overall
	 * object size
	 * 
	 */
	@GetMapping("/flyweight/{treeName}")
	public String flyweight(@PathVariable("treeName")String treeName) {
		return structuralService.getTreeSpecs(treeName);
	}
}
