package com.dsandalgo.array;

public class ReverseInteger {

	public int reverseInteger (int number) {
		int remainder = 0;
		int reversed = 0;
		
		while (number > 0) {
			remainder = number % 10;
			number = number / 10;
			reversed = reversed * 10 + remainder;
		}
		
		return reversed;
	}
	
}
