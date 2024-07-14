package com.example.DesignPattern.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Cloneable{
	@Id
	private int id; // this will be primary key
	private String name;
	private int age;
	private int std;
	private String section;
	private String house;
	private int marks;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student obj = (Student)super.clone();
		return obj;
	}
}