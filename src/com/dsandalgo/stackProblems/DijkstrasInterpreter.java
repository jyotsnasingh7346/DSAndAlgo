package com.dsandalgo.stackProblems;

import java.util.Stack;
import java.util.regex.Pattern;

public class DijkstrasInterpreter {
	
	/*
	 * This is one of the applications of STACKS.
	 * 
	 * -- STACKS as Interpreters --
	 * 
	 * -- PARSING WITH STACKS --
	 * Interpreters have the ability to interpret the code.
	 * Stacks are very useful when parsing huge XML files with SAX or STAX.
	 * 
	 * This is SHUNTING YARD ALGORITHM (constructed by DIJKSTRA)
	 * It's a method for parsing mathematical expressions with the help of stack abstract data types.
	 * 
	 * The algorithm maintains multiple stacks 
	 * 		> the operation stack & 
	 * 		> the value stack.
	 * */

	private Stack<String> operationStack;
	private Stack<Double> valueStack;
	
	public DijkstrasInterpreter() {
		this.operationStack = new Stack<>();
		this.valueStack = new Stack<>();
	}
	
	public void interpretExpression(String exp) {
		String[] expArray = exp.split(" ");
		
		for (int i=0; i<expArray.length; i++) {
			System.out.print(expArray[i]);
		}
		
		for (String s : expArray) {
			
			if (s.equals("(")) {
				// do nothing
			} else if (Pattern.matches("[+-///*]?", s)) {
				
				// add the operator in the operation stack
				this.operationStack.push(s);
				this.operationStack.peek();
				
			} else if (checkIfDouble(s)) {
				
				// add the double value in the value stack
				this.valueStack.push(Double.parseDouble(s));
				this.valueStack.peek();
				
			} else if (s.equals(")")) {
				
				/*
				 * Perform the operation here : 
				 * 
				 * pop() the last 2 values from the valueStack and last 1 operator from the operation stack
				 * and calculate the result.
				 * Also, if the operation is minus or division, handle the operation.
				 * 
				 * */
				
				String operator = this.operationStack.pop();
				Double topOfStack = this.valueStack.pop();
				Double bottomStack = this.valueStack.pop();
				
				if (operator.equals("-")) {
					System.out.println("Performing - on : " + bottomStack + " and " + topOfStack);
					this.valueStack.push(bottomStack - topOfStack);
					this.valueStack.peek();
				} else if (operator.equals("/")) {
					System.out.println("Performing / on : " + bottomStack + " and " + topOfStack);
					this.valueStack.push(bottomStack / topOfStack);
					this.valueStack.peek();
				} else if (operator.equals("+")) {
					System.out.println("Performing + on : " + bottomStack + " and " + topOfStack);
					this.valueStack.push(bottomStack + topOfStack);
					this.valueStack.peek();
				} else if (operator.equals("*")) {
					System.out.println("Performing * on : " + bottomStack + " and " + topOfStack);
					this.valueStack.push(bottomStack * topOfStack);
					this.valueStack.peek();
				}
				
			}
			
		}
		
	}

	private boolean checkIfDouble(String s) {
		try {
			Double.parseDouble(s);
			System.out.print(s + " is double");
			System.out.println();
			return true;
		} catch (NumberFormatException e) {
			// do nothing
		}
		
		return false;
	}
	
	public void result() {
		System.out.println(this.valueStack.pop());
	}
	
}
