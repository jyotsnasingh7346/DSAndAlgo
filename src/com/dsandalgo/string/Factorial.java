package com.dsandalgo.string;

public class Factorial {

	public int getFactorial(int n) {
		if (n == 1) return 1;
		else 
			return (n* getFactorial(n-1));
	}
	
	public static void main(String[] args) {

		Factorial fact = new Factorial();
		int n = 5;
		System.out.println("Factorial of " + n + " is : " + fact.getFactorial(n));

	}

}
