package com.dsandalgo.ibmprep;

import java.time.LocalDate;

public class Employee {
	
	private String name;
	private int age;
	private int salary;
	private LocalDate doj;
	private boolean isActive;
	private int pinCode;
	
	public Employee(String name, int age, int salary, LocalDate doj, boolean isActive, int pinCode) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.doj = doj;
		this.isActive = isActive;
		this.pinCode = pinCode;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	

}
