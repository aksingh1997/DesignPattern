package com.example.DesignPattern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesignPattern.DAO.StudentDao;
import com.example.DesignPattern.Model.Student;

@RestController
public class GeneralController {
	
	@Autowired
	StudentDao studentDao;
	
	@PostMapping("saveStudent")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentDao.addStudent(student));
	}
}
