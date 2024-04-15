package com.dsandalgo.interviewPrep;

public class MorganStanleyAnagramQuestion1 {

	/*
	 * An anagram is a sequence of numbers that can be formed by rearranging the digits of a string. 
	 * Given a string that consists of only digits, modify the first half of the string. 
	 * so that it is an anagram of the second half. 
	 * Determine the minimum number of operations needed to complete the task.  
	 * The following is one operation:  
			- Replace any digit in the string with any other digit (0-9).  
  
			Example   s = "123122"
 
		The first half is '123' and the second half is '122'. 
		Change the 3 in the first half to 2 , resulting in '122', an anagram of the second half.

	 */
	
	// THIS SOLUTION IS NOT CORRECT, OUTPUT SHOULD BE 4
	
	public static void main(String[] args) {
		
		String s = "123122";
		System.out.println("Anagram : " + getAnagram(s));

	}

	private static int getAnagram(String s) {
		int count = 0;
		int len = s.length()/2;
		
		for (int i=0, j=len/2; i<j && j<len; i++, j++) {
			if (s.charAt(i) != s.charAt(j))
				count++;
		}
		
		return count;
	}

}
