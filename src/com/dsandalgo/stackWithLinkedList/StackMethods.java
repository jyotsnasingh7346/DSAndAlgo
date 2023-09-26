package com.dsandalgo.stackWithLinkedList;

//We need to add generic data to our Stack, like int, float, char
//Hence, we will add <T> to our interface
public interface StackMethods<T> {
	
	// We will define some methods for our LinkedList
	public void push(T data);
	public T pop();
	public int size();
	public boolean isEmpty();
	
	// This StackMethods interface will be inherited by the Stack class that we will make.

}
