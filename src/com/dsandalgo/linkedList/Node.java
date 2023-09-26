package com.dsandalgo.linkedList;

public class Node<T extends Comparable<T>> {

	/*
	 * Comparable is an interface in java used to compare the elements.
	 * We are making our class Node generic by extending Comparable interface as Generic.
	 * LinkedLists acquire more memory because every node stores 2 things.
	 * 
	 * */
	
	// 1. Data
	private T data;
	
	// 2. Reference to the next node.
	private Node<T> nextNode;
	
	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return data + " -> ";
	}

	
	
}
