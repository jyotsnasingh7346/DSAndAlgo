package com.dsandalgo.string;

public class Anagrams {

	/*
	 * TASK : 		 Construct an algorithm to check whether two words are anagrams or not.
	 * 
	 * EXPLANATION : An ANAGRAM is a word or a phrase formed by rearranging the letters of a different word or a phrase, 
	 * 				 typically using all the original letters, exactly once.
	 * 
	 * EXAMPLE : 	 restful & fluster are anagrams.
	 * 
	 * ALGORITHM : 	 3 steps only.
	 * 
	 * 				 STEP 01 : If the size of both of the strings is same, Go to STEP 02. Else, 'Not Anagrams'.
	 * 				 STEP 02 : Create 2 256bit arrays & increment the value on ASCII positions of the letter you find.
	 * 				 STEP 03 : Iterate through both the arrays, & if the letters are not the same at any point,
	 * 							then return false, else true.
	 * */
	
	public boolean isAnagram(String one, String two) {
		
		one = one.toUpperCase();
		two = two.toUpperCase();
		
		// STEP 01 : Check length
		if (one.length() == two.length()) {
			
			// STEP 02 : Create 2 256bit arrays
			int a[] = new int[256];
			int b[] = new int[256];
			
			for (int i=0; i<one.length(); i++) {
				a[(int) one.charAt(i)] += 1;
				b[(int) two.charAt(i)] += 1;
			}
			
			// STEP 03 : Iterate & return false if letters are not same
			for (int i=0; i<256; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Anagrams isAnagram = new Anagrams();

		String one = "fluster";
		String two = "restful";
		
		System.out.println("Are " + one + " and " + two + " anagrams ? : " + isAnagram.isAnagram(one, two));
		
		
	}
}
