package com.dsandalgo.doublyLinkedList;

public class DoublyLinkedList<T extends Comparable<T>> implements DoublyList<T> {
	
	// A doubly linked list has reference of 2 nodes.
	private Node<T> head;
	private Node<T> tail;
	private int noOfNodes;
	
	@Override
	public void insert(T data) {
		
		// 1. We will hold this data in a new node
		Node<T> newNode = new Node<T>(data);
		
		// 2. Check if the first item in the DLL is the newNode
		if (tail == null) {
			// Both the pointers should point to the newNode as its the first node.
			tail = newNode;
			head = newNode;
			noOfNodes++;
		} else {
			// There are one or more nodes in the DLL.
			// Lets follow the standard and append the newNode at the tail.
			// For this, we just need to update the reference.
			// This operation (appending a node at the head/tail) takes O(1) Constant RTC.
			
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
			noOfNodes++;
			
		}
		
		
	}
	@Override
	public void remove(T data) {
		
		// We need to find the node with 'data' to remove it from the DLL.
		// We have access to head & tail node, lets check there first.
		
		if (head.getData().compareTo(data) == 0) {
			// This means the head needs to be removed
			head = head.getNextNode();
			head.setPreviousNode(null);
			noOfNodes--;
		} else if (tail.getData().compareTo(data) == 0) {
			// This means the tail needs to be removed
			tail = tail.getPreviousNode();
			tail.setNextNode(null);
			noOfNodes--;
		} else {
			// RTC = O(1);
			// We need to check the data in between head & tail
			// Lets traverse through the DLL
			
			Node<T> currentNode = head;
			
			while (currentNode != tail.getPreviousNode()) {
				currentNode = currentNode.getNextNode();	// since we know head also doesnt have the 'data'
				
				// check if currentNode holds the data
				if (currentNode.getData().compareTo(data) == 0) {
					// If yes, update the references
					currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
					noOfNodes--;
					break;
				}
				
			}
			
		}
		
	}
	@Override
	public void traverseFromHeadToTail() {
		// from head to tail
		Node<T> currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode + " -> ");
			currentNode = currentNode.getNextNode();
		}
		
	}
	@Override
	public void traverseFromTailToHead() {
		// from tail to head
		Node<T> currentNode = tail;
		while (currentNode != null) {
			System.out.print(currentNode + " <- ");
			currentNode = currentNode.getNextNode();
		}
		
	}
	@Override
	public int size() {
		return noOfNodes;
	}
	
	

}
