package com.dsandalgo.stackProblems;

import java.util.Stack;

public class DesignQwithStackUsingRecursion {

	/*
	 * PROBLEM : Implement Queue - enqueue() & dequeue() using Stack
	 * 
	 * OPTIMUM SOLUTION : We use only 1 stack,
	 * 
	 * pop() the elements until we get the 1st element & 
	 * push() the previously popped element back in the stack.
	 * 
	 * */
	
	private Stack<Integer> stack;

	public DesignQwithStackUsingRecursion() {
		super();
		this.stack = new Stack<>();
	}
	
	public void enqueue(int item) {
		// RTC : O(1)
		this.stack.push(item);
	}
	
	public int dequeue() {
		
		// 1. If there is only 1 item in the stack, return it
		if (stack.size() == 1)
			return stack.pop();
		
		// 2. We keep popping the items & inserting it back into the stack until we get the bottom into the stack
		int item = stack.pop();
		
		// 3. We call the method recursively
		int lastDequeuedItem = dequeue();
		
		// 4. After we find the bottom most item & pop it, we need to re-insert the other items.
		enqueue(item);
		
		return lastDequeuedItem;
	}
	
	
}
