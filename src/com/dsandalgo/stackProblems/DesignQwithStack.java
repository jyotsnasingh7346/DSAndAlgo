package com.dsandalgo.stackProblems;

import java.util.Stack;

public class DesignQwithStack {
	
	/*
	 * PROBLEM : Implement Queue - enqueue() & dequeue() using Stack
	 * NAIVE SOLUTION : We can use 2 stacks, 1 for enqueue, enqueueStack() & another for dequeue, dequeueStack()
	 * 
	 * */
	
	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;
	
	public DesignQwithStack() {
		super();
		this.enqueueStack = new Stack<>();
		this.dequeueStack = new Stack<>();
	}
	
	public void enqueue(int item) {
		this.enqueueStack.push(item);
	}
	
	public int dequeue() {
		
		// 1. If both the stacks are empty.
		if(enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		
		// 2. If only dequeueStack is empty.
		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		
		// 3. pop from dequeueStack
		return dequeueStack.pop();
		
	}

}
