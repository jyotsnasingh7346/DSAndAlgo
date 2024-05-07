package com.dsandalgo.interviewPrep;

import java.util.ArrayDeque;
import java.util.Deque;

public class CiscoBracketsQuestion {

	private static boolean areBracketsBalanced(String expr) {
		
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i=0; i<expr.length(); i++) {
			
			// get charAt(i)
			char x = expr.charAt(i);
			
			// add it in the queue only if its an opening bracket
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			
			// if current bracket is not opening, then it must be a closing bracket.
			// so stack cannot be empty at this point
			
			if(stack.isEmpty())
				return false;
			
			char check = stack.pop();
			switch(x) {
				case ')':
					if (check == '[' || check == '{')
						return false;
					break;
				case ']':
					if (check == '(' || check == '{')
						return false;
					break;
				case '}':
					if (check == '[' || check == '(')
						return false;
					break;
			}
		}
		
		return stack.isEmpty();
	}
	

	public static void main(String[] args) {

		String expr = "([{}])";

		// Function call
		if (areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");

	}

}
