package com.dsandalgo.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	// We know, that we have an exclusive access to the root node of a BST.
	private Node<T> root;

	// Below is the BST we will try to construct
	// 12
	// 4 20
	// 1 8 16 27

	/********************************************************************************************/
	// NOTE : The below method implementations use stack main memory by recursive
	// function calls.

	private int getTreeSize(Node<T> node) {

		// Size of Tree = size of left subtree + size of right subtree + 1(root node).

		// 1. Check if there are no nodes in the tree.
		if (node == null)
			return 0;

		// 2. Recursively sum up the size of both the subtree & add the root node.
		return (getTreeSize(node.getLeftChild()) + getTreeSize(node.getRightChild()) + 1);
	}

	@Override
	public int getAgeSum() {
		return getAgesInFamilyTree(this.root);
	}

	private int getAgesInFamilyTree(Node<T> root2) {
		// Time complexity in an average scenario : O(LogN)
		// Time complexity in worst case scenario : O(N)
		
		

		return 0;
	}

	@Override
	public Node<T> getKSmallest(Node<T> node, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T data) {

		if (root == null) {
			// This is where we insert a root node to the BST by providing data, parentNode
			// = null of a root node
			root = new Node<T>(data, null);
		} else {
			insert(data, root);
		}

	}

	private void insert(T data, Node<T> node) {
		// a node can be inserted as a left child or a right child

		// 1. when rootNode data > new Node data
		if (node.getData().compareTo(data) > 0) {
			// LEFT SUBTREE
			// We have to check if the left child of this node is not null
			if (node.getLeftChild() != null) {
				// If its not null then that means that there is a valid NOT NULL left child
				// that exists.
				// We have to use recursion and insert the data to this left child's child node.
				insert(data, node.getLeftChild());
			} else {
				// Left child is null, so we create a left child with this data.
				node.setLeftChild(new Node<>(data, node));
			}

		} else {
			// 2. when rootNode data < new Node data
			// RIGHT SUBTREE
			// We have to check if the right child of this node is not null
			if (node.getRightChild() != null) {
				// If its not null then that means that there is a valid NOT NULL right child
				// that exists.
				// We have to use recursion and insert the data to this right child's child
				// node.
				insert(data, node.getRightChild());
			} else {
				// Right child is null, so we create a right child with this data.
				node.setRightChild(new Node<>(data, node));
			}

		}

	}

	@Override
	public void remove(T data) {
		if (root != null) {
			remove(data, root);
		}

	}

	private void remove(T data, Node<T> node) {

		if (node == null)
			return;

		// There can be 3 scenarios
		// 1. When the node data is > than T data.
		if (node.getData().compareTo(data) > 0) {
			// LEFT SUBTREE
			remove(data, node.getLeftChild());

		} else if (node.getData().compareTo(data) < 0) {
			// 2. When the node data is < than T data.
			// RIGHT SUBTREE
			remove(data, node.getRightChild());

		} else {
			// We have found the node we are looking for
			// Here, there can be 4 scenarios

			// 1. REMOVING A LEAF NODE (NODE WITHOUT ANY CHILDREN)
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("----- 1. REMOVING A LEAF NODE -----");

				// We simply inform the parentNode of this leaf node that the child doesn't
				// exist anymore.
				// Update the references.

				Node<T> parent = node.getParentNode();

				// The root node is what we want to remove
				if (parent == null)
					root = null;

				// Check whether the node is the left child or a right child of it's parent
				if (parent != null && parent.getLeftChild() == node) {
					// The node to be removed is the left child of its parent -> Notify the parent
					parent.setLeftChild(null);

				} else if (parent != null && parent.getRightChild() == node) {
					// The node to be removed is the right child of its parent -> Notify the parent
					parent.setRightChild(null);

				}
				// Now we remove the node & make it eligible for GC
				node = null;

			} else if (node.getLeftChild() == null && node.getRightChild() != null) {
				// 2. REMOVING A NODE WITH A SINGLE RIGHT CHILD
				System.out.println("----- 2. REMOVING A NODE WITH A SINGLE RIGHT CHILD -----");

				// When the node to be deleted has a right child
				// We simply inform the parent of this leaf node, to point to its right child
				// Update the references

				Node<T> parent = node.getParentNode();
				// Root node is what we want to remove
				if (parent == null) {
					root = node.getRightChild();
				}

				// Check whether the node is a left child or a right child of its parent.
				if (parent != null && parent.getLeftChild() == node) {
					// The node is a left child -> Notify the parent
					parent.setLeftChild(node.getRightChild());

				} else if (parent != null && parent.getRightChild() == node) {
					// The node is a right child -> Notify the parent
					parent.setRightChild(node.getRightChild());

				}

				// We have to update the right child's parent
				node.getRightChild().setParentNode(parent);
				node = null;

			} else if (node.getLeftChild() != null && node.getRightChild() == null) {
				// 3. REMOVING A NODE WITH A SINGLE LEFT CHILD
				System.out.println("----- 3. REMOVING A NODE WITH A SINGLE LEFT CHILD -----");

				// When the node to be deleted has a left child
				// We simply inform the parent of this leaf node, to point to its left child
				// Update the references

				Node<T> parent = node.getParentNode();
				// Root node is what we want to remove
				if (parent == null) {
					root = node.getLeftChild();
				}

				// Check whether the node is a left child or a right child of its parent.
				if (parent != null && parent.getLeftChild() == node) {
					// The node is a left child -> Notify the parent
					parent.setLeftChild(node.getRightChild());

				} else if (parent != null && parent.getRightChild() == node) {
					// The node is a right child -> Notify the parent
					parent.setRightChild(node.getRightChild());

				}

				// We have to update the right child's parent
				node.getLeftChild().setParentNode(parent);
				node = null;

			} else {
				// 4. REMOVING A NODE WITH BOTH CHILDREN
				System.out.println("----- 4. REMOVING A NODE WITH BOTH CHILDREN -----");

			}
		}

	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean compareTrees(Node<T> node1, Node<T> node2) {
		// TODO Auto-generated method stub
		return false;
	}

}
