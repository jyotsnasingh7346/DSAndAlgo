package com.dsandalgo.binarysearchtree;

public class Node<T> {
	
	// Each node in the BST can have,
	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;
	private Node<T> parentNode;		// we need a reference to the parent node as well, for during insertion & removal.
	
	public Node(T data, Node<T> parentNode) {
		super();
		this.data = data;
		this.parentNode = parentNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return "" + data;
	}
	
	

}
