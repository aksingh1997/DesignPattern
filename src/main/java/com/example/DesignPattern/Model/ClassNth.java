package com.example.DesignPattern.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class ClassNth implements Cloneable {
	private int std;
	private String classTecher;
	private List<Student> studentList;
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		ClassNth obj = (ClassNth)super.clone(); //this is shallow copy, studentList has same reference to current object. we need to handle this
		obj.studentList = new ArrayList<>(); // resetting the List by deep copy
		for(Student student: studentList) {
			obj.studentList.add((Student)student.clone());
		}
		return obj;
	}
}
