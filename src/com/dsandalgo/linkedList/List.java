package com.dsandalgo.linkedList;

// We need to add generic data to our Linked List, like int, float, char
// Hence, we will add <T> to our interface
public interface List<T> {
	
	// We will define some methods for our LinkedList
	public void insert(T data);
	public void remove(T data);
	public void traverse();
	public int size();
	public void reverseLLInPlace();
	// Make this method in the LinkedList.java class -> public Node<T> getMiddleNode();
	
	// This List interface will be inherited by the LinkedList class that we will make.

}
