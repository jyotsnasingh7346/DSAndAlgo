package com.dsandalgo.string;

public class PrimeNumberCheck {

	public boolean isPrime(int n) { 
		
		if (n == 0 || n == 1) {
			return false;
		}
		
		if (n == 2) return true;
		
		for (int i = 2; i < n/2; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		PrimeNumberCheck prime = new PrimeNumberCheck();
		int n = 73;
		
		System.out.println("Is " + n + " a Prime Number ? : " + prime.isPrime(n));

	}

}
