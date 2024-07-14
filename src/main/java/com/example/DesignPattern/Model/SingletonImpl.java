package com.example.DesignPattern.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/* a singleton class which provides list of books in library
 * we are restricting it to have only one object
 */
public class SingletonImpl {
	
	@AllArgsConstructor
	@Getter
	@ToString
	class Book {
		private String name;
		private String author;
	}
	
	private List<Book> bookList = new ArrayList<>();
	private static SingletonImpl singletonImplObject = new SingletonImpl(); //create object here and access it in static method
	private SingletonImpl() {};
	
	public static SingletonImpl getObject() { // call this static method to get object
		return singletonImplObject;
	}
	
	public void addBook(String name, String author) {
		bookList.add(new Book(name, author));
	}
	public String getBooks() {
		String books = "";
		for(Book book: bookList) {
			books += book.toString() + " ";
		}
		return books;
	}
	
}
