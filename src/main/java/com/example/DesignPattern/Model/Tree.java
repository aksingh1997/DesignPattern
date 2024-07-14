package com.example.DesignPattern.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tree {
	TreeSpecs treeSpecs;
	double xCordinate;
	double yCordinate;
}
