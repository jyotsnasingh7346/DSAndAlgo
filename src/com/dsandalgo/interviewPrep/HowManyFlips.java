package com.dsandalgo.interviewPrep;

public class HowManyFlips {

	public static void main(String[] args) {
		String target = "01011";
		
		int flips = getMinimumFlips(target);
		System.out.println("Minimum flips : " + flips);
	}

	private static int getMinimumFlips(String target) {
		int flipCount = 0;
		char curr = '1';
		
		for (int i = 0; i<target.length(); i++) {
			if (target.charAt(i) == curr) {
				flipCount++;
				 
				/*
				 * if (curr == '1') { curr = '0'; } else { curr = '1'; }
				 */
				
				//If curr is '0' (even), the calculation becomes (0 + 1) % 2 = 1. 
				// Adding 1 to 48 and casting to char results in curr becoming '1'.
				// If curr is '1' (odd), the calculation becomes (1 + 1) % 2 = 0. 
				// Adding 0 to 48 and casting to char keeps curr as '1'.
				
				curr = (char) (48 + ((curr + 1)%2));
			}
		}
		
		return flipCount;
	}

}
