package com.dsandalgo.doublyLinkedList;

//We need to add generic data to our Doubly linked List, like int, float, char
//Hence, we will add <T> to our interface
public interface DoublyList<T> {
	
	// We will define some methods for our LinkedList
	public void insert(T data);
	public void remove(T data);
	public void traverseFromHeadToTail();
	public void traverseFromTailToHead();
	public int size();
		
	// This DoublyList interface will be inherited by the DoublyLinkedList class that we will make.

}
