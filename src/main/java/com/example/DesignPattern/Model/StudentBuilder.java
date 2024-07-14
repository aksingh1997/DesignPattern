package com.example.DesignPattern.Model;


public class StudentBuilder {
	private int id;
	private String name;
	private int age;
	private int std;
	private String section;
	private String house;
	private int marks;
	
	public StudentBuilder(int id, String name) { // only two required params passed in constructor
		this.id = id;
		this.name = name;
	}
	
	public StudentBuilder age(int age) {
		this.age = age;
		return this;
	}
	
	public StudentBuilder std(int std) {
		this.std = std;
		return this;
	}
	
	public StudentBuilder section(String section) {
		this.section = section;
		return this;
	}
	
	public StudentBuilder house(String house) {
		this.house = house;
		return this;
	}
	
	public StudentBuilder marks(int marks) {
		this.marks = marks;
		return this;
	}
	
	public Student build() {
		return new Student(id, name, age, std, section, house, marks);
	}
}
