package com.dsandalgo.interviewPrep;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
	
	public static void main(String[] args) {
		String num = "nine three two Tripple one zero nine double one";
		num = num.toLowerCase();
		System.out.println(num);
		
		String num1 = "nine three two tripple one Double one zero nine";
		num1 = num1.toLowerCase();
		System.out.println(num1);
		
		String number = convert(num);
		String number1 = convert(num1);
		
		System.out.println(number);
		System.out.println(number1);
	}

	private static String convert(String str) {
		String ans = "";
		String[] arr = str.split(" ");
		
		Map<String, String> number = new HashMap<>();
		number.put("zero", "0");
		number.put("one", "1");
		number.put("two", "2");
		number.put("three", "3");
		number.put("four", "4");
		number.put("five", "5");
		number.put("six", "6");
		number.put("seven", "7");
		number.put("eight", "8");
		number.put("nine", "9");
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals("double")) {
				ans = ans + number.get(arr[i+1]) + number.get(arr[i+1]);
				i++;
			} else if (arr[i].equals("tripple")) {
				ans = ans + number.get(arr[i+1]) + number.get(arr[i+1]) + number.get(arr[i+1]);
				i++;
			} else {
				ans = ans + number.get(arr[i]);
			}
		}
		
		return ans;
	}

}
