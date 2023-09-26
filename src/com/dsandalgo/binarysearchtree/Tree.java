package com.dsandalgo.binarysearchtree;

public interface Tree<T> {
	
	// NOTE : The below method implementations use stack main memory by recursive function calls.
	public int getAgeSum();
	public Node<T> getKSmallest(Node<T> node, int k);
	public T getMin();
	public T getMax();
	
	// Below methods can also be used for AVL Trees.
	public void insert(T data);
	public void remove(T data);
	public void traverse();		// In-order traversal as it yields natural ordering (sorted in nature).
	public Node<T> getRoot();
	public boolean compareTrees(Node<T> node1, Node<T> node2);

}
