package com.dsandalgo.stackWithLinkedList;

public class Stack<T> implements StackMethods<T> {
	
	/*
	 * ALL the operations in a Stack with LL takes RTC = O(1) because we only have to manipulate the rootNode.
	 * */
	
	// WE ALWAYS HAVE THE HEAD (root node) OF THE DS.
	private Node<T> head;	// also known as the root node.
	private int count;		// returns the number of nodes in the stack.
	
	@Override
	public void push(T data) {
		// RTC : O(1)
		
		// Scenario 01 : There are no nodes in the LL
		if (head == null)
			head = new Node<>(data);
		else {
			// Scenario 02 : There are nodes in the LL
			Node<T> oldHead = head;
			head = new Node<>(data);
			head.setNextNode(oldHead);
			
		}
		
		count++;
		
	}

	@Override
	public T pop() {
		// RTC : O(1)
		
		// Scenario 01 : LL is empty
		if (isEmpty()) return null;
		
		// Scenario 02 : LL has nodes, remove the head & set its nextNode as the new head
		T item = head.getData();
		head = head.getNextNode();
		count--;
		
		return item;
	}

	@Override
	public int size() {
		// RTC : O(1)
		return count;
	}

	@Override
	public boolean isEmpty() {
		// RTC : O(1)
		return count == 0;
	}

}
