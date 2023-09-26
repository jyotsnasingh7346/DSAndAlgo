package com.dsandalgo.linkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	// A LinkedList always has access to the root node.
	private Node<T> head;		// Also called as the root node.
	private int noOfNodes;		// This will return the number of node in the LinkedList.
	
	@Override
	public void insert(T data) {
		
		// Scenario 01 : There are no nodes in the LL.
		if (head == null) {
			head = new Node<T>(data);
			noOfNodes++;
		} else {
			// Scenario 02 : There is one or more nodes in the LL.
			// Now, we can insert at the beginning or at the end.
			// 1. Beginning of the LL.
			// insertAtTheBeginning(data);
			
			// 2. End of the LL.
			insertAtTheEnd(data, head);
		}
		
	}

	private void insertAtTheEnd(T data, Node<T> node) {
		// RTC = O(N);
		// For inserting a node at the end, we will have to traverse till the end of the LL,
		// i.e Find the node pointing to null, This takes O(1)
		// We have to find the last node, set its nextNode as our new node instead of null, and have our new node point to null.
		
		// Step 01 : Lets traverse till we find the last node (node with reference as null)
		if (node.getNextNode() != null) {
			insertAtTheEnd(data, node.getNextNode());
		} else {
			// We have found the node with reference as null.
			Node<T> newNode = new Node<T>(data);
			node.setNextNode(newNode);
			newNode = null;
			noOfNodes++;
		}
	}

	private void insertAtTheBeginning(T data) {
		// RTC = O(1);
		// For inserting a node at the beginning, we only have to update the references.
		// Here, the new node will be the head.
		
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(head);
		head = newNode;
		noOfNodes++;
	}

	@Override
	public void remove(T data) {
		
		// Scenario 01 : There are no nodes in the LL.
		if (head == null) return;
		
		// Scenario 02 : There is only one node in the LL, we need to check if it has the data which we need to delete.
		// For using the compareTo(), we have extended the Comparable Interface.
		if (head.getData().compareTo(data) == 0) {
			head = head.getNextNode();
			noOfNodes--;
		} else {
			// Scenario 03 : There is more than one nodes and we want to remove one of them.
			// Find the node & remove it.
			remove(data, head, head.getNextNode());
		}
	}

	private void remove(T data, Node<T> previousNode, Node<T> currentNode) {
		
		// We have to find the node we want to remove.
		while (currentNode != null) {
			
			// This is the node we want to remove.
			if (currentNode.getData().compareTo(data) == 0) {
				
				// update the references
				previousNode.setNextNode(currentNode.getNextNode());
				noOfNodes--;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
	}

	@Override
	public void traverse() {
		
		// Scenario 01 : There are no nodes in the LL.
		if (head == null) return;
		
		// Scenario 02 : There is one or more nodes in the LL.
		Node<T> currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode);
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}

	@Override
	public int size() {
		return noOfNodes;
	}

	@Override
	public void reverseLLInPlace() {
		/*
		 * OVERVIEW : Construct an in-place algorithm (without the need of extra memory) to reverse a LinkedList
		 * For example : 1->2->3->4 should be transformed to 4->3->2->1
		 * 
		 * SOLUTION : We will need 3 pointers (currentNode, previousNode & nextNode)
		 * We will iterate till the currentNode doesnt become null 1.e, to the end of the LL.
		 * */
		
		Node<T> currentNode = this.head;
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		this.head = previousNode;
		
	}
	
	 public Node<T> getMiddleNode() {
		 
		 // null<--O-->O-->O-->null
		 
		// Scenario 01 : There are no nodes in the LL.
		if (head == null) return null;
			
		// Scenario 02 : There is one or more nodes in the LL.
		Node<T> slower = this.head;		// hops 1 step at a time.
		Node<T> faster = this.head;		// hops 2 steps at a time.
		
		// Run Time Complexity = O(N/2) = O(N) Linear RTC
		while (faster.getNextNode() != null && faster.getNextNode().getNextNode() != null) {
			slower = slower.getNextNode();
			faster = faster.getNextNode().getNextNode();
		}
		 
		return slower;
	 }

}
