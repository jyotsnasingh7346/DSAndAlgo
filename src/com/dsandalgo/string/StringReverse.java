package com.dsandalgo.string;

public class StringReverse {

	public String getReverse(String str) {
		
		char[] arr = str.trim().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = str.length() - 1; i >= 0; --i) {
			sb.append(arr[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {

		StringReverse rev = new StringReverse();
		String str = "Champagne";
		System.out.println("Reversed of " + str + " is " + rev.getReverse(str));

	}

}
