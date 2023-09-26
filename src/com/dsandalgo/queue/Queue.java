package com.dsandalgo.queue;

public class Queue<T extends Comparable<T>> {
	
	// In Queues, we follow FIFO - FIRST IN FIRST OUT
	
	// A queue has a head & a tail, and we should have access to it.
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	// There can be 4 basic functions on a queue : enqueue, dequeue, size, isEmpty
	
	public void enqueue(T data) {
		// RTC O(1)
		
		if (isEmpty()) {
			this.firstNode = new Node<>(data);
			this.lastNode = this.firstNode;
		} else {
			Node<T> oldLastNode = this.lastNode;
			this.lastNode = new Node<>(data);
			this.lastNode.setNextNode(null);
			oldLastNode.setNextNode(this.lastNode);
		}
		
		this.count++;
		
	}

	public T dequeue() {
		// RTC O(1)
		// In Queues, we follow FIFO, we remove the element that was first inserted.
		
		T dataToRemove = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		
		if (isEmpty()) {
			this.lastNode = null;
		}
		
		this.count--;
		
		return dataToRemove;
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
}
