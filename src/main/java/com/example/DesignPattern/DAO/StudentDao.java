package com.example.DesignPattern.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.DesignPattern.Exception.StudentEntryException;
import com.example.DesignPattern.JPA.StudentRepository;
import com.example.DesignPattern.Model.Student;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository studentRepo; // spring automatically created a bean at runtime and provides it here
	
	public String addStudent(Student student) {
		try {
			studentRepo.save(student);
		} catch(Exception ex) {
			throw new StudentEntryException(ex.getMessage());
		}
		return "StudentSaved!";
	}
	
	public List<Student> fetchAllStudents() {
		List<Student> studentList = null;
		try {
			studentList = studentRepo.findAll();
		}
		catch(Exception ex) {
			System.out.println("Exception occured while fetching data from database");
		}
		return studentList;
	}
	
	public Student fetchStudentById(int id) {
		Student student = null;
		try {
			student = studentRepo.findById(id).orElse(null);
		}
		catch(Exception ex) {
			System.out.println("Exception occured while fetching data from database");
		}
		return student;
	}
}