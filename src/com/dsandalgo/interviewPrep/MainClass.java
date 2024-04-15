package com.dsandalgo.interviewPrep;

import java.util.HashMap;
import java.util.Map;

class Animal {}

class Dog extends Animal {}

class Labrador extends Dog {}

class Color {
	private String name;

	public Color(String name) {
		super();
		this.name = name;
	}
	
}

class Java2 {
	public void divide(int a, int b) {
		try {
			int c = a/b;
		} finally {
			System.out.println("finally");
		}
	}
}

class Test<T> {
	T value;

	public Test(T value) {
		super();
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
}
public class MainClass {

	static void printValue(Animal a) {System.out.println("One");}
	
	static void printValue(Dog d) {System.out.println("Two");}
	
	static void printValue(Object o) {System.out.println("Three");}
	
	public static void main(String[] args) {

		System.out.println("------------------");
		//-----------------------------
		
		Test<String> first = new Test<>("a string");
		Test<Integer> two = new Test<>(123);
		System.out.print(first.getValue());
		System.out.print(two.getValue());
		
		System.out.println("------------------");
		//-----------------------------
		
		System.out.println(method());
		System.out.println("------------------");
		//-----------------------------
		
		Java2 obj = new Java2();
		try {
			obj.divide(3, 0);
		} catch (RuntimeException e) {
			System.out.println("Runtime");
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("finally end");
		}
		
		//----------------------------
		Labrador c = new Labrador();
		printValue(c);
		//--------------------------
		String s1 = "Hello";
		s1 += "World";
		String s2 = "Hello";
		s2 += "";
		s2 += "World";
		String s3 = s1.intern();
		String s4 = s2.intern();
		boolean b1 = s3 == s4;
		boolean b2 = s3.equals(s4);
		
		System.out.println(b1 + " " + b2);
		// --------------------------
		Integer number = 10;
		number++;
		assert number==null && number>=0;
		System.out.println(number);
		//----------------------------
		Map<Color, String> map = new HashMap<>();
		map.put(new Color("Red"), "Red");
		map.put(new Color("Blue"), "Blue");
		map.put(new Color("Green"), "Green");
		System.out.println(map.get(new Color("Blue")));
	}

	private static Object method() {
		try {
			int i=10/0;
			return i;
		} catch (ArithmeticException e) {
			return "catch";
		} finally {
			return "finally";
		}
	}

}
