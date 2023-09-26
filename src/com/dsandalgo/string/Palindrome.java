package com.dsandalgo.string;

public class Palindrome {

	/*
	 * Palindrome is a string that reads the same forward & backward.
	 * eg : radar, madam
	 * 
	 * TASK : Check whether the given string is a palindrome or not.
	 * 
	 * */
	
	public boolean isPalindrome(String one) {

		// 1. convert into lowercase
		one = one.toLowerCase();
		
		// 2. convert the string into a character array & remove white spaces
		char[] charOne = one.trim().toCharArray();
		
		
		// 3. create a string builder to append letters from the end of one.
		StringBuilder twosb = new StringBuilder("");
		
		// 4. Iterate through the 1st string, from end to start, append each letter into the twosb string
		for (int i=charOne.length-1; i>=0; i--) {
			twosb.append(charOne[i]);
		}
		
		// 5. store twosb in in a new string
		String two = twosb.toString();
		
		// 6. if both the strings are same & equal, return true, else false
		if (one.equals(two)) {
			return true;
		}
		
		return false;
	}
	
}
