package com.javatrial.serialization;

import java.io.Serializable;

public class Student implements Serializable{
	

	
	
	/**
	 * 
	 */
	//used to check the compatibility of the class by checking the versionid.....if the version id during the serialization is same as version id during de-serialization.
	//private static final long serialVersionUID = 8284370883319789535L;
	
	private int id;
	private String name;
	private int salary;
	//private String hobby;
	
	public Student(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
	

}
