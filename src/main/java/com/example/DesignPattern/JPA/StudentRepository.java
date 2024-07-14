package com.example.DesignPattern.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DesignPattern.Model.Student;

//spring will automatically create an object/bean for StudentRepository and provide it at runtime to be used
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
