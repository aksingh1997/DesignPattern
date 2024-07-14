package com.example.DesignPattern.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DesignPattern.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select name from Customer where custId = ?1") // Always use ClassName and fieldName in this query instead of tableName and columnName of DB table
	String customerName(int custId);
}
