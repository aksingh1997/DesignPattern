package com.example.DesignPattern.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DesignPattern.DAO.StudentDao;
import com.example.DesignPattern.Exception.CarNotFoundException;
import com.example.DesignPattern.Model.Brezza;
import com.example.DesignPattern.Model.ClassNth;
import com.example.DesignPattern.Model.Nexon;
import com.example.DesignPattern.Model.SingletonImpl;
import com.example.DesignPattern.Model.Student;
import com.example.DesignPattern.Model.StudentBuilder;
import com.example.DesignPattern.Model.Vehicle;

@Service
public class CreationalService {
	
	@Autowired
	StudentDao studentDao;

	public void demoSingleton() {
		// SingletonImpl obj1 = new SingletonImpl(); --> throws error = The constructor SingletonImpl() is not visible, constructor is private
		SingletonImpl obj1 = SingletonImpl.getObject(); // get the object
		obj1.addBook("physics", "HC Verma");
		obj1.addBook("Chemistry", "S Chand");
		System.out.println(obj1.getBooks());
		
		SingletonImpl obj2 = SingletonImpl.getObject(); // trying to create another object
		System.out.println(obj2.getBooks());
		
		// we can see obj1 is same as obj2 as each time getObject returns same object
	}

	public void demoBuilder() {
		// get Student object via builder method
		Student student = new StudentBuilder(1, "Abhi").age(16).std(10).marks(40).section("A").house("blue").build();
		System.out.println(student.toString());
	}

	public Vehicle demoFactory(String carName) {
		Vehicle vehicle = null;
		switch(carName) {
		case "Brezza" :
			vehicle = new Brezza("brezza", 4);
			break;
		case "Nexon" : 
			vehicle = new Nexon("Nexon", 4);
			break;
		default:
			throw new CarNotFoundException("car not found");
		}
		return vehicle;
		
	}

	public void demoPrototype() {
		//here object creation is heavy task as it requires fetching student from database
		long daoObjStart = System.currentTimeMillis();
		ClassNth class10th = ClassNth.builder().std(10).classTecher("Ashok tiwari").studentList(studentDao.fetchAllStudents()).build();
		long daoObjEnd = System.currentTimeMillis();
		System.out.println("class10th printing............\n" + class10th.toString() + "\ntime taken = " + (daoObjEnd - daoObjStart) + "ms");
		//Now if we need another object of class10th, we can simply clone the object from the first class10th object,  and then make changes if required
		//By this we are bypassing the costly DB call
		try {
			long cloneObjStart = System.currentTimeMillis();
			ClassNth class10thCopy = (ClassNth)class10th.clone();
			long cloneObjEnd = System.currentTimeMillis();
			System.out.println("class10th copy printing............\n" +class10thCopy.toString() + "\ntime taken = " + (cloneObjEnd - cloneObjStart) + "ms");
			
			//making change in cloned object just to see if deep copy is correctly implemented
			class10thCopy.setClassTecher("Anil Nath Tiwari");
			System.out.println("actual classTeacher = " + class10th.getClassTecher() + "\nnew classTeacher = " + class10thCopy.getClassTecher());
		} catch(CloneNotSupportedException ex) {
			System.out.println("Clone not supported");
		}
	}

}
