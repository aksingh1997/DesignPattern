package com.example.DesignPattern.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.DesignPattern.Exception.PizzaNotFoundException;
import com.example.DesignPattern.Model.BasePizza;
import com.example.DesignPattern.Model.Mp3Player;
import com.example.DesignPattern.Model.MusicPlayer;
import com.example.DesignPattern.Model.PizzaFactory;
import com.example.DesignPattern.Model.Tree;
import com.example.DesignPattern.Model.TreeSpecs;

@Service
public class StructuralService {

	HashMap<String, Object> treeSpecsMap = new HashMap<>();
	double xCordinate;
	double yCordinate;
	
	public String demoAdapter(String fileFormat) {
		MusicPlayer musicPlayer = new Mp3Player();
		return musicPlayer.play(fileFormat); // here in legacy music player supporting only .mp3 files, we will also be able to playing .mp4 and .flac formats
	}

	public int findPizzaPrice(String basePizza, String topping1, String topping2) {
		//get cost of basePizza + toppings
		BasePizza pizza;
		if(basePizza == null)
			throw new PizzaNotFoundException("Pizza not found");
		if(topping2 == null || topping2 == "") // if only one topping provided
			pizza = PizzaFactory.getToppingPizza(PizzaFactory.getPizza(basePizza), topping1);
		else 
			pizza = PizzaFactory.getToppingPizza(PizzaFactory.getToppingPizza(PizzaFactory.getPizza(basePizza), topping2) ,topping1);
		
		return pizza.cost();
	}

	public String getTreeSpecs(String treeName) {
		TreeSpecs treeSpecs = null;
		if(treeSpecsMap.containsKey(treeName))
			treeSpecs = (TreeSpecs)treeSpecsMap.get(treeName);
		else {
			if(treeName.equalsIgnoreCase("apple"))
				treeSpecs = new TreeSpecs("apple", "red", "Brown");
			else if(treeName.equalsIgnoreCase("banyan"))
				treeSpecs = new TreeSpecs("banyan", "white", "white");
			else if(treeName.equalsIgnoreCase("banana"))
				treeSpecs = new TreeSpecs("banana", "yellow", "green");
			else 
				return "make selection out of 1.apple 2.banyan 3. banana";
			treeSpecsMap.put(treeName, treeSpecs);
		}
		Tree tree = new Tree(treeSpecs, xCordinate, yCordinate);
		// if tree specs were not seperated from tree, then in every object we have to assign memory to these three extra variables, but now they are in 
		// separate object and initialized just once.
		return tree.toString();
	}

}
