package com.dsandalgo.ibmprep;

public class GeneratePassword {

	public static void main(String[] args) {
		
		/*
		 * QUESTION : You are given a password in ASCII characters (2 or 3 digits), in reverse order.
		 * TO DO : Generate the correct password
		 * NOTE : The password only has alphabets and blank spaces.
		 */
		
		/*
		 * SAMPLE INPUT : String input = "796115110113721110141108";
		 * OUTPUT : PrepInsta
		 */
		
		/*
		 * STEP 1 : Reverse the string, 
		 * STEP 2 : Check if the 2 digits can be converted to char, if not, try 3 digits.
		 * STEP 3 : Append in a string 
		 */
		
		String input = "796115110113721110141108";
		System.out.println(input);
		
		// STEP 01
		input = reverse(input);
		System.out.println(input);
		
		// STEP 02 & 03
		input = generatePassword(input);
		System.out.println(input);
	}

	private static String generatePassword(String input) {
		String result = "";
		String current = "";
		
		// use while loop as we dont know how many iterations it will be
		int i=0;
		while (i < input.length()-1) {
			current = "";
			current = "" + input.charAt(i) + input.charAt(i+1);
			int x = Integer.parseInt(current);
			
			if (x == 32)
				result = result + " ";
			else if ((x >= 65 && x <= 91) || (x >= 97 && x <= 100)) {
				result = result + (char) x;
			} else {
				if (i + 2 < input.length()) {
					current = current + input.charAt(i+2);
					x = Integer.parseInt(current);
					result = result + (char) x;
					i = i + 1;
				}
			}
			i = i+2;
		}
		
		return result;
	}

	private static String reverse(String input) {
		StringBuilder sb = new StringBuilder("");
		
		char[] arr = input.toCharArray();
		
		for (int i=input.length()-1; i>=0; --i) {
			sb.append(arr[i]);
		}
		
		return sb.toString();
	}

}
