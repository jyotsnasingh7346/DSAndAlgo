package com.dsandalgo.doublyLinkedList;

public class Node<T extends Comparable<T>> {

	/*
	 * A regular node has 2 things, data & a reference to the next node.
	 * But a doubly linked list node has 3 things, data, reference to the next node & reference to the previous node.
	 * 
	 * */
	
	private T data;
	private Node<T> previousNode;
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

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
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
