package com.dsandalgo.queue;

public class Node<T extends Comparable<T>> {
	
	// At this point, you should know what a node consists of, its 2 things : data & reference to the next node.
	
	private T data;
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
