package com.dsandalgo.interviewPrep;

public class MorganStanleyCountValidSubstrings {

	/*
	 * A substring is a group of contiguous characters in a string. 
	 * For instance, all substrings of abc are [a, b, c, ab, bc, abc].
	 * Given a binary representation of a number, 
	 * write a java code to determine the total number of substrings present 
	 * that match the following conditions:
		The 0s and 1s are grouped consecutively (e.g., 01, 10, 0011, 1100,000111, etc.).
		The number of 0s in the substring is equal to the number of 1's in the substring.
	 */
	
	// This solution is wrong
	
	
	public static int countValidSubstrings(String binaryString) {
	    int totalValid = 0;
	    int currentStart = 0;

	    for (int i = 0; i < binaryString.length(); i++) {
	      char currentChar = binaryString.charAt(i);

	      // Check if current character breaks the pattern or is the end
	      if (!Character.isDigit(currentChar) || (i > 0 && currentChar != binaryString.charAt(i - 1))) {
	        // Check if current substring is valid (equal number of 0s and 1s)
	        if (isValidSubstring(binaryString.substring(currentStart, i))) {
	          totalValid++;
	        }
	        currentStart = i;
	      }
	    }

	    // Check the last substring
	    if (isValidSubstring(binaryString.substring(currentStart))) {
	      totalValid++;
	    }

	    return totalValid;
	  }

	  private static boolean isValidSubstring(String substring) {
	    int count0 = 0;
	    int count1 = 0;
	    for (char ch : substring.toCharArray()) {
	      if (ch == '0') {
	        count0++;
	      } else if (ch == '1') {
	        count1++;
	      }
	    }
	    return count0 == count1;
	  }

	  public static void main(String[] args) {
	    String binaryString = "001101";
	    int validSubstrings = countValidSubstrings(binaryString);
	    System.out.println("Total valid substrings: " + validSubstrings); // Output: 4
	  }
	}