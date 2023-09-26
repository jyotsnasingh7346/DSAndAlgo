package com.dsandalgo.stackProblems;

import java.util.Stack;

public class MaxInStack {

	/*
	 * PROBLEM : Return the maximum element in a stack in O(1) RTC & O(N) Space Complexity.
	 * 
	 * DISCUSSION : We know that if we apply a loop, it will take O(N)
	 * 
	 * HINT : We can use another stack to track the maximum item.
	 * 
	 * SOLUTION : We can have 2 stacks.
	 * 
	 * 		> problemStack - will contain the integers
	 * 		> solutionStack	- we will push the problemStack.pop() if it is ? solutionStack.pop() in the solutionStack
	 * This will continue till the problemStack is not empty.
	 * result = solutionStack.pop()
	 * 
	 * */
	
	private Stack<Integer> problemStack;
	private Stack<Integer> solutionStack;
	
	public MaxInStack() {
		this.problemStack = new Stack<>();
		this.solutionStack = new Stack<>();
	}
	
	// while pushing in the problemStack, we will push in the solutionStack also
	public void push(int item) { 
		// O(N) Constant RTC
		
		// 1. push the new item into the problemStack
		problemStack.push(item);
		
		// 2. If there is only 1 item in the problemStack, then thats the max element.
		if (problemStack.size() == 1) {
			solutionStack.push(item);
			return;
		}
		
		// 3. If the item is largest one so far, we insert it into the solutionStack.
		if (item > solutionStack.peek()) {
			solutionStack.push(item);
		} else {
			// If its not the largest one so far, we'll duplicate the largest one in solutionStack
			solutionStack.push(solutionStack.peek());
		}
	}
	
	// when removing an item, we remove it from both stacks.
	// This will help in keeping the maxItem in the stack, intact.
	public int pop() {
		solutionStack.pop();
		return problemStack.pop();
	}

	public int getMaxItem() {
		return solutionStack.peek();
	}
	
	/*******************************************ALTERNATE SOLUTION***********************************************/
	public Integer getMaxInStack(Stack<Integer> problemStack) {

		Stack<Integer> solutionStack = new Stack<>();
		solutionStack.push(0);
		
		while (!problemStack.isEmpty()) {
			if (problemStack.peek() > solutionStack.peek()) {
				solutionStack.pop();
				solutionStack.push(problemStack.pop());
			} else {
				problemStack.pop();
			}
		}
		
		return solutionStack.peek();
	}
	
}
