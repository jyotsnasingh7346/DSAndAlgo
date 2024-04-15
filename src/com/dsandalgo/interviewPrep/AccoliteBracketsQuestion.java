package com.dsandalgo.interviewPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AccoliteBracketsQuestion {

	public static void main(String[] args) {
		
		// Given a String s containing just the characters str = "(,),{,},[,]"
		// Determine if the string is valid
		// Valid if : 
			// 1. Open brackets must be closed by the same type of brackets
			// 2. Open brackets must be closed in the correct order
			// 3. Every close bracket must have a corresponding open bracket
		
		// Solution : 
		// we can use a hash map to store brackets as key value pairs
		// we can use a stack, pop() every time a close is encountered
		
		String str = "{,(,[,(,),],),}";
		
		if (isValid(str)) { 
			System.out.println(str + " is valid.");
		} else {
			System.out.println(str + " is NOT valid.");
		}
		
	}

	private static boolean isValid(String str) {
		Stack<String> stack = new Stack<>();
		
		String[] arr = str.split(",");
		
		Map<String, String> map = new HashMap<>();
		map.put("(", ")");
		map.put("[", "]");
		map.put("{", "}");
		
		for (String c : arr) {
			if (c.equals("(") || c.equals("[") || c.equals("{")) {
				System.out.println("Element being pushed - " + c);
				stack.push(c);
			} else {
				String temp = stack.pop(); // (
				
				System.out.println("Element found - " + c);
				System.out.println("Element being popped, temp - " + temp);
				
				if (map.containsKey(temp) && !map.get(temp).equals(c)) {
					System.out.println("Not matching : " + map.get(temp) + " : " + c);
					return false;
				} else {
					System.out.println("Matching");
				}
			}
		}
		if (stack.size()!= 0) {
			return false;
		}
		
		return true;
	}

}
